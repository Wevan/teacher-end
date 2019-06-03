package com.nuc.tracking.teacherend.repository.teacher

import com.nuc.tracking.teacherend.po.entity.Direction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DirectionRepository: JpaRepository<Direction, Long> {
}