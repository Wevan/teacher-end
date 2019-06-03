package com.nuc.tracking.teacherend.po.teacher

import com.nuc.tracking.teacherend.po.entity.Knowledge


class KnowledgeResponse {
    var courseName: String = ""
    lateinit var knowledgeList: List<Knowledge>
}