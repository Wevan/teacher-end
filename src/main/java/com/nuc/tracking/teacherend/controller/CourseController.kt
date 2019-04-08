package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.po.entity.Course
import com.nuc.tracking.teacherend.service.relation.CourseService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 课程信息操作
 */

@RestController
@RequestMapping("/course")
class CourseController {
    @Autowired
    private lateinit var courseService: CourseService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertClass(@RequestBody course: Course): Result {
        val msg = courseService.save(course)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteOne(@PathVariable id:Long):Result{
        val msg=courseService.deleteById(id)
        return ResultUtils.success(200,"删除成功",msg)
    }

    @GetMapping("/findOne/{id}")
    fun findOne(@PathVariable id:Long):Result{
        val msg=courseService.findOne(id)
        return ResultUtils.success(200,"查找成功",msg)
    }

    @GetMapping("/findAll")
    fun findAll():Result{
        val msg=courseService.findAll()
        return ResultUtils.success(200,"查找成功",msg)
    }

    @GetMapping("/findByLevel/{level}")
    fun findByLevel(@PathVariable level:String):Result{
        val msg=courseService.findByLevel(level)
        return ResultUtils.success(200,"查找成功",msg)
    }
}