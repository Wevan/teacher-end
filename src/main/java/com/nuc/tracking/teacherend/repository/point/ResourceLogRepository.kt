package com.nuc.tracking.teacherend.repository.point

import com.nuc.tracking.teacherend.po.entity.ResourceLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceLogRepository : JpaRepository<ResourceLog, Long> {

    /**
     * 通过id查找学生
     * @param studentId Long
     */
    fun findByStudentId(studentId: Long): List<ResourceLog>
}