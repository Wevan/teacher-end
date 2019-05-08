package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.ResourceLog
import com.nuc.tracking.teacherend.repository.point.ResourceLogRepository
import com.nuc.tracking.teacherend.service.ResourceLogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceLogServiceImpl : ResourceLogService {
    @Autowired
    private lateinit var resourceLogRepository: ResourceLogRepository

    override fun saveOne(resourceLog: ResourceLog) {
        resourceLogRepository.save(resourceLog)
    }
}