package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.CollegeTarget
import com.nuc.tracking.teacherend.repository.relation.CollegeTargetRepository
import com.nuc.tracking.teacherend.service.relation.CollegeTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeTargetServiceImpl: CollegeTargetService {
    @Autowired
    private lateinit var collegeTargetRepository: CollegeTargetRepository
    override fun save(collegeTarget: CollegeTarget) {
        collegeTargetRepository.save(collegeTarget)
    }
}
