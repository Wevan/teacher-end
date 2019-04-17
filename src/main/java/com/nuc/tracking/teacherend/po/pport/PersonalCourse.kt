package com.nuc.tracking.teacherend.po.pport

import com.nuc.tracking.teacherend.po.record.StudentCourse

class PersonalCourse {
    var name:String=""
    lateinit var studentCourse:StudentCourse
    lateinit var studentCourseTargetList:Map<String,List<PersonalCourseTarget>>
}