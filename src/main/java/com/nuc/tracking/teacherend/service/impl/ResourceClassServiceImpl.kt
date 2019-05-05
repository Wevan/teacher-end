package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.ResourceClass
import com.nuc.tracking.teacherend.repository.ResourceClassRepository
import com.nuc.tracking.teacherend.service.ResourceClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceClassServiceImpl : ResourceClassService {
    override fun findOne(resourceId: Long, classId: Long) {
        resouceClassRepository.findByResourceIdAndClassId(resourceId, classId)
    }

    @Autowired
    private lateinit var resouceClassRepository: ResourceClassRepository

    override fun saveOne(resouceClass: ResourceClass) {
        resouceClassRepository.save(resouceClass)
    }


}