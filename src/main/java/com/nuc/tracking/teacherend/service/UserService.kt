package com.nuc.tracking.teacherend.service

import com.nuc.tracking.teacherend.exception.ResultException


/**
 * @author 杨晓辉 2018/2/1 15:48
 */
interface UserService {


    /**
     * 通过用户名进行用户查找
     * @param username 学号
     * @param password 密码
     * @return HashMap 返回用户信息和token
     * @throws ResultException 当用户名称和密码不一致
     */
    @Throws(ResultException::class)
    fun login(username: String, password: String, type: Long): String
}