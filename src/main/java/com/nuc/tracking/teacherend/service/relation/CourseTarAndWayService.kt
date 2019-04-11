package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.relation.CourseTarAndWay

interface CourseTarAndWayService {
    @Throws(ResultException::class)
    fun save(courseTarAndWay: CourseTarAndWay)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseTarAndWay
}