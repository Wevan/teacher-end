package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.CourseTarget

interface CourseTargetService {
    @Throws(ResultException::class)
    fun save(courseTarget: CourseTarget)
}