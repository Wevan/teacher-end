package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.relation.CourseTarAndWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTarAndWayRepository: JpaRepository<CourseTarAndWay, Long> {
}