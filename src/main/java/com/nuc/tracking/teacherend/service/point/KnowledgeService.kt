package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Knowledge

interface KnowledgeService {
    @Throws(ResultException::class)
    fun save(knowledge: Knowledge)

    @Throws(ResultException::class)
    fun findOne(id: Long): Knowledge

    @Throws(ResultException::class)
    fun findAllByCourseId(courseId: Long): List<Knowledge>
}