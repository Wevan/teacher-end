package com.nuc.tracking.teacherend.po.teacher

import com.nuc.tracking.teacherend.po.entity.Course

class CourseResponse {
    var collegeName: String = ""
    lateinit var courseList: List<Course>
}