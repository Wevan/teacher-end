package com.nuc.tracking.teacherend.controller.student

import com.nuc.tracking.teacherend.po.entity.Knowledge
import com.nuc.tracking.teacherend.po.record.StudentKnowledge
import com.nuc.tracking.teacherend.po.record.StudentResource
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.point.*
import com.nuc.tracking.teacherend.service.student.*
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.sql.Date

@RestController
@RequestMapping("/sturesource")
class StudentResourceController {
    @Autowired
    private lateinit var studentResourceService: StudentResourceService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertRecord(@RequestBody studentResource: StudentResource): Result {
        //资源记录
        val msg = studentResourceService.save(studentResource)
        return ResultUtils.success(200, "插入记录成功", msg)
    }
}