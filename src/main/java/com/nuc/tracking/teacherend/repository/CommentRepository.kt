package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : JpaRepository<Comment, Long> {
    fun findByVideoId(videoId: Long): List<Comment>?
}