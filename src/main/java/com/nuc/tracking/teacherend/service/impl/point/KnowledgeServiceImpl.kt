package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.Knowledge
import com.nuc.tracking.teacherend.repository.student.KnowledgeRepository
import com.nuc.tracking.teacherend.service.point.KnowledgeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KnowledgeServiceImpl: KnowledgeService {
    override fun findOne(id: Long): Knowledge {
        val knowledge = knowledgeRepository.findById(id).get()
        return knowledge
    }

    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository
    override fun save(knowledge: Knowledge) {
        knowledgeRepository.save(knowledge)
    }
}