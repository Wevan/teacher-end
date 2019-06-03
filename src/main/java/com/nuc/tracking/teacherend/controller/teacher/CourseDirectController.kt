package com.nuc.tracking.teacherend.controller.teacher

import com.nuc.tracking.teacherend.po.teacher.CourseDirect
import com.nuc.tracking.teacherend.po.teacher.CourseDirectResponse
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.teacher.CollegeService
import com.nuc.tracking.teacherend.service.teacher.CourseDirectService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courseDirect")
class CourseDirectController {
    @Autowired
    private lateinit var courseDirectService: CourseDirectService
    @Autowired
    private lateinit var collegeService: CollegeService

    @PostMapping("/insert")
    fun insertCollege(@RequestBody courseDirect: CourseDirect): Result {
        courseDirectService.save(courseDirect)
        val msg = courseDirectService.findAll()
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val temp = courseDirectService.findAll()
        val msg = temp.map {
            var courseDirectResponse = CourseDirectResponse()
            courseDirectResponse.collegeName = collegeService.findOne(it.collegeId).major!!
            courseDirectResponse.courseDirect = it
            return@map courseDirectResponse
        }
        return ResultUtils.success(200, "获取列表", msg)
    }
}