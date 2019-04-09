package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.relation.KnowledgeAndWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KnowledgeAndWayRepository : JpaRepository<KnowledgeAndWay, Long> {
}