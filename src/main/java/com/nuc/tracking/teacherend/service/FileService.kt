package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import org.springframework.web.multipart.MultipartFile

interface FileService {
    @Throws(ResultException::class)
    fun getFile(resourceDirctoryFile: ResourceDirctoryFile, file: MultipartFile): Boolean

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id: Long): ResourceDirctoryFile

    @Throws(ResultException::class)
    fun findAll(): List<ResourceDirctoryFile>


}