package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.Student12Ability
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Student12AbilityRepository: JpaRepository<Student12Ability, Long> {
}