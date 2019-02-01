package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.Clazz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClazzRepository : JpaRepository<Clazz, Long> {

}