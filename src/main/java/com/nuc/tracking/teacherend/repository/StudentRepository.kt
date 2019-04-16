package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018/2/3 15:16
 */
@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    /**
     * 通过 studentNumber 查找
     * @param studentNumber studentNumber
     */
    fun findByStudentNumber(studentNumber: String): Student?
    fun findByClassId(classId:Long):List<Student>
}