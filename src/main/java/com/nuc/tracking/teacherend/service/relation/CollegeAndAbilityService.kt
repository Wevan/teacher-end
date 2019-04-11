package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.relation.CollegeAndAbility

interface CollegeAndAbilityService {
    @Throws(ResultException::class)
    fun save(collegeAndAbility: CollegeAndAbility)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CollegeAndAbility
}