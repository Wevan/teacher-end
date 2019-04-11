package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentCourse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentCourseRepository: JpaRepository<StudentCourse, Long> {
    fun findByCourseIdAndStudentId(id:Long,studentId:Long):StudentCourse?
}