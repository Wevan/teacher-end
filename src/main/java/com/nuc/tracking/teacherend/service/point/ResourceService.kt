package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile

interface ResourceService {
    @Throws(ResultException::class)
    fun save(resource: ResourceDirctoryFile)
    @Throws(ResultException::class)
    fun findOne(id: Long): ResourceDirctoryFile
}