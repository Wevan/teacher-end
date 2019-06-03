package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.vo.RecommendResource
import org.springframework.stereotype.Service

/**
 * @author wevan 2019/6/3 9:47
 */
@Service
interface RecommendService {

    /**
     * 生成推荐
     */
    fun generateRecommend(studentId:Long):HashSet<RecommendResource>
}