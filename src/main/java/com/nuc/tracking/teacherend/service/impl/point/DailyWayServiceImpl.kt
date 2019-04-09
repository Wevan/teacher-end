package com.nuc.tracking.teacherend.service.impl.point

import com.nuc.tracking.teacherend.po.entity.DailyWay
import com.nuc.tracking.teacherend.repository.point.DailyWayRepository
import com.nuc.tracking.teacherend.service.point.DailyWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DailyWayServiceImpl:DailyWayService {
    override fun findByResourceId(id: Long): DailyWay {
        val dailyWay = dailyWayRepository.findDailyWayByResourceId(id)
        return dailyWay
    }

    override fun findOne(id: Long): DailyWay {
        val dailyWay = dailyWayRepository.findById(id).get()
        return dailyWay
    }

    @Autowired
    private lateinit var dailyWayRepository: DailyWayRepository
    override fun save(dailyWay: DailyWay) {
        dailyWayRepository.save(dailyWay)
    }
}