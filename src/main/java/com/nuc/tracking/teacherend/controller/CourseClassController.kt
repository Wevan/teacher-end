package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.CourseClassService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/courseclass")
class CourseClassController {
    @Autowired
    private lateinit var courseClassService: CourseClassService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/list")
    fun findAll(courseId: Long, teacherId: Long): Result {
        println("CourseClass get cid$courseId,tid $teacherId")
        val msg = courseClassService.findAllByTeacherIdAndCourseId(teacherId, courseId)
        return ResultUtils.success(200, "查找成功", msg)
    }
}