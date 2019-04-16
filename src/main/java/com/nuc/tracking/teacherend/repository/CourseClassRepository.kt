package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.CourseClass
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseClassRepository : JpaRepository<CourseClass, Long> {
    fun findByCourseIdAndTeacherId(courseId: Long, teacherId: Long): List<CourseClass>
}