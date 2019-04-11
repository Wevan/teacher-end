package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.relation.CourseAndCollege

interface CourseAndCollegeService {
    @Throws(ResultException::class)
    fun save(courseAndCollege: CourseAndCollege)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseAndCollege
}