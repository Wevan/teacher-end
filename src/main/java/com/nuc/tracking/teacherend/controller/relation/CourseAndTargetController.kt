package com.nuc.tracking.teacherend.controller.relation

import com.nuc.tracking.teacherend.po.relation.CourseAndTarget
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.relation.CourseAndTargetService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/courseAndTarget")
class CourseAndTargetController {
    @Autowired
    private lateinit var courseAndTargetService: CourseAndTargetService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCourseAndTarget(@RequestBody courseAndTarget: CourseAndTarget): Result {
        val msg = courseAndTargetService.save(courseAndTarget)
        return ResultUtils.success(200, "插入成功", msg)
    }
}