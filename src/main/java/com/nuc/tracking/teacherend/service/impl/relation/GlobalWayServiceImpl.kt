package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.GlobalWay
import com.nuc.tracking.teacherend.repository.relation.GlobalWayRepository
import com.nuc.tracking.teacherend.service.relation.GlobalWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GlobalWayServiceImpl: GlobalWayService {
    @Autowired
    private lateinit var globalWayRepository: GlobalWayRepository
    override fun save(globalWay: GlobalWay) {
        globalWayRepository.save(globalWay)
    }
}