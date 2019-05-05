package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.ResourceClass

interface ResourceClassService {
    @Throws(ResultException::class)
    fun saveOne(resouceClass: ResourceClass)

    @Throws(ResultException::class)
    fun findOne(resourceId: Long, classId: Long)
}