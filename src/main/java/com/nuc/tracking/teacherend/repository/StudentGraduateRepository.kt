package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.record.StudentGraduate
import org.springframework.data.jpa.repository.JpaRepository

interface StudentGraduateRepository : JpaRepository<StudentGraduate, Long> {
    fun findByStudentId(studentId: Long): StudentGraduate?
}