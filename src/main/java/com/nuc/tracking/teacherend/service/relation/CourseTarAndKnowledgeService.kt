package com.nuc.tracking.teacherend.service.relation

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.relation.CourseTarAndKnowledge

interface CourseTarAndKnowledgeService {
    @Throws(ResultException::class)
    fun save(courseTarAndKnowledge: CourseTarAndKnowledge)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseTarAndKnowledge
}