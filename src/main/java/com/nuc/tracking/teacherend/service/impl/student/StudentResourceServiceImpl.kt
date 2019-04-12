package com.nuc.tracking.teacherend.service.impl.student

import com.nuc.tracking.teacherend.po.entity.Knowledge
import com.nuc.tracking.teacherend.po.entity.Student
import com.nuc.tracking.teacherend.po.record.*
import com.nuc.tracking.teacherend.repository.point.CollegeTargetRepository
import com.nuc.tracking.teacherend.repository.point.CourseTargetRepository
import com.nuc.tracking.teacherend.repository.point.DailyWayRepository
import com.nuc.tracking.teacherend.repository.point.ResourceRepository
import com.nuc.tracking.teacherend.repository.relation.CollegeAndAbilityRepository
import com.nuc.tracking.teacherend.repository.relation.CourseAndCollegeRepository
import com.nuc.tracking.teacherend.repository.relation.CourseTarAndKnowledgeRepository
import com.nuc.tracking.teacherend.repository.student.*
import com.nuc.tracking.teacherend.service.point.CollegeTargetService
import com.nuc.tracking.teacherend.service.student.StudentResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date

@Service
class StudentResourceServiceImpl : StudentResourceService {
    override fun findOne(id: Long): StudentResource {
        val studentResource: StudentResource = studentResourceRepository.findById(id).get()
        return studentResource
    }

    @Autowired
    private lateinit var studentResourceRepository: StudentResourceRepository
    @Autowired
    private lateinit var studentknowledgeRepository: StudentKnowledgeRepository
    @Autowired
    private lateinit var studentCourseTargetRepository: StudentCourseTargetRepository
    @Autowired
    private lateinit var studentCourseRepository: StudentCourseRepository
    @Autowired
    private lateinit var studentCollegeTargetRepository: StudentCollegeTargetRepository
    @Autowired
    private lateinit var student12AbilityRepository: Student12AbilityRepository

    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository
    @Autowired
    private lateinit var dailyWayRepository: DailyWayRepository
    @Autowired
    private lateinit var courseTargetRepository: CourseTargetRepository
    @Autowired
    private lateinit var courseAndCollegeRepository: CourseAndCollegeRepository
    @Autowired
    private lateinit var collegeAndAbilityRepository: CollegeAndAbilityRepository
    @Autowired
    private lateinit var courseTarAndKnowledgeRepository: CourseTarAndKnowledgeRepository
    @Autowired
    private lateinit var resourceRepository: ResourceRepository
    @Autowired
    private lateinit var collegeTargetRepository: CollegeTargetRepository


