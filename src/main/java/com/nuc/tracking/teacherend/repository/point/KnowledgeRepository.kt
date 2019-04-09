package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.entity.Knowledge
import com.nuc.tracking.teacherend.po.record.StudentKnowledge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KnowledgeRepository : JpaRepository<Knowledge, Long> {
}