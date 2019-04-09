package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.CourseTarget

interface CourseTargetService {
    @Throws(ResultException::class)
    fun save(courseTarget: CourseTarget)

    @Throws(ResultException::class)
    fun findOne(id: Long): CourseTarget

    @Throws(ResultException::class)
    fun findByCourseId(id: Long): CourseTarget
}