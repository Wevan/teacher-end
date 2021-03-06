package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.RAbility
import com.nuc.tracking.teacherend.repository.point.RAbilityRepository
import com.nuc.tracking.teacherend.service.point.RAbilityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RAbilityServiceImpl:RAbilityService {
    override fun findByCollegeId(collegeId: Long): List<RAbility>? {
        return rAbilityRepository.findByCollegeId(collegeId)
    }

    override fun getAll(id: Long): List<RAbility> {
        return rAbilityRepository.findAll()
    }

    override fun findOne(id: Long): RAbility {
        val rAbility = rAbilityRepository.findById(id).get()
        return rAbility
    }

    @Autowired
    private lateinit var rAbilityRepository: RAbilityRepository
    override fun save(ability: RAbility) {
        rAbilityRepository.save(ability)
    }
}