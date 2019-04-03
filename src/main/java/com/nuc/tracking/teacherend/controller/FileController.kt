package com.nuc.tracking.teacherend.controller


import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.FileService
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

@RestController
@RequestMapping("/resource")
class FileController {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)
    @Autowired
    private lateinit var fileService: FileService

    @PostMapping("/file")
    fun fileUpload(@RequestBody file: MultipartFile, chapterId: Long, courseId: Long): Result {
        logger.info("file is $file,$chapterId")
        var resourceDirctoryFile = ResourceDirctoryFile()
        resourceDirctoryFile.chapterId = chapterId
        resourceDirctoryFile.courseId = courseId
        resourceDirctoryFile.name = file.name
        val flag = fileService.getFile(resourceDirctoryFile, file)
        logger.info("result is $flag")
        var list = fileService.findAll()
        return ResultUtils.success(200, "file save success",list)
    }

    @GetMapping("/list")
    fun getList(courseId: Long): Result {
        logger.info("getList is $courseId")

        var list = fileService.findAll()
        return ResultUtils.success(200, "get list suc", list)
    }

    @DeleteMapping("/deleteOne")
    fun deleteById(id: Long): Result {
        fileService.deleteById(id)
        var list = fileService.findAll()
        return ResultUtils.success(200, "delete done",list)
    }

    @GetMapping("detail")
    fun findOne(id: Long): Result {
        var resource = fileService.findOne(id)
        return ResultUtils.success(200, "find one detail", resource)
    }

    @GetMapping("/downloadFile")
    fun downloadFile(id: Long): ResponseEntity<InputStreamResource> {
        var resourceFile=fileService.findOne(id)
        val filePath = resourceFile.url
        println("被下载的文件信息为"+filePath)
        val file = FileSystemResource(filePath)
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
        var resourceFile=fileService.findOne(id)
        val filePath = resourceFile.url
        val file = FileSystemResource(filePath)
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
        var resourceFile=fileService.findOne(id)
        val filePath = resourceFile.url
        val file = FileSystemResource(filePath)
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.filename))
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")
        println("video文件信息为"+filePath)

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(InputStreamResource(file.inputStream))
    }

}