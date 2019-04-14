package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentGlobalWay
import org.springframework.web.multipart.MultipartFile

interface StudentGlobalWayService {
    @Throws(ResultException::class)
    fun save(file: MultipartFile, courseId: Long, typeTest: String)

    @Throws(ResultException::class)
    fun findOne(id: Long): StudentGlobalWay
}