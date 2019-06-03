package com.nuc.tracking.teacherend.po.teacher

import com.nuc.tracking.teacherend.po.entity.CollegeTarget

class CollegeResponse {
    var collegeId: Long = 0
    var collegeName: String = ""
    lateinit var collegeTargetList: List<CollegeTarget>
}