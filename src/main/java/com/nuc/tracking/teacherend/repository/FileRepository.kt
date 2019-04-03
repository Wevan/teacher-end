package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : JpaRepository<ResourceDirctoryFile, Long> {

}