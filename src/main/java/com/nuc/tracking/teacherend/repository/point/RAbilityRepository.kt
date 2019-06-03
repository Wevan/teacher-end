package com.nuc.tracking.teacherend.repository.point

import com.nuc.tracking.teacherend.po.entity.RAbility
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RAbilityRepository: JpaRepository<RAbility, Long> {
    fun findByCollegeId(collegeId: Long): List<RAbility>?
}