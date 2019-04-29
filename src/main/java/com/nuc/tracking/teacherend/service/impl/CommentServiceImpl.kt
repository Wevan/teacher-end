package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.Comment
import com.nuc.tracking.teacherend.repository.CommentRepository
import com.nuc.tracking.teacherend.service.CommentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl : CommentService {
    @Autowired
    private lateinit var commentRepository: CommentRepository

    override fun save(comment: Comment) {
        commentRepository.save(comment)
    }

    override fun findAllByResourceId(videoId: Long): List<Comment>? {
        return commentRepository.findByVideoId(videoId)
    }
}