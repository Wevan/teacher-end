package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.entity.RAbility
import com.nuc.tracking.teacherend.po.record.Student12Ability
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RAbilityRepository: JpaRepository<RAbility, Long> {
}