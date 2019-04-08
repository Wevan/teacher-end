package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.entity.Course
import com.nuc.tracking.teacherend.po.record.StudentCourse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: JpaRepository<Course, Long> {
}