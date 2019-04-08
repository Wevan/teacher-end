package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.entity.CourseTarget
import com.nuc.tracking.teacherend.po.record.StudentCourseTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTargetRepository: JpaRepository<CourseTarget, Long> {
}