package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.UserCollection

interface CollectionService {
    @Throws(ResultException::class)
    fun save(collection: UserCollection)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findAllById(userId: Long): List<UserCollection>?
}