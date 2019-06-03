package com.nuc.tracking.teacherend.repository.teacher

import com.nuc.tracking.teacherend.po.teacher.CourseDirect
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseDirectRepository: JpaRepository<CourseDirect, Long> {
}