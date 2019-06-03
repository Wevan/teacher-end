package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.RAbility

interface RAbilityService {

    @Throws(ResultException::class)
    fun save(ability: RAbility)

    @Throws(ResultException::class)
    fun findOne(id: Long): RAbility

    @Throws(ResultException::class)
    fun findByCollegeId(collegeId: Long): List<RAbility>?

    @Throws(ResultException::class)
    fun getAll(id: Long): List<RAbility>
}