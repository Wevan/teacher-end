package com.nuc.tracking.teacherend.controller

import com.nuc.tracking.teacherend.po.entity.StudentSelfPercent
import com.nuc.tracking.teacherend.repository.student.StudentCourseRepository
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.StudentGraduateService
import com.nuc.tracking.teacherend.service.StudentService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 学生信息查询
 */
@RestController
@RequestMapping("/student")
class StudentContoller {
    @Autowired
    private lateinit var studentService: StudentService
    @Autowired
    private lateinit var studentGraduateService: StudentGraduateService
    @Autowired
    private lateinit var studentCourseRepository: StudentCourseRepository

    /**
     * 获取用户信息
     * @param studentNumber 学号1713010101
     * @return 返回结果
     */
    @GetMapping("/detail")
    fun getOne(studentNumber: String): Result {
        val student = studentService.findOne(studentNumber)
        println("In studentContll get $studentNumber")
        return ResultUtils.success(200, "获取成功", student)
    }


    /**
     * 获取毕业达成度
     */
    @GetMapping("/graduate")
    fun getGraduate(studentNumber: Long): Result {
        var graduate = studentGraduateService.findByStudentNumber(studentNumber)
        return ResultUtils.success(200, "获取成功", graduate)
    }

    /**
     * 获取学生list及其对该课程的selfPercent
     */
    @GetMapping("/studentPercentList")
    fun studentPercentList(courseId: Long, classId: Long): Result {
        println("Get Param courseId $courseId,classId $classId")
        var studentList = ArrayList<StudentSelfPercent>()
        var tempList = studentService.findAllByClassId(classId)
        tempList.forEach {
            var studentSelfPercent = StudentSelfPercent()
            studentSelfPercent.student = it
            // 此处的studentId为1713010101型
            val percent = studentCourseRepository.findByCourseIdAndStudentId(courseId, it.studentNumber!!.toLong())?.percent
            if (percent != null) {
                studentSelfPercent.selfPercent = percent
            } else {
                studentSelfPercent.selfPercent = 0f
            }
            studentList.add(studentSelfPercent)
        }
        return ResultUtils.success(200, "获取成功", studentList)
    }
}