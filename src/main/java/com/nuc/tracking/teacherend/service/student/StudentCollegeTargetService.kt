package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentCollegeTarget

interface StudentCollegeTargetService {
    @Throws(ResultException::class)
    fun save(studentCollegeTarget: StudentCollegeTarget)

    @Throws(ResultException::class)
    fun findOne(id: Long): StudentCollegeTarget
}