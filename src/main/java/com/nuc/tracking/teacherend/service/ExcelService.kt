package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException
import org.springframework.web.multipart.MultipartFile

interface ExcelService {
    @Throws(ResultException::class)
    fun getExcel(file: MultipartFile): Boolean

}
