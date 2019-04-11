package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.relation.KnowledgeAndWay

interface KnowledgeAndWayService {
    @Throws(ResultException::class)
    fun save(knowledgeAndWay: KnowledgeAndWay)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): KnowledgeAndWay
}