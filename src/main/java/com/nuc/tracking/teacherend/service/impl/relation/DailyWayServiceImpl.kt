package com.nuc.tracking.teacherend.service.impl.relation

import com.nuc.tracking.teacherend.po.entity.DailyWay
import com.nuc.tracking.teacherend.repository.relation.DailyWayRepository
import com.nuc.tracking.teacherend.service.relation.DailyWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DailyWayServiceImpl:DailyWayService {
    @Autowired
    private lateinit var dailyWayRepository: DailyWayRepository
    override fun save(dailyWay: DailyWay) {
        dailyWayRepository.save(dailyWay)
    }
}