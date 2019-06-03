package com.nuc.tracking.teacherend.po.teacher

import com.nuc.tracking.teacherend.po.entity.DailyWay

class DailyWayResponse {
    var courseName: String = ""
    lateinit var dailyWayList:List<DailyWay>
}