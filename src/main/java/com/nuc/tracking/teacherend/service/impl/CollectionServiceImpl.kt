package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.UserCollection
import com.nuc.tracking.teacherend.repository.CollectionRepository
import com.nuc.tracking.teacherend.service.CollectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollectionServiceImpl : CollectionService {

    @Autowired
    private lateinit var collectionRepository: CollectionRepository

    override fun save(collection: UserCollection) {
        collectionRepository.save(collection)
    }

    override fun deleteById(id: Long) {
        collectionRepository.deleteById(id)
    }

    override fun findAllById(userId: Long): List<UserCollection>? {
        return collectionRepository.findByUserId(userId)
    }
}