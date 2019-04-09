package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.StudentResource
import com.nuc.tracking.teacherend.repository.student.StudentResourceRepository
import com.nuc.tracking.teacherend.service.student.StudentResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentResourceServiceImpl: StudentResourceService {
    override fun findOne(id: Long): StudentResource {
        val studentResource:StudentResource = studentResourceRepository.findById(id).get()
        return studentResource
    }

    @Autowired
    private lateinit var studentResourceRepository: StudentResourceRepository
    override fun save(studentResource: StudentResource) {
        studentResourceRepository.save(studentResource)
    }
}