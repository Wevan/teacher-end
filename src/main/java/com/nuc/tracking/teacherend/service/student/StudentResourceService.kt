package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentResource

interface StudentResourceService {
    @Throws(ResultException::class)
    fun save(studentResource: StudentResource)
}