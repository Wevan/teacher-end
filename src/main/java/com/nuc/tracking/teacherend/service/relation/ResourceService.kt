package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Clazz
import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile

interface ResourceService {
    @Throws(ResultException::class)
    fun save(resource: ResourceDirctoryFile)
}