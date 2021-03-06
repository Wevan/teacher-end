package com.nuc.tracking.teacherend.repository.teacher

import com.nuc.tracking.teacherend.po.teacher.College
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeRepository: JpaRepository<College, Long> {
}