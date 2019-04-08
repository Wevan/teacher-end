package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentDailyWay
import com.nuc.tracking.teacherend.repository.relation.DailyWayRepository
import com.nuc.tracking.teacherend.repository.student.StudentDailyWayRepository
import com.nuc.tracking.teacherend.service.student.StudentDailyWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentDailyWayServiceImpl :StudentDailyWayService{
    @Autowired
    private lateinit var studentDailyWayRepository: StudentDailyWayRepository
    override fun save(studentDailyWay: StudentDailyWay) {
        studentDailyWayRepository.save(studentDailyWay)
    }
}