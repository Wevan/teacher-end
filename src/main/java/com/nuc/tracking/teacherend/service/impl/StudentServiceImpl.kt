package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.Student
import com.nuc.tracking.teacherend.repository.StudentRepository
import com.nuc.tracking.teacherend.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServiceImpl : StudentService {
    override fun findAllByClassId(classId: Long): List<Student> {
        return studentRepository.findByClassId(classId)
    }

    override fun findOne(id: String): Student {
        return studentRepository.findByStudentNumber(id)!!
    }

    @Autowired
    private lateinit var studentRepository: StudentRepository

}