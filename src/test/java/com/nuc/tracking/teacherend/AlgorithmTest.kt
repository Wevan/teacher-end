package com.nuc.tracking.teacherend

import com.nuc.tracking.teacherend.po.entity.*
import com.nuc.tracking.teacherend.po.record.Student12Ability
import com.nuc.tracking.teacherend.po.record.StudentResource
import com.nuc.tracking.teacherend.po.relation.CollegeAndAbility
import com.nuc.tracking.teacherend.po.relation.CourseAndCollege
import com.nuc.tracking.teacherend.po.relation.CourseTarAndKnowledge
import com.nuc.tracking.teacherend.repository.student.Student12AbilityRepository
import com.nuc.tracking.teacherend.service.point.*
import com.nuc.tracking.teacherend.service.relation.CollegeAndAbilityService
import com.nuc.tracking.teacherend.service.relation.CourseAndCollegeService
import com.nuc.tracking.teacherend.service.relation.CourseTarAndKnowledgeService
import com.nuc.tracking.teacherend.service.student.StudentResourceService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.sql.Date

@RunWith(SpringRunner::class)
@SpringBootTest
class AlgorithmTest {
    /**
     * 添加记录方式比例
     * 测试记录方式
     */
    @Autowired
    lateinit var collegeTargetService: CollegeTargetService
    @Autowired
    lateinit var collegeAndAbilityService: CollegeAndAbilityService
    @Autowired
    lateinit var courseAndCollegeService: CourseAndCollegeService
    @Autowired
    lateinit var courseTargetService: CourseTargetService
    @Autowired
    lateinit var courseService: CourseService
    @Autowired
    lateinit var knowledgeService: KnowledgeService
    @Autowired
    lateinit var dailyWayService: DailyWayService
    @Autowired
    lateinit var globalWayService: GlobalWayService
    @Autowired
    lateinit var resourceService: ResourceService
    @Autowired
    lateinit var courseTarAndKnowledgeService: CourseTarAndKnowledgeService
    @Autowired
    lateinit var studentResourceService: StudentResourceService

    @Autowired
    private lateinit var student12AbilityRepository: Student12AbilityRepository

