package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Teacher

interface TeacherService {
    @Throws(ResultException::class)
    fun findOne(id:String): Teacher
}