package com.nuc.tracking.teacherend.repository.relation

import com.nuc.tracking.teacherend.po.entity.GlobalWay
import com.nuc.tracking.teacherend.po.record.StudentGlobalWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GlobalWayRepository : JpaRepository<GlobalWay, Long> {
}