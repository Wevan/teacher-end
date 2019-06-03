package com.nuc.tracking.teacherend.po.teacher

import com.nuc.tracking.teacherend.po.relation.CourseTarAndKnowledge

class CouTAndKnowResponse {
    var courseTargetName:String=""
    var knowledgeName:String=""
    lateinit var courseTargetAndKnowledge: CourseTarAndKnowledge
}