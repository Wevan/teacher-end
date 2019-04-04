package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentKnowledge

interface StudentKnowledgeService {
    @Throws(ResultException::class)
    fun save(studentKnowledge: StudentKnowledge)
}