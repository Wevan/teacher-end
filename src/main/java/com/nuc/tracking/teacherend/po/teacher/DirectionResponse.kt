package com.nuc.tracking.teacherend.po.teacher

import com.nuc.tracking.teacherend.po.entity.Direction


class DirectionResponse {
    var collegeName: String = ""
    lateinit var directionList: List<Direction>
}