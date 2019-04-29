package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.impl.TeacherServiceImpl
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 学生信息查询
 */
@RestController
@RequestMapping("/teacher")
class TeacherController {
    @Autowired
    private lateinit var teacherService:TeacherServiceImpl

    /**
     * 获取用户信息
     * @param jobNumber 工号
     * @return 返回结果
     */
    @GetMapping("/detail")
    fun getOne(jobNumber: String): Result {
        val teacher = teacherService.findOne(jobNumber)
        return ResultUtils.success(200, "查找成功", teacher)
    }
}