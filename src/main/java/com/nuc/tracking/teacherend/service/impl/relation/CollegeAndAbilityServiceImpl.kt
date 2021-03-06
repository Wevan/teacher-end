package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.relation.CollegeAndAbility
import com.nuc.tracking.teacherend.repository.relation.CollegeAndAbilityRepository
import com.nuc.tracking.teacherend.service.relation.CollegeAndAbilityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeAndAbilityServiceImpl: CollegeAndAbilityService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var collegeAndAbilityRepository: CollegeAndAbilityRepository
    override fun save(collegeAndAbility: CollegeAndAbility) {
        collegeAndAbilityRepository.save(collegeAndAbility)
    }

    override fun deleteById(id: Long) {
        collegeAndAbilityRepository.deleteById(id)
    }

    override fun findOne(id: Long): CollegeAndAbility {
        return collegeAndAbilityRepository.findById(id).get()
    }
}