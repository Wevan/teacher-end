package com.nuc.tracking.teacherend.controller.teacher

import com.nuc.tracking.teacherend.po.entity.CourseTarget
import com.nuc.tracking.teacherend.po.teacher.CourseTargetRes
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.point.CourseService
import com.nuc.tracking.teacherend.service.point.CourseTargetService
import com.nuc.tracking.teacherend.service.teacher.CollegeService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 课程目标管理
 */

@RestController
@RequestMapping("/courseTarget")
class CourseTargetController {
    @Autowired
    private lateinit var courseTargetService: CourseTargetService
    @Autowired
    private lateinit var collegeService: CollegeService
    @Autowired
    private lateinit var courseService: CourseService

    @PostMapping("/insert")
    fun insertCourseTarget(@RequestBody courseTargetList: List<CourseTarget>): Result {
        courseTargetService.saveAll(courseTargetList)
        val res = ArrayList<CourseTargetRes>()
        val targetList = courseTargetService.findAll()
        targetList.forEach { (key, value) ->
            val courseTargetRes = CourseTargetRes()
            courseTargetRes.courseName=courseService.findOne(key).name
            courseTargetRes.courseTargetList=value
            res.add(courseTargetRes)
        }
        return ResultUtils.success(200, "插入成功", res)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val res = ArrayList<CourseTargetRes>()
        val targetList = courseTargetService.findAll()
        targetList.forEach { (key, value) ->
            val courseTargetRes = CourseTargetRes()
            courseTargetRes.courseName= courseService.findOne(key).name
            courseTargetRes.courseTargetList=value
            res.add(courseTargetRes)
        }
        return ResultUtils.success(200, "获取列表", res)
    }

}