package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.VideoRecord

interface VideoRecordService {
    @Throws(ResultException::class)
    fun save(videoRecord: VideoRecord)
}