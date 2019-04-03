package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, Long> {
}