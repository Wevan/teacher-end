package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentCourseTarget
import com.nuc.tracking.teacherend.repository.student.StudentCourseTargetRepository
import com.nuc.tracking.teacherend.service.student.StudentCourseTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentCourseTargetServiceImpl: StudentCourseTargetService {
    override fun findOne(id: Long): StudentCourseTarget {
        val courseTarget:StudentCourseTarget = studentCourseTargetRepository.findById(id).get()
        return courseTarget
    }

    @Autowired
    private lateinit var studentCourseTargetRepository: StudentCourseTargetRepository
    override fun save(studentCourseTarget: StudentCourseTarget) {
        studentCourseTargetRepository.save(studentCourseTarget)
    }
}