package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.relation.CourseAndCollege
import com.nuc.tracking.teacherend.repository.relation.CourseAndCollegeRepository
import com.nuc.tracking.teacherend.service.relation.CourseAndCollegeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseAndCollegeServiceImpl: CourseAndCollegeService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var courseAndCollegeRepository: CourseAndCollegeRepository

    override fun save(courseAndCollege: CourseAndCollege) {
        courseAndCollegeRepository.save(courseAndCollege)
    }

    override fun deleteById(id: Long) {
        courseAndCollegeRepository.deleteById(id)
    }

    override fun findOne(id: Long): CourseAndCollege {
        return courseAndCollegeRepository.findById(id).get()
    }
}