package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.UserService
import com.nuc.tracking.teacherend.util.ResultUtils
import com.nuc.tracking.teacherend.vo.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 用户中心请求
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService


    /**
     * 用户登录
     * @param user user参数
     * @return 返回结果
     */
    @PostMapping("/login")
    fun login(@RequestBody user: User): Result {
        val token = userService.login(user.username, user.password)
        return ResultUtils.success(200, "登录成功", token)
    }


}