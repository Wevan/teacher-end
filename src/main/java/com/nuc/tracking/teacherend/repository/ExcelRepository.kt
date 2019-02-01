package com.nuc.tracking.teacherend.repository


import com.nuc.tracking.teacherend.po.Excel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExcelRepository : JpaRepository<Excel, String>{

}


