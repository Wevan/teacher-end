package com.nuc.tracking.teacherend.po.entity

import com.nuc.tracking.teacherend.po.pport.PersonalAbility
import com.nuc.tracking.teacherend.po.pport.PersonalCollegeTarget
import com.nuc.tracking.teacherend.po.pport.PersonalCourse

class PersonalRecord {
    var name: String=""
    var classId: String=""
    lateinit var studentCourseList:Map<String, PersonalCourse>
    lateinit var studentCollegeTargetList:List<PersonalCollegeTarget>
    lateinit var studentAbilityList:List<PersonalAbility>
}