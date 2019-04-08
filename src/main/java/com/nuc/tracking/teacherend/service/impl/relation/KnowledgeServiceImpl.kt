package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.Knowledge
import com.nuc.tracking.teacherend.repository.student.KnowledgeRepository
import com.nuc.tracking.teacherend.service.relation.KnowledgeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KnowledgeServiceImpl: KnowledgeService {
    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository
    override fun save(knowledge: Knowledge) {
        knowledgeRepository.save(knowledge)
    }
}