    override fun save(studentResource: StudentResource) {
//        studentResourceRepository.save(studentResource)
        /**
         * 知识点记录=>知识点的完成度+= 资源完成度*资源所占百分比*资源对应的考核方式
         */

        var knowledge: Knowledge = knowledgeRepository.findById(studentResource.knowledgeId).get()
        var studentKnowledge = studentknowledgeRepository.findByKnowledgeIdAndStudentId(studentResource.knowledgeId,
                studentResource.studentId)
        if (studentKnowledge == null) {
            studentKnowledge = StudentKnowledge()
            studentKnowledge.chapterId = studentResource.chapterId
            studentKnowledge.courseId = studentResource.courseId
            studentKnowledge.chapterId = studentResource.chapterId
            studentKnowledge.studentId = studentResource.studentId
        }
        studentKnowledge.percent += studentResource.percent * dailyWayRepository.findDailyWayByCourseIdAndType(studentResource.courseId, "1").percent *
                resourceRepository.findById(studentResource.resourceId).get().percent
        studentKnowledge.tqPercent += dailyWayRepository.findDailyWayByCourseIdAndType(studentResource.courseId, "1").percent *
                resourceRepository.findById(studentResource.resourceId).get().percent
        studentKnowledge.dateTime = Date(System.currentTimeMillis()).toString()

        println("知识点记录=>知识点的完成度+= 资源完成度*资源对应的考核方式*资源所占百分比")
        println("" + studentResource.percent + "*" + dailyWayRepository.findDailyWayByCourseIdAndType(studentResource.courseId, "1").percent + "*" +
                resourceRepository.findById(studentResource.resourceId).get().percent + "=" + studentKnowledge.percent)
        println()
//        studentknowledgeRepository.save(studentKnowledge)

        /**
         * 课程目标达成度+= 知识点的完成度*该知识点在知识点中的percent*该知识点所占课程的百分比，存入与知识点对应的各个课程目标即可
         */
        var courseTarAndKnowledgeList = courseTarAndKnowledgeRepository.findAllByCourseId(studentResource.courseId)

        println("课程目标达成度+= 上一部分的乘积值*该知识点的percent，存入与知识点对应的各个课程目标即可")
        val courseTargetList = courseTarAndKnowledgeList.map { item ->
            var studentCourseTarget = studentCourseTargetRepository.findByCourseTargetIdAndStudentId(item.courseTargetId,
                    studentResource.studentId)
            if (studentCourseTarget == null) {
                studentCourseTarget = StudentCourseTarget()
                studentCourseTarget.courseTargetId = item.courseTargetId
                studentCourseTarget.studentId = studentResource.studentId
            }
            studentCourseTarget.dateTime = Date(System.currentTimeMillis()).toString()

            studentCourseTarget.percent += studentKnowledge.percent * knowledge.percent * item.percent

            studentCourseTarget.tqPercent += studentKnowledge.tqPercent * knowledge.percent * item.percent

//            studentCourseTargetRepository.save(studentCourseTarget)
            println("" + studentKnowledge.percent + "*" + knowledge.percent + "*" + item.percent + "=" + studentCourseTarget.percent)
            println()
            return@map studentCourseTarget!!
        }
        /**
         * 课程达成度 每个课程目标的达成度*自己所占的百分比 叠加
         * courseTargetList 是上一部分已经计算好课程目标的学生记录列表
         */
        var studentCourse = studentCourseRepository.findByCourseIdAndStudentId(studentResource.courseId,
                studentResource.studentId)
        if (studentCourse == null) {
            studentCourse = StudentCourse()
            studentCourse.courseId = studentResource.courseId
            studentCourse.studentId = studentResource.studentId
        }
        println("课程达成度 每个课程目标的达成度*自己所占的百分比")
        for (i in 0 until courseTargetList.size) {
            studentCourse.percent += courseTargetList[i].percent *
                    courseTargetRepository.findById(courseTargetList[i].courseTargetId).get().percent
            studentCourse.tqPercent += courseTargetList[i].tqPercent *
                    courseTargetRepository.findById(courseTargetList[i].courseTargetId).get().percent

            println("此表达式的值是累加值不是乘积值" + courseTargetList[i].percent + "*" + courseTargetRepository.findById(courseTargetList[i].courseTargetId).get().percent + "=" +
                    studentCourse.percent)
            println()
        }
//        studentCourseRepository.save(studentCourse)
        /**
         * 专业目标达成度+= 与该课程对应的专业目标*课程达成度
         */
        var collegeTargetList = courseAndCollegeRepository.findAllByCourseId(studentResource.courseId)
        println("专业目标达成度+= 与该课程对应的专业目标*课程达成度")
        val studentCollegeTargetList = collegeTargetList.map { item ->
            var studentCollegeTarget = studentCollegeTargetRepository.findAllByCourseIdAndStudentIdAndCollegeTargetId(
                    studentResource.courseId, studentResource.studentId, item.collegeTargetId
            )
            if (studentCollegeTarget == null) {
                studentCollegeTarget = StudentCollegeTarget()
                studentCollegeTarget.studentId = studentResource.studentId
                studentCollegeTarget.collegeTargetId = item.collegeTargetId
                studentCollegeTarget.dateTime = Date(System.currentTimeMillis()).toString()
                studentCollegeTarget.courseId = studentResource.courseId
            }
            studentCollegeTarget.percent += studentCourse.percent * item.percent
            studentCollegeTarget.tqPercent += studentCourse.tqPercent * item.percent

            println("" + studentCourse.percent + "*" + item.percent + "=" + studentCollegeTarget.percent)
            println()
//            studentCollegeTargetRepository.save(studentCollegeTarget)
            return@map studentCollegeTarget!!
        }

        /**
         * 毕业目标达成度+= 对应的专业目标达成度*毕业目标占比
         * studentCollegeTargetList 上一部分计算所得的学生专业目标列表
         */

        println("毕业目标达成度+= 对应的专业目标达成度*专业目标之间的占比*毕业目标占比")
        var student12AbilityList = student12AbilityRepository.findAll()
//        毕业目标列表
        student12AbilityList.map { item2 ->
            //            专业目标列表

//                根据毕业目标作基准开始迭代，故先以毕业目标去查询关系
            var collegeAndAbility = collegeAndAbilityRepository.findByAbilityId(item2.id)
//                  关系列表迭代
            collegeAndAbility.map { item1 ->
                studentCollegeTargetList.forEach { item ->
                    //                    初始化存储对象
                    var studentRAbility = student12AbilityRepository.findByStudentIdAndCollegeTargetId(
                            studentResource.studentId, item.collegeTargetId
                    )
                    if (studentRAbility == null) {
                        studentRAbility = Student12Ability()
                        studentRAbility.studentId = studentResource.studentId
                        studentRAbility.collegeTargetId = item.collegeTargetId
                    }
                    studentRAbility.date = Date(System.currentTimeMillis()).toString()

                    studentRAbility.percent += item.percent * collegeTargetRepository.findById(item.collegeTargetId).get().percent * item1.percent
                    studentRAbility.tqPercent += item.tqPercent * item1.percent
                    println("" + item.percent + "*" + item1.percent + "*" + collegeTargetRepository.findById(item.collegeTargetId).get().percent + "=" + studentRAbility.percent)
                    println()


//                student12AbilityRepository.save(studentRAbility)
                }
            }


        }

    }
}