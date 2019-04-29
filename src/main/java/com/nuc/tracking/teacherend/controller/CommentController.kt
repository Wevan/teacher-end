package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.po.entity.Comment
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.CommentService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 评论处理
 */

@RestController
@RequestMapping("/comment")
class CommentController {
    @Autowired
    private lateinit var commentService: CommentService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertClass(@RequestBody comment: Comment): Result {
        val msg = commentService.save(comment)
        return ResultUtils.success(200, "评论存储成功", msg)
    }

    @GetMapping("/findAll")
    fun findAll(videoId: Long): Result {
        val msg = commentService.findAllByResourceId(videoId)
        return ResultUtils.success(200, "查找成功", msg)
    }

}