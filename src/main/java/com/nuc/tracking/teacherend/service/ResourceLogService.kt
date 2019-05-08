package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.ResourceLog

interface ResourceLogService {
    @Throws(ResultException::class)
    fun saveOne(resourceLog: ResourceLog)
}