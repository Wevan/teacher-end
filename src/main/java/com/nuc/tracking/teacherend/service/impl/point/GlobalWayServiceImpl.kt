package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.GlobalWay
import com.nuc.tracking.teacherend.repository.point.GlobalWayRepository
import com.nuc.tracking.teacherend.service.point.GlobalWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GlobalWayServiceImpl: GlobalWayService {
    override fun findOne(id: Long): GlobalWay {
        val globalWay = globalWayRepository.findById(id).get()
        return globalWay
    }

    @Autowired
    private lateinit var globalWayRepository: GlobalWayRepository
    override fun save(globalWay: GlobalWay) {
        globalWayRepository.save(globalWay)
    }
}