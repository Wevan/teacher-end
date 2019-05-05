package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.ResourceClass
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceClassRepository : JpaRepository<ResourceClass, Long> {
    fun findByResourceIdAndClassId(resourceId: Long, classId: Long):ResourceClass?
}