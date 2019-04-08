package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Knowledge

interface KnowledgeService {
    @Throws(ResultException::class)
    fun save(knowledge: Knowledge)
}