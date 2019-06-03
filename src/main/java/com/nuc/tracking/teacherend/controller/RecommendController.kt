package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.RecommendService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
 * @author wevan 2019/6/3 9:47
 */

@RestController("/recommend")
class RecommendController {

    @Autowired
    private lateinit var recommendService: RecommendService

    /**
     * 获得资源推荐
     * @param studentId Long
     * @return Result
     */
    @GetMapping("{studentId}")
    fun getRecommendResource(@PathVariable studentId: Long): Result {
        val resourceSet = recommendService.generateRecommend(studentId)
        if (resourceSet.size == 0) {
            return ResultUtils.success(message = "暂时没有合适你的视频")
        }
        return ResultUtils.success(data = resourceSet)

    }

}