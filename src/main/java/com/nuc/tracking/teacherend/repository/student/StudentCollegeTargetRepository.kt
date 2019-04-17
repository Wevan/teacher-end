package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentCollegeTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentCollegeTargetRepository: JpaRepository<StudentCollegeTarget, Long> {
    fun findAllByStudentId(studentId:Long):List<StudentCollegeTarget>?
    fun findAllByStudentIdAndCollegeTargetId(studentId:Long,collegeId:Long):StudentCollegeTarget?
}