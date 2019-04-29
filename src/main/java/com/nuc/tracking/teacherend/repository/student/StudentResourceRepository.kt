package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentResource
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentResourceRepository : JpaRepository<StudentResource, Long> {
    fun findByResourceIdAndStudentId(resourceId: Long, studentId: Long): StudentResource?
}