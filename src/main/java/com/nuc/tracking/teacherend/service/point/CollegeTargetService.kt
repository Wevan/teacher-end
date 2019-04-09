package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.CollegeTarget

interface CollegeTargetService {

    @Throws(ResultException::class)
    fun save(collegeTarget: CollegeTarget)

    @Throws(ResultException::class)
    fun findOne(id:Long): CollegeTarget
}