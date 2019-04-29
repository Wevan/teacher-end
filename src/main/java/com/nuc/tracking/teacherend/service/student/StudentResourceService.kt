package com.nuc.tracking.teacherend.service.student

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.record.StudentResource

interface StudentResourceService {
    @Throws(ResultException::class)
    fun save(studentResource: StudentResource)

    @Throws(ResultException::class)
    fun findOne(id: Long): StudentResource

    @Throws(ResultException::class)
    fun findByResourceIdAndStudentId(resourceId: Long, studentId: Long): Boolean
}