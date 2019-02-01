package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.Course
import com.nuc.tracking.teacherend.repository.CourseRepository
import com.nuc.tracking.teacherend.service.CourseService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class CourseServiceImpl : CourseService {
    override fun findByLevel(level: String):List<Course> {
        val courseList: List<Course> = courseRepository.findCourseByLevel(level)!!
        return courseList

    }

    override fun findAll() :List<Course>{
        val courseList: List<Course> = courseRepository.findAll()
        return courseList
    }

    override fun findOne(id: Long):Course {
        val course: Course = courseRepository.findById(id).get()
        return course

    }

    override fun deleteById(id: Long) {
        courseRepository.deleteById(+id)
    }


    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var courseRepository: CourseRepository

    override fun save(course: Course) {
        courseRepository.save(course)
    }
}