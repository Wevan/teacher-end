package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.Student12Ability

interface Student12AbilityService {
    @Throws(ResultException::class)
    fun save(student12Ability: Student12Ability)
}