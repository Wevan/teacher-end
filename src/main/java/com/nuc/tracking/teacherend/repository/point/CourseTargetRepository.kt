package com.nuc.tracking.teacherend.repository.point

import com.nuc.tracking.teacherend.po.entity.CourseTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTargetRepository: JpaRepository<CourseTarget, Long> {
    fun findByCourseId(id:Long):List<CourseTarget>?
}