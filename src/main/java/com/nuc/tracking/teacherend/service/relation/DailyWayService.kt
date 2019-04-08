package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.DailyWay

interface DailyWayService {
    @Throws(ResultException::class)
    fun save(dailyWay: DailyWay)
}