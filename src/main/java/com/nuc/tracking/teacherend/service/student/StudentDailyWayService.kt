package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentDailyWay

interface StudentDailyWayService {
    @Throws(ResultException::class)
    fun save(studentDailyWay: StudentDailyWay)
}