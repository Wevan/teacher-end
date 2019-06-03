package com.nuc.tracking.teacherend.service.teacher

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Direction

interface DirectionService {
    @Throws(ResultException::class)
    fun save(direction: Direction)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): Direction

    @Throws(ResultException::class)
    fun findAll():Map<Long,List<Direction>>
}