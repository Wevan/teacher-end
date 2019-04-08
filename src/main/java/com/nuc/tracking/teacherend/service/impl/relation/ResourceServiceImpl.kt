package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.repository.relation.ResourceRepository
import com.nuc.tracking.teacherend.service.relation.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceServiceImpl: ResourceService {
    @Autowired
    private lateinit var resourceRepository: ResourceRepository
    override fun save(resource: ResourceDirctoryFile) {
        resourceRepository.save(resource)
    }
}