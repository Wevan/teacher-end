package com.nuc.tracking.teacherend.controller.student

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.student.StudentGlobalWayService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/studentGlobalWay")
class StudentGlobalWayController {
    @Autowired
    private lateinit var studentGlobalWayService: StudentGlobalWayService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertGlobalWay(@RequestBody file: MultipartFile, courseId: Long, typeTest: String): Result {
        println("StudentGlobalWay get param courseId $courseId")
        val msg = studentGlobalWayService.save(file, courseId, typeTest)
        return ResultUtils.success(200, "插入记录成功", msg)
    }
}