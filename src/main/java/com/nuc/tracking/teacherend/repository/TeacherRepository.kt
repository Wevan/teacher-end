package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.Teacher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018/2/3 15:16
 */
@Repository
interface TeacherRepository : JpaRepository<Teacher, Long> {
    /**
     * 通过 teacherNumber 查找
     * @param teacherNumber teacherNumber
     */
    fun findByJobNumber(teacherNumber: String): Teacher?
}