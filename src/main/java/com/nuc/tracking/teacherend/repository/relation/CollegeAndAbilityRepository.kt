package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.relation.CollegeAndAbility
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeAndAbilityRepository: JpaRepository<CollegeAndAbility, Long> {
}