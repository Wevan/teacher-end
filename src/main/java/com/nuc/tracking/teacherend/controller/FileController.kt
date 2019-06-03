package com.nuc.tracking.teacherend.controller


import com.nuc.tracking.teacherend.po.entity.CoursePersonal
import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.repository.student.StudentCourseRepository
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.FileService
import com.nuc.tracking.teacherend.service.student.StudentCourseService
import com.nuc.tracking.teacherend.util.PathUtils
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.sql.Date
import java.sql.Timestamp

@RestController
@RequestMapping("/resource")
class FileController {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    @Autowired
    private lateinit var fileService: FileService
    @Autowired
    private lateinit var studentCourseRepository: StudentCourseRepository

    @RequestMapping("/file")
    fun fileUpload(@RequestParam fileList: Array<MultipartFile>, knowledgeId: Long, courseId: Long, type: Long): Result {
        var resourceList = ArrayList<ResourceDirctoryFile>()
        fileList.forEach {
            logger.info("file ${it.originalFilename}")
            val filePath = PathUtils.rootPath() + "/refile/${it.originalFilename}"
            val file = File(filePath)
            if (!file.exists()) {
                val parent = file.parent
                println("File Parent is $parent")
                File(parent).apply {
                    this.mkdir()
                }
            }
            file.writeBytes(it.bytes)
            val resourceDirctoryFile = ResourceDirctoryFile()
            resourceDirctoryFile.knowledgeId = knowledgeId
            resourceDirctoryFile.courseId = courseId
            resourceDirctoryFile.name = it.originalFilename
            resourceDirctoryFile.type = type
            resourceDirctoryFile.url = filePath
            resourceDirctoryFile.addtime = System.currentTimeMillis().toLong()
            resourceList.add(resourceDirctoryFile)
        }
        fileService.saveAllFile(resourceList, type, knowledgeId)
        return ResultUtils.success(200, "file save success")
    }

    @GetMapping("/list")
    fun getList(courseId: Long, classId: Long): Result {
        logger.info("getList is $courseId,classId is $classId")
        val list = fileService.findAll(courseId, classId)
        return ResultUtils.success(200, "get list suc", list)
    }

    @DeleteMapping("/deleteOne")
    fun deleteById(id: Long, type: Long, knowledgeId: Long): Result {
        println("Delete get knowledgeId $knowledgeId,type $type,id $id")
        fileService.deleteById(id, type, knowledgeId)
        return ResultUtils.success(200, "delete done")
    }

    @GetMapping("/detail")
    fun findOne(id: Long): Result {
        val resource = fileService.findOne(id)
        return ResultUtils.success(200, "find one detail", resource)
    }

    @GetMapping("/downloadFile")
    fun downloadFile(id: Long): ResponseEntity<InputStreamResource> {
        val resourceFile = fileService.findOne(id)
        val filePath = resourceFile.url
        println("被下载的文件信息为$filePath")
        val file = FileSystemResource(filePath!!)
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.filename))
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(InputStreamResource(file.inputStream))
    }

    @GetMapping("/getPdf")
    fun getPdf(id: Long): ResponseEntity<InputStreamResource> {
        val resourceFile = fileService.findOne(id)
        val filePath = resourceFile.url
        val file = FileSystemResource(filePath!!)
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.filename))
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(InputStreamResource(file.inputStream))
    }

    @GetMapping("/getVideo")
    fun getVideo(id: Long): ResponseEntity<InputStreamResource> {
        val resourceFile = fileService.findOne(id)
        val filePath = resourceFile.url
        val file = FileSystemResource(filePath!!)
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.filename))
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")
        println("video文件信息为$filePath")

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(InputStreamResource(file.inputStream))
    }

    @GetMapping("/playTimes")
    fun playTimes(id: Long): Result {
        println("Get playtime id is $id")
        fileService.playTimes(id)
        return ResultUtils.success(200, "播放量更新成功")
    }

    /**
     * 此处的studentId为1713010101型
     */
    @GetMapping("/getTqPercent")
    fun getTqPercent(courseId: Long, classId: Long, studentId: Long): Result {
        val msg = CoursePersonal()
        msg.tqPercent = fileService.getTqPercent(courseId, classId)
        val percent = studentCourseRepository.findByCourseIdAndStudentId(courseId, studentId)?.percent
        if (percent != null) {
            msg.selfPercent = percent
        }
        return ResultUtils.success(200, "获取同期达标度成功", msg)
    }

    /**
     * 获得单门课程的同期达标度
     */
    @GetMapping("/getCourseTqPercent")
    fun getCourseTqPercent(courseId: Long, classId: Long): Result {
        val msg =  fileService.getTqPercent(courseId, classId)
        return ResultUtils.success(200, "获取同期达标度成功", msg)
    }
}