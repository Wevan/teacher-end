package com.nuc.tracking.teacherend.controller.relation

import com.nuc.tracking.teacherend.po.relation.CourseTarAndKnowledge
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.relation.CourseTarAndKnowledgeService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/courseTarAndKnowledge")
class CourseTarAndKnowledgeController {
    @Autowired
    private lateinit var courseTarAndKnowledgeService: CourseTarAndKnowledgeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCourseTarAndKnowledge(@RequestBody courseTarAndKnowledge: CourseTarAndKnowledge): Result {
        val msg = courseTarAndKnowledgeService.save(courseTarAndKnowledge)
        return ResultUtils.success(200, "插入成功", msg)
    }
}