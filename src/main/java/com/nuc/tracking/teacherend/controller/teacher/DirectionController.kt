package com.nuc.tracking.teacherend.controller.teacher

import com.nuc.tracking.teacherend.po.entity.Direction
import com.nuc.tracking.teacherend.po.teacher.DirectionResponse
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.teacher.CollegeService
import com.nuc.tracking.teacherend.service.teacher.DirectionService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 专业管理
 */

@RestController
@RequestMapping("/direction")
class DirectionController {
    @Autowired
    private lateinit var directionService: DirectionService
    @Autowired
    private lateinit var collegeService: CollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollege(@RequestBody direction: Direction): Result {
        println("direction ${direction}")
        directionService.save(direction)
        val msg = directionService.findAll()
        return ResultUtils.success(200, "插入方向成功", msg)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val directionList = directionService.findAll()
        val msg = directionList.map { (key, value) ->
            val collegeName = collegeService.findOne(key).name!!
            var directionResponse = DirectionResponse()
            directionResponse.collegeName = collegeName
            directionResponse.directionList =value
            return@map directionResponse
        }
        return ResultUtils.success(200, "获取方向列表", msg)
    }
}