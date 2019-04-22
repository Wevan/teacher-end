package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.StudentGraduateService
import com.nuc.tracking.teacherend.service.StudentService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 学生信息查询
 */
@RestController
@RequestMapping("/student")
class StudentContoller {
    @Autowired
    private lateinit var studentService: StudentService
    @Autowired
    private lateinit var studentGraduateService: StudentGraduateService

    /**
     * 获取用户信息
     * @param studentNumber 学号1713010101
     * @return 返回结果
     */
    @GetMapping("/detail")
    fun getOne(studentNumber: String): Result {
        val student = studentService.findOne(studentNumber)
        println("In studentContll get $studentNumber")
        return ResultUtils.success(200, "获取成功", student)
    }


    /**
     * 获取毕业达成度
     */
    @GetMapping("/graduate")
    fun getGraduate(studentNumber: Long): Result {
        var graduate=studentGraduateService.findByStudentNumber(studentNumber)
        return ResultUtils.success(200, "获取成功", graduate)
    }
}