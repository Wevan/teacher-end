package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.exception.ResultException
import com.nuc.tracking.teacherend.po.entity.Role
import com.nuc.tracking.teacherend.repository.*
import com.nuc.tracking.teacherend.security.JwtTokenProvider
import com.nuc.tracking.teacherend.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 2018/2/1 15:46
 * 用户信息中心
 */
@Service
class UserServiceImpl : UserService, UserDetailsService {


    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userAndRoleRepository: UserAndRoleRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var jwtTokenProvider: JwtTokenProvider

    @Autowired
    private lateinit var roleRepository: RoleRepository


    /**
     * 通过用户名进行用户查找
     * @param user 用户学号
     * @return token 信息
     * @throws ResultException 当用户名称和密码不一致
     */
    override fun login(username: String, password: String): String {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        val user = userRepository.findUserByUsername(username) ?: throw ResultException("没有该用户", 500)
        val userAndRole = userAndRoleRepository.findUserAndRoleByUserId(user.id)
        val role = roleRepository.findById(userAndRole.roleId).get()
        val authList = ArrayList<Role>()
        authList.add(role)
//        判断角色为教师

        if (role.id == 2L) {
            val teacher = teacherRepository.findByJobNumber(user.username) ?: throw ResultException("用户查询失败", 500)
            return jwtTokenProvider.createToken(authList, teacher)
        } else if (role.id == 3L) {
            val student = studentRepository.findByStudentNumber(user.username) ?: throw ResultException("用户查询失败", 500)
            return jwtTokenProvider.createToken(authList, student)
        }
        return ""
    }


    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findUserByUsername(username)
                ?: throw UsernameNotFoundException("User '$username' not found")

        return org.springframework.security.core.userdetails.User//
                .withUsername(username)//
                .password(user.password)//
                .authorities("STU")//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build()
    }
}

