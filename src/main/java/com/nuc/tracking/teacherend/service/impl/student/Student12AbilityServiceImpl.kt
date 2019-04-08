package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.record.Student12Ability
import com.nuc.tracking.teacherend.repository.student.Student12AbilityRepository
import com.nuc.tracking.teacherend.service.student.Student12AbilityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class Student12AbilityServiceImpl: Student12AbilityService {
    @Autowired
    private lateinit var student12AbilityRepository: Student12AbilityRepository
    override fun save(student12Ability: Student12Ability) {
        student12AbilityRepository.save(student12Ability)
    }
}