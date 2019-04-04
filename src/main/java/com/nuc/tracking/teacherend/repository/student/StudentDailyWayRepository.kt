package com.nuc.tracking.teacherend.repository.student

import com.nuc.tracking.teacherend.po.record.StudentDailyWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentDailyWayRepository: JpaRepository<StudentDailyWay, Long> {
}