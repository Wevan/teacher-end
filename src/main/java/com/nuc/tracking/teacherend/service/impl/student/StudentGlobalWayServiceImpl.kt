package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentGlobalWay
import com.nuc.tracking.teacherend.repository.relation.GlobalWayRepository
import com.nuc.tracking.teacherend.repository.student.StudentGlobalWayRepository
import com.nuc.tracking.teacherend.service.student.StudentGlobalWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentGlobalWayServiceImpl:StudentGlobalWayService {
    @Autowired
    private lateinit var studentGlobalWayRepository: StudentGlobalWayRepository
    override fun save(studentGlobalWay: StudentGlobalWay) {
        studentGlobalWayRepository.save(studentGlobalWay)
    }
}