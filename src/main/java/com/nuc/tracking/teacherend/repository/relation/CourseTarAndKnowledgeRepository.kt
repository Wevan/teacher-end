package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.relation.CourseTarAndKnowledge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTarAndKnowledgeRepository: JpaRepository<CourseTarAndKnowledge, Long> {
}