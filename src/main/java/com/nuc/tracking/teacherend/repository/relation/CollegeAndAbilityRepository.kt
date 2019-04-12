package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.relation.CollegeAndAbility
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeAndAbilityRepository: JpaRepository<CollegeAndAbility, Long> {
    fun findByCollegeTargetId(id:Long):List<CollegeAndAbility>
    fun findByCollegeTargetIdAndAbilityId(id:Long,abilityId:Long):List<CollegeAndAbility>
    fun findByAbilityId(id:Long):List<CollegeAndAbility>

}