package com.nuc.tracking.teacherend.po.entity

import com.nuc.tracking.teacherend.po.entity.Student

/**
 * 返回给教师端的班级学生信息
 */
class StudentSelfPercent {
    lateinit var student: Student
    var selfPercent = 0f
}