package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.repository.point.ResourceRepository
import com.nuc.tracking.teacherend.service.point.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceServiceImpl: ResourceService {
    override fun findOne(id: Long): ResourceDirctoryFile {
        return resourceRepository.findById(id).get()
    }

    @Autowired
    private lateinit var resourceRepository: ResourceRepository
    override fun save(resource: ResourceDirctoryFile) {
        resourceRepository.save(resource)
    }
}