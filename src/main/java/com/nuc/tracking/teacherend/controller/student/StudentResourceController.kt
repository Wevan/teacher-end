package com.nuc.tracking.teacherend.controller.student

import com.nuc.tracking.teacherend.po.entity.ResourceLog
import com.nuc.tracking.teacherend.po.record.StudentResource
import com.nuc.tracking.teacherend.repository.StudentRepository
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.FileService
import com.nuc.tracking.teacherend.service.ResourceLogService
import com.nuc.tracking.teacherend.service.StudentService
import com.nuc.tracking.teacherend.service.student.*
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.sql.Date

@RestController
@RequestMapping("/sturesource")
class StudentResourceController {
    @Autowired
    private lateinit var studentResourceService: StudentResourceService
    @Autowired
    private lateinit var studentRepository: StudentRepository
    @Autowired
    private lateinit var fileService: FileService
    @Autowired
    private lateinit var resourceLogService: ResourceLogService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertRecord(@RequestBody studentResource: StudentResource): Result {
        //资源记录
        val msg = studentResourceService.save(studentResource)
        var resourceLog = ResourceLog()
        resourceLog.resourceId = studentResource.resourceId
        resourceLog.name = fileService.findOne(studentResource.resourceId).name
        resourceLog.studentId = studentRepository.findByStudentNumber(studentResource.studentId.toString())!!.userId
        resourceLog.time = Date(System.currentTimeMillis()).time
        resourceLogService.saveOne(resourceLog)
        return ResultUtils.success(200, "插入记录成功", msg)
    }

    @GetMapping("/findByResource")
    fun findByResourceId(resourceId: Long, studentId: Long): Result {
        val msg = studentResourceService.findByResourceIdAndStudentId(resourceId, studentId)
        return ResultUtils.success(200, "查找成功", msg)
    }

}