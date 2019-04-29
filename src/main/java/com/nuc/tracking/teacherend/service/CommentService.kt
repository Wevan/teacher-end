package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Comment

interface CommentService {
    @Throws(ResultException::class)
    fun save(comment: Comment)

    @Throws(ResultException::class)
    fun findAllByResourceId(videoId: Long): List<Comment>?
}