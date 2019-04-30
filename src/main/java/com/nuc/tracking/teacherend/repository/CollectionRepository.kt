package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.UserCollection
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollectionRepository : JpaRepository<UserCollection, Long> {
    fun findByUserId(userId:Long): List<UserCollection>?
}