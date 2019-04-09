package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.GlobalWay

interface GlobalWayService {
    @Throws(ResultException::class)
    fun save(globalWay: GlobalWay)
    @Throws(ResultException::class)
    fun findOne(id: Long): GlobalWay
}