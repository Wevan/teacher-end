package com.nuc.tracking.teacherend.vo

import com.nuc.tracking.teacherend.po.entity.ResourceDirctoryFile
import org.springframework.web.multipart.MultipartFile


/**
 * @author 杨晓辉 2018-12-29 16:06
 * 所有的 `vo` 类
 */

/**
 * 用于接收页面的 `User` 值
 * @param username 用户名
 * @param password 密码
 */
data class User(val username: String, val password: String)

class ResourceData() {
    lateinit var resourceDirctoryFile: ResourceDirctoryFile
    lateinit var file: MultipartFile
}