    @Test
    fun test1() {
        /**
         * 专业指标 及其关系处理部分 uek_college_target
         */
//        首先添加专业指标，这里添加3个

        var collegeTarget1 = CollegeTarget()
        var collegeTarget2 = CollegeTarget()
        var collegeTarget3 = CollegeTarget()
        collegeTarget1.name = "测试专1"
        collegeTarget1.percent = 0.5f
        collegeTarget2.name = "测试专2"
        collegeTarget2.percent = 0.4f
        collegeTarget3.name = "测试专3"
        collegeTarget3.percent = 0.1f

        collegeTargetService.save(collegeTarget1)
        collegeTargetService.save(collegeTarget2)
        collegeTargetService.save(collegeTarget3)

//        添加专业指标和毕业指标的关系 college_ability
        var collegeAndAbility1 = CollegeAndAbility()
        collegeAndAbility1.abilityId = 1
        collegeAndAbility1.collegeTargetId = 1
        collegeAndAbility1.percent = 0.2f

        var collegeAndAbility2 = CollegeAndAbility()
        collegeAndAbility2.abilityId = 1
        collegeAndAbility2.collegeTargetId = 2
        collegeAndAbility2.percent = 0.3f

        var collegeAndAbility3 = CollegeAndAbility()
        collegeAndAbility3.abilityId = 1
        collegeAndAbility3.collegeTargetId = 3
        collegeAndAbility3.percent = 0.5f

        var collegeAndAbility4 = CollegeAndAbility()
        collegeAndAbility4.abilityId = 2
        collegeAndAbility4.collegeTargetId = 1
        collegeAndAbility4.percent = 0.1f

        var collegeAndAbility5 = CollegeAndAbility()
        collegeAndAbility5.abilityId = 2
        collegeAndAbility5.collegeTargetId = 2
        collegeAndAbility5.percent = 0.4f

        var collegeAndAbility6 = CollegeAndAbility()
        collegeAndAbility6.abilityId = 2
        collegeAndAbility6.collegeTargetId = 3
        collegeAndAbility6.percent = 0.5f

        var collegeAndAbility7 = CollegeAndAbility()
        collegeAndAbility7.abilityId = 3
        collegeAndAbility7.collegeTargetId = 1
        collegeAndAbility7.percent = 0.5f

        var collegeAndAbility8 = CollegeAndAbility()
        collegeAndAbility8.abilityId = 3
        collegeAndAbility8.collegeTargetId = 2
        collegeAndAbility8.percent = 0.1f

        var collegeAndAbility9 = CollegeAndAbility()
        collegeAndAbility9.abilityId = 3
        collegeAndAbility9.collegeTargetId = 3
        collegeAndAbility9.percent = 0.3f
//        对关系进行存储
        collegeAndAbilityService.save(collegeAndAbility1)
        collegeAndAbilityService.save(collegeAndAbility2)
        collegeAndAbilityService.save(collegeAndAbility3)
        collegeAndAbilityService.save(collegeAndAbility4)
        collegeAndAbilityService.save(collegeAndAbility5)
        collegeAndAbilityService.save(collegeAndAbility6)
        collegeAndAbilityService.save(collegeAndAbility7)
        collegeAndAbilityService.save(collegeAndAbility8)
        collegeAndAbilityService.save(collegeAndAbility9)

        /**
         * 课程 以及其与专业目标的比例关系 course 9
         * 仅添加一门课程作为测试 courseAndCollege1 1-3 ==course_college
         */
//        新建课程
        var course = Course()
        course.name = "测试课程1"
        courseService.save(course)
//        课程与专业目标的对应
        var courseAndCollege1 = CourseAndCollege()
        courseAndCollege1.courseId = 9
        courseAndCollege1.collegeTargetId = 1
        courseAndCollege1.percent = 0.3f

        var courseAndCollege2 = CourseAndCollege()
        courseAndCollege2.courseId = 9
        courseAndCollege2.collegeTargetId = 2
        courseAndCollege2.percent = 0.1f

        var courseAndCollege3 = CourseAndCollege()
        courseAndCollege3.courseId = 9
        courseAndCollege3.collegeTargetId = 3
        courseAndCollege3.percent = 0.2f
//        对关系进行存储
        courseAndCollegeService.save(courseAndCollege1)
        courseAndCollegeService.save(courseAndCollege2)
        courseAndCollegeService.save(courseAndCollege3)

        /**
         * 课程目标的设定 拟定4个 1-4 uek_acdemic_target
         */
        var courseTarget1 = CourseTarget()
        courseTarget1.courseId = 1
        courseTarget1.name = "测试课标1"
        courseTarget1.percent = 0.25f

        var courseTarget2 = CourseTarget()
        courseTarget2.courseId = 1
        courseTarget2.name = "测试课标2"
        courseTarget2.percent = 0.25f

        var courseTarget3 = CourseTarget()
        courseTarget3.courseId = 1
        courseTarget3.name = "测试课标3"
        courseTarget3.percent = 0.25f

        var courseTarget4 = CourseTarget()
        courseTarget4.courseId = 1
        courseTarget4.name = "测试课标4-全局"
        courseTarget4.percent = 0.25f

        courseTargetService.save(courseTarget1)
        courseTargetService.save(courseTarget2)
        courseTargetService.save(courseTarget3)
        courseTargetService.save(courseTarget4)

        /**
         * 知识点的设定，拟定3个 1530-1532 uek_acdemic_knowledge
         */

        var knowledge1 = Knowledge()
        knowledge1.name = "测试知识点1"
        knowledge1.courseId = 1
        knowledge1.percent = 0.4f

        var knowledge2 = Knowledge()
        knowledge2.name = "测试知识点2"
        knowledge2.courseId = 1
        knowledge2.percent = 0.4f

        var knowledge3 = Knowledge()
        knowledge3.name = "测试知识点3"
        knowledge3.courseId = 1
        knowledge3.percent = 0.2f

        knowledgeService.save(knowledge1)
        knowledgeService.save(knowledge2)
        knowledgeService.save(knowledge3)

        /**
         * 课程目标和知识点的对应关系，只取知识点1作测试
         */
        var courseTarAndKnowledge1=CourseTarAndKnowledge()
        courseTarAndKnowledge1.courseId=9
        courseTarAndKnowledge1.courseTargetId=1
        courseTarAndKnowledge1.knowledgeId=1
        courseTarAndKnowledge1.percent=0.3f

        var courseTarAndKnowledge2=CourseTarAndKnowledge()
        courseTarAndKnowledge2.courseId=9
        courseTarAndKnowledge2.courseTargetId=2
        courseTarAndKnowledge2.knowledgeId=1
        courseTarAndKnowledge2.percent=0.3f

        var courseTarAndKnowledge3=CourseTarAndKnowledge()
        courseTarAndKnowledge3.courseId=9
        courseTarAndKnowledge3.courseTargetId=3
        courseTarAndKnowledge3.knowledgeId=1
        courseTarAndKnowledge3.percent=0.5f

        courseTarAndKnowledgeService.save(courseTarAndKnowledge1)
        courseTarAndKnowledgeService.save(courseTarAndKnowledge2)
        courseTarAndKnowledgeService.save(courseTarAndKnowledge3)


        /**
         * 课程对应的考核方式 1-3 daily_way,1 global_way
         */
        var dailyWay1 = DailyWay()
        dailyWay1.courseId = 1
        dailyWay1.name = "测试资源"
        dailyWay1.percent = 0.5f

        var dailyWay2 = DailyWay()
        dailyWay2.courseId = 1
        dailyWay2.name = "测试考试"
        dailyWay2.percent = 0.3f

        var dailyWay3 = DailyWay()
        dailyWay3.courseId = 1
        dailyWay3.name = "测试作业"
        dailyWay3.percent = 0.2f

        dailyWayService.save(dailyWay1)
        dailyWayService.save(dailyWay2)
        dailyWayService.save(dailyWay3)

        var globalWay = GlobalWay()
        globalWay.courseId = 1
        globalWay.percent = 1f
        globalWay.name = "测试考勤"
        globalWayService.save(globalWay)

        /**
         * 资源-知识点1的资源分布 133-135 uek_resource_dirctory_file
         */
        var resource1 = ResourceDirctoryFile()
        resource1.courseId = 1
        resource1.name = "测试资源1"
        resource1.percent = 0.6f

        var resource2 = ResourceDirctoryFile()
        resource2.courseId = 1
        resource2.name = "测试资源2"
        resource2.percent = 0.2f

        var resource3 = ResourceDirctoryFile()
        resource3.courseId = 1
        resource3.name = "测试资源3"
        resource3.percent = 0.2f
        resourceService.save(resource1)
        resourceService.save(resource2)
        resourceService.save(resource3)

    }

