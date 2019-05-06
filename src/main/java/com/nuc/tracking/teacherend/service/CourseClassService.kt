package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.CourseClass
import com.nuc.tracking.teacherend.po.entity.PersonalRecord
import com.nuc.tracking.teacherend.po.entity.StudentRecord
import com.nuc.tracking.teacherend.po.record.StudentCourse

interface CourseClassService {
    @Throws(ResultException::class)
    fun getCourseMesg(teacherId: Long, courseId: Long): List<Map<String, List<StudentRecord>>>

    @Throws(ResultException::class)
    fun getStudentMesg(studentId: Long): PersonalRecord

    @Throws(ResultException::class)
    fun findAllByTeacherIdAndCourseId(teacherId: Long, courseId: Long): List<CourseClass>
}