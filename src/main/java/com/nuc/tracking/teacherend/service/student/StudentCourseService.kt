package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentCourse
import com.nuc.tracking.teacherend.po.record.StudentDailyWay

interface StudentCourseService {
    @Throws(ResultException::class)
    fun save(studentCourse: StudentCourse)

    @Throws(ResultException::class)
    fun findOne(id: Long): StudentCourse
}