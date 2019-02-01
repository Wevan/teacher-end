package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.VideoRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VideoRecordRepository : JpaRepository<VideoRecord, Long> {
}