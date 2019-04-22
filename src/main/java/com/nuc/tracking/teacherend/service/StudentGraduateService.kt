package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentGraduate

interface StudentGraduateService {

    @Throws(ResultException::class)
    fun findByStudentNumber(studentId:Long): StudentGraduate?
}