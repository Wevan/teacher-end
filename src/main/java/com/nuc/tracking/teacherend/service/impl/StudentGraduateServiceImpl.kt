package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.record.StudentGraduate
import com.nuc.tracking.teacherend.repository.StudentGraduateRepository
import com.nuc.tracking.teacherend.service.StudentGraduateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentGraduateServiceImpl : StudentGraduateService {

    @Autowired
    private lateinit var studentGraduateRepository: StudentGraduateRepository

    override fun findByStudentNumber(studentId: Long): StudentGraduate {
        var studentGraduate = studentGraduateRepository.findByStudentId(studentId)
        if (studentGraduate == null) {
            studentGraduate = StudentGraduate()
            studentGraduate.percent = 0f
            studentGraduate.studentId = studentId
        }
        return studentGraduate
    }

}