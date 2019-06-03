package com.nuc.tracking.teacherend.service.impl.teacher

import com.nuc.tracking.teacherend.po.teacher.College
import com.nuc.tracking.teacherend.repository.teacher.CollegeRepository
import com.nuc.tracking.teacherend.service.teacher.CollegeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeServiceImpl : CollegeService {
    @Autowired
    private lateinit var collegeRepository: CollegeRepository

    override fun save(college: College) {
        collegeRepository.save(college)
    }

    override fun deleteById(id: Long) {
        collegeRepository.deleteById(id)
    }

    override fun findOne(id: Long): College {
        return collegeRepository.findById(id).get()
    }

    override fun findAll(): List<College> {
        return collegeRepository.findAll()
    }
}