package com.nuc.tracking.teacherend.repository.point

import com.nuc.tracking.teacherend.po.entity.DailyWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyWayRepository: JpaRepository<DailyWay, Long> {
    fun findDailyWayByResourceId(id:Long):DailyWay
}