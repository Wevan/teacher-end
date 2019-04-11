package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.relation.CourseAndTarget
import com.nuc.tracking.teacherend.repository.relation.CourseAndTargetRepository
import com.nuc.tracking.teacherend.service.relation.CourseAndTargetService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseAndTargetServiceImpl: CourseAndTargetService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var courseAndTargetRepository: CourseAndTargetRepository

    override fun save(courseAndTarget: CourseAndTarget) {
        courseAndTargetRepository.save(courseAndTarget)
    }

    override fun deleteById(id: Long) {
        courseAndTargetRepository.deleteById(id)
    }

    override fun findOne(id: Long): CourseAndTarget {
        return courseAndTargetRepository.findById(id).get()
    }
}