package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.RAbility
import com.nuc.tracking.teacherend.repository.relation.RAbilityRepository
import com.nuc.tracking.teacherend.service.relation.RAbilityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RAbilityServiceImpl:RAbilityService {
    @Autowired
    private lateinit var rAbilityRepository: RAbilityRepository
    override fun save(rAbility: RAbility) {
        rAbilityRepository.save(rAbility)
    }
}