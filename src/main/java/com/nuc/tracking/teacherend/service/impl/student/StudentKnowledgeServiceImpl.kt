package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentKnowledge
import com.nuc.tracking.teacherend.repository.student.StudentKnowledgeRepository
import com.nuc.tracking.teacherend.service.student.StudentKnowledgeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentKnowledgeServiceImpl :StudentKnowledgeService {
    @Autowired
    private lateinit var studentKnowledgeRepository: StudentKnowledgeRepository
    override fun save(studentKnowledge: StudentKnowledge) {
        studentKnowledgeRepository.save(studentKnowledge)
    }
}