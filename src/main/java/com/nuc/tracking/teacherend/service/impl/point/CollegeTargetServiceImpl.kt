package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.CollegeTarget
import com.nuc.tracking.teacherend.repository.point.CollegeTargetRepository
import com.nuc.tracking.teacherend.service.point.CollegeTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeTargetServiceImpl: CollegeTargetService {
    override fun findByCollegeId(collegeId: Long): List<CollegeTarget> {
        return collegeTargetRepository.findByCollegeId(collegeId)
    }

    override fun saveAll(collegeTargetList: List<CollegeTarget>) {
        collegeTargetRepository.saveAll(collegeTargetList)
    }

    override fun getList(): Map<Long, List<CollegeTarget>> {
        val msg = collegeTargetRepository.findAll().groupBy { it.collegeId }
        return msg
    }

    override fun findOne(id: Long): CollegeTarget {
        val collegeTarget = collegeTargetRepository.findById(id).get()
        return collegeTarget
    }

    @Autowired
    private lateinit var collegeTargetRepository: CollegeTargetRepository

    override fun save(collegeTarget: CollegeTarget) {
        collegeTargetRepository.save(collegeTarget)
    }
}
