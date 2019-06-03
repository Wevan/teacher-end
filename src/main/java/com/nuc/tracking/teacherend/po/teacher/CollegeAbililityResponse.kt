package com.nuc.tracking.teacherend.po.teacher

class CollegeAbililityResponse {
    var collegeId: Long = 0
    var collegeName: String = ""
    lateinit var collegeAbilityList: List<CAResponse>
}