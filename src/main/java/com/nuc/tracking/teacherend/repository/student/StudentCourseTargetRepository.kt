package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentCourseTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentCourseTargetRepository: JpaRepository<StudentCourseTarget, Long> {
}