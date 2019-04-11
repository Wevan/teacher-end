package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.relation.CourseAndTarget

interface CourseAndTargetService {
    @Throws(ResultException::class)
    fun save(courseAndTarget: CourseAndTarget)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseAndTarget

}