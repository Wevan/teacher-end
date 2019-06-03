package com.nuc.tracking.teacherend.service.impl.teacher

import com.nuc.tracking.teacherend.po.teacher.CourseDirect
import com.nuc.tracking.teacherend.service.teacher.CourseDirectService
import com.nuc.tracking.teacherend.repository.teacher.CourseDirectRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseDirectServiceImpl: CourseDirectService {
    @Autowired
    private lateinit var courseDirectRepository: CourseDirectRepository

    override fun save(courseDirect: CourseDirect) {
        courseDirectRepository.save(courseDirect)
    }

    override fun deleteById(id: Long) {
        courseDirectRepository.deleteById(id)
    }

    override fun findOne(id: Long): CourseDirect {
        return courseDirectRepository.findById(id).get()
    }

    override fun findAll(): List<CourseDirect> {
        return courseDirectRepository.findAll()
    }
}