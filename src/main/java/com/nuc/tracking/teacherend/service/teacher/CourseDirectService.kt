package com.nuc.tracking.teacherend.service.teacher

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.teacher.CourseDirect

interface CourseDirectService {
    @Throws(ResultException::class)
    fun save(courseDirect: CourseDirect)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseDirect

    @Throws(ResultException::class)
    fun findAll():List<CourseDirect>
}