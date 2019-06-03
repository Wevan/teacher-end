package com.nuc.tracking.teacherend.repository.point

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceRepository : JpaRepository<ResourceDirctoryFile, Long> {

    /**
     * 获取名字相同的
     * @param name String
     * @return List<ResourceDirctoryFile>
     */
    fun findByNameLike(name:String):List<ResourceDirctoryFile>
}