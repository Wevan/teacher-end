package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentCourse
import com.nuc.tracking.teacherend.repository.student.StudentCourseRepository
import com.nuc.tracking.teacherend.service.student.StudentCourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentCourseServiceImpl: StudentCourseService {
    override fun findOne(id: Long): StudentCourse {
        val studentCourse = studentCourseRepository.findById(id).get()
        return studentCourse
    }

    @Autowired
    private lateinit var studentCourseRepository: StudentCourseRepository
    override fun save(studentCourse: StudentCourse) {
        studentCourseRepository.save(studentCourse)
    }
}