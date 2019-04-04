package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentGlobalWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentGlobalWayRepository : JpaRepository<StudentGlobalWay, Long> {
}