package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import com.nuc.tracking.teacherend.po.entity.ResourceEntity
import org.springframework.web.multipart.MultipartFile

interface FileService {
    @Throws(ResultException::class)
    fun saveAllFile(resourceList: List<ResourceDirctoryFile>, type: Long, knowledgeId: Long): Boolean

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id: Long): ResourceDirctoryFile

    @Throws(ResultException::class)
    fun findAll(courseId: Long, classId: Long): List<ResourceEntity>?

    @Throws(ResultException::class)
    fun getTqPercent(courseId: Long, classId: Long): Float

    @Throws(ResultException::class)
    fun playTimes(resourceId: Long)
}