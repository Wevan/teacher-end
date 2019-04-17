package com.nuc.tracking.teacherend.repository.point

import com.nuc.tracking.teacherend.po.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CourseRepository : JpaRepository<Course, Long> {
    fun findCourseByLevel(level: String): List<Course>?

}