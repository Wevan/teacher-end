package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentKnowledge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentKnowledgeRepository : JpaRepository<StudentKnowledge, Long> {
    fun findByKnowledgeIdAndStudentId(id: Long,studentId:Long): StudentKnowledge?
}