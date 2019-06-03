package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.service.RecommendService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.junit4.SpringRunner

/**
 * @author 杨晓辉 2019/6/3 16:55
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class RecommendServiceImplTest {


    @Autowired
    private lateinit var recommendSerivce:RecommendService

    @Test
    fun getRecommendResourceTest() {
        recommendSerivce.generateRecommend(782)

    }
}