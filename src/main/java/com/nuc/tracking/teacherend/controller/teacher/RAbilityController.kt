package com.nuc.tracking.teacherend.controller.teacher

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.point.RAbilityService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rability")
class RAbilityController {
    @Autowired
    private lateinit var rAbilityService: RAbilityService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/all")
    fun getList(): Result {
        val msg = rAbilityService.getAll(1)
        return ResultUtils.success(200, "获取毕业指标列表", msg)
    }

    @GetMapping("/findByCollegeId")
    fun findByCollegeId(collegeId:Long):Result{
        val msg = rAbilityService.findByCollegeId(collegeId)
        return ResultUtils.success(200, "获取毕业指标列表", msg)
    }

}