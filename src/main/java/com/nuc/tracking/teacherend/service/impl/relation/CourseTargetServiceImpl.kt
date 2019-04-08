package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.CourseTarget
import com.nuc.tracking.teacherend.repository.relation.CourseTargetRepository
import com.nuc.tracking.teacherend.service.relation.CourseTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseTargetServiceImpl:CourseTargetService {
    @Autowired
    private lateinit var courseTargetRepository: CourseTargetRepository
    override fun save(courseTarget: CourseTarget) {
        courseTargetRepository.save(courseTarget)
    }
}