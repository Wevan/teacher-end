package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.StudentRecord
import com.nuc.tracking.teacherend.po.record.StudentCourse

interface CourseClassService {
    @Throws(ResultException::class)
    fun getCourseMesg(teacherId:Long,courseId:Long): List<Map<String,List<StudentRecord>>>
}