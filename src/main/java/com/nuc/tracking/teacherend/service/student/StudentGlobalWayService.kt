package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentGlobalWay

interface StudentGlobalWayService {
    @Throws(ResultException::class)
    fun save(studentGlobalWay: StudentGlobalWay)

    @Throws(ResultException::class)
    fun findOne(id: Long): StudentGlobalWay
}