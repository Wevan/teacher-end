package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.entity.CollegeTarget
import com.nuc.tracking.teacherend.po.record.StudentCollegeTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeTargetRepository: JpaRepository<CollegeTarget, Long> {
}