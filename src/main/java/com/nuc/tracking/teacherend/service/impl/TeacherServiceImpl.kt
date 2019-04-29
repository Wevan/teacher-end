package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.Teacher
import com.nuc.tracking.teacherend.repository.TeacherRepository
import com.nuc.tracking.teacherend.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeacherServiceImpl:TeacherService {

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    override fun findOne(id: String): Teacher {
        return teacherRepository.findByJobNumber(id)!!
    }
}