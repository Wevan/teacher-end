package com.nuc.tracking.teacherend.service.point

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Course


interface CourseService {
    /**
     *
     */
    @Throws(ResultException::class)
    fun save(course: Course)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): Course

    @Throws(ResultException::class)
    fun findAll():List<Course>

    @Throws(ResultException::class)
    fun findByLevel(level:String):List<Course>
}