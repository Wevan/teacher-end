package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentCourseTarget

interface StudentCourseTargetService {
    @Throws(ResultException::class)
    fun save(studentCourseTarget: StudentCourseTarget)
}