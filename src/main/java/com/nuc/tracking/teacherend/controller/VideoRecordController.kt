package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.po.VideoRecord
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.VideoRecordService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger


@RestController
@RequestMapping("/record")
class VideoRecordController {
    @Autowired
    private lateinit var videoRecordService: VideoRecordService

    private val logger: org.slf4j.Logger = LoggerFactory.getLogger(this.javaClass)
    @PostMapping("/insert")
    fun insertClass(@RequestBody videoRecord: VideoRecord): Result {
        logger.info("明细 $videoRecord")
        val msg = videoRecordService.save(videoRecord)

        return ResultUtils.success(200, "插入成功", msg)
    }
}