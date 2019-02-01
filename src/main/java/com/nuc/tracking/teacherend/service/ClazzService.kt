package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.Clazz

interface ClazzService {
    @Throws(ResultException::class)
    fun save(clazz: Clazz)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long):Clazz

    @Throws(ResultException::class)
    fun findAll():List<Clazz>
}