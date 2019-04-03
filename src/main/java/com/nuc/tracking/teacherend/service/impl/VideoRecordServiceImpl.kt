package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.VideoRecord
import com.nuc.tracking.teacherend.repository.VideoRecordRepository
import com.nuc.tracking.teacherend.service.VideoRecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VideoRecordServiceImpl:VideoRecordService {
    @Autowired
    private lateinit var videoRecordRepository: VideoRecordRepository
    override fun save(videoRecord: VideoRecord) {
        videoRecordRepository.save(videoRecord)
    }
}