    @Test
    fun tes2(){
        /**
         * 学生记录-仅资源记录
         * uid 811
         */
        var studentResource=StudentResource()
        studentResource.studentId=1713010101
        studentResource.courseId=9
        studentResource.knowledgeId=1530
        studentResource.resourceId=133
        studentResource.percent=1f

        studentResourceService.save(studentResource)
    }

    @Test
    fun test3(){
//        /**
////         * 课程目标和知识点的对应关系，只取知识点1作测试
////         */
////        var courseTarAndKnowledge1=CourseTarAndKnowledge()
////        courseTarAndKnowledge1.courseId=9
////        courseTarAndKnowledge1.courseTargetId=1
////        courseTarAndKnowledge1.knowledgeId=1
////        courseTarAndKnowledge1.percent=0.3f
////
////        var courseTarAndKnowledge2=CourseTarAndKnowledge()
////        courseTarAndKnowledge2.courseId=9
////        courseTarAndKnowledge2.courseTargetId=2
////        courseTarAndKnowledge2.knowledgeId=1
////        courseTarAndKnowledge2.percent=0.3f
////
////        var courseTarAndKnowledge3=CourseTarAndKnowledge()
////        courseTarAndKnowledge3.courseId=9
////        courseTarAndKnowledge3.courseTargetId=3
////        courseTarAndKnowledge3.knowledgeId=1
////        courseTarAndKnowledge3.percent=0.5f
////
////        courseTarAndKnowledgeService.save(courseTarAndKnowledge1)
////        courseTarAndKnowledgeService.save(courseTarAndKnowledge2)
////        courseTarAndKnowledgeService.save(courseTarAndKnowledge3)
        var studentRAbility = Student12Ability()
        studentRAbility.studentId = 812L
        studentRAbility.abilityId = 1
        studentRAbility.percent = 0.5f
        studentRAbility.tqPercent = 0.2f
        studentRAbility.date = Date(System.currentTimeMillis()).toString()
        student12AbilityRepository.save(studentRAbility)
    }

}