package com.nuc.tracking.teacherend.repository

import com.nuc.tracking.teacherend.po.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018/2/1 16:37
 */
@Repository
interface RoleRepository : JpaRepository<Role, Long> {

}