package com.nuc.tracking.teacherend.service.teacher

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.teacher.College

interface CollegeService {
    @Throws(ResultException::class)
    fun save(college: College)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): College

    @Throws(ResultException::class)
    fun findAll():List<College>
}