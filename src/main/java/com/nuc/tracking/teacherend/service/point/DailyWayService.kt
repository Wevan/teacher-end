package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.DailyWay

interface DailyWayService {
    @Throws(ResultException::class)
    fun save(dailyWay: DailyWay)

    @Throws(ResultException::class)
    fun findOne(id: Long): DailyWay

    @Throws(ResultException::class)
    fun findByResourceId(id: Long): DailyWay
}