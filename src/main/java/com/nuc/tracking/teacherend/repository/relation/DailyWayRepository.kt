package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.entity.DailyWay
import com.nuc.tracking.teacherend.po.record.StudentDailyWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyWayRepository: JpaRepository<DailyWay, Long> {
}