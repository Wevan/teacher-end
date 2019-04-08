package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentCollegeTarget
import com.nuc.tracking.teacherend.repository.relation.CollegeTargetRepository
import com.nuc.tracking.teacherend.repository.student.StudentCollegeTargetRepository
import com.nuc.tracking.teacherend.service.student.StudentCollegeTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentCollegeTargetServiceImpl: StudentCollegeTargetService {
    @Autowired
    private lateinit var studentCollegeTargetRepository: StudentCollegeTargetRepository
    override fun save(studentCollegeTarget: StudentCollegeTarget) {
        studentCollegeTargetRepository.save(studentCollegeTarget)
    }
}