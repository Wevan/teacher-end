package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.Knowledge
import com.nuc.tracking.teacherend.repository.student.KnowledgeRepository
import com.nuc.tracking.teacherend.service.point.KnowledgeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KnowledgeServiceImpl: KnowledgeService {
    override fun findAllByCourseId(courseId: Long): List<Knowledge> {
        return knowledgeRepository.findByCourseId(courseId)
    }

    override fun findOne(id: Long): Knowledge {
        return knowledgeRepository.findById(id).get()
    }

    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository
    override fun save(knowledge: Knowledge) {
        knowledgeRepository.save(knowledge)
    }
}