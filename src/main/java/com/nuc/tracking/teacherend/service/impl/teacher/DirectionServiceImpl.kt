package com.nuc.tracking.teacherend.service.impl.teacher

import com.nuc.tracking.teacherend.po.entity.Direction
import com.nuc.tracking.teacherend.service.teacher.DirectionService
import com.nuc.tracking.teacherend.repository.teacher.DirectionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DirectionServiceImpl: DirectionService {
    @Autowired
    private lateinit var directionRepository: DirectionRepository

    override fun save(direction: Direction) {
        directionRepository.save(direction)
    }

    override fun deleteById(id: Long) {
        directionRepository.deleteById(id)
    }

    override fun findOne(id: Long): Direction {
        return directionRepository.findById(id).get()
    }

    override fun findAll(): Map<Long,List<Direction>> {
        return directionRepository.findAll().groupBy { it.collegeId }
    }
}