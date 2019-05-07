package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.CourseClass
import com.nuc.tracking.teacherend.po.entity.PersonalRecord
import com.nuc.tracking.teacherend.po.entity.StudentRecord
import com.nuc.tracking.teacherend.po.pport.PersonalAbility
import com.nuc.tracking.teacherend.po.pport.PersonalCollegeTarget
import com.nuc.tracking.teacherend.po.pport.PersonalCourse
import com.nuc.tracking.teacherend.po.pport.PersonalCourseTarget
import com.nuc.tracking.teacherend.po.record.Student12Ability
import com.nuc.tracking.teacherend.po.record.StudentCollegeTarget
import com.nuc.tracking.teacherend.po.record.StudentCourse
import com.nuc.tracking.teacherend.po.record.StudentCourseTarget
import com.nuc.tracking.teacherend.repository.ClazzRepository
import com.nuc.tracking.teacherend.repository.CourseClassRepository
import com.nuc.tracking.teacherend.repository.StudentRepository
import com.nuc.tracking.teacherend.repository.point.CollegeTargetRepository
import com.nuc.tracking.teacherend.repository.point.CourseRepository
import com.nuc.tracking.teacherend.repository.point.CourseTargetRepository
import com.nuc.tracking.teacherend.repository.point.RAbilityRepository
import com.nuc.tracking.teacherend.repository.student.Student12AbilityRepository
import com.nuc.tracking.teacherend.repository.student.StudentCollegeTargetRepository
import com.nuc.tracking.teacherend.repository.student.StudentCourseRepository
import com.nuc.tracking.teacherend.repository.student.StudentCourseTargetRepository
import com.nuc.tracking.teacherend.service.CourseClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseClassServiceImpl:CourseClassService {
    override fun findAllByCourseIdAndClassId(courseId: Long, classId: Long): List<CourseClass> {
        return courseClassRepository.findByCourseIdAndClassId(courseId, classId)
    }

    override fun findAllByTeacherIdAndCourseId(teacherId: Long, courseId: Long): List<CourseClass> {
        return courseClassRepository.findByCourseIdAndTeacherId(courseId, teacherId)
    }

    @Autowired
    private lateinit var courseClassRepository: CourseClassRepository
    @Autowired
    private lateinit var studentCourseRepository:StudentCourseRepository
    @Autowired
    private lateinit var studentCourseTargetRepository: StudentCourseTargetRepository
    @Autowired
    private lateinit var studentRepository: StudentRepository
    @Autowired
    private lateinit var clazzRepository:ClazzRepository
    @Autowired
    private lateinit var courseRepository:CourseRepository
    @Autowired
    private lateinit var courseTargetRepository:CourseTargetRepository
    @Autowired
    private lateinit var collegeTargetRepository: CollegeTargetRepository
    @Autowired
    private lateinit var abilityRepository:RAbilityRepository
    @Autowired
    private lateinit var studentCollegeTargetRepository: StudentCollegeTargetRepository
    @Autowired
    private lateinit var student12AbilityRepository: Student12AbilityRepository

    override fun getCourseMesg(teacherId: Long, courseId: Long): List<Map<String, List<StudentRecord>>> {

        val classList=courseClassRepository.findByCourseIdAndTeacherId(courseId,teacherId)
        var resultList= ArrayList<Map<String, List<StudentRecord>>>()
        classList.map {

            //it为每个班级,迭代每个班级，查出一个班的学生
            var ids =clazzRepository.findById(it.classId).get()
            var studentList=studentRepository.findByClassId(ids.id)
            var classRecord=ArrayList<StudentRecord>()

            //迭代studentList，从studentCourse表中寻找该表记录，存入班级list
            studentList.map { item->

                //item为每个学生
                val studentCourse=studentCourseRepository.findByCourseIdAndStudentId(courseId,item.studentNumber!!.toLong())
                var sname=studentRepository.findByStudentNumber(item.studentNumber.toString())

                if (studentCourse != null&&sname!=null) {
                    var studentRecord=StudentRecord()
                    studentRecord.name=sname.name!!
                    studentRecord.studentCourse=studentCourse
                    classRecord.add(studentRecord)
                }
            }


            if (classRecord.size!=0){
                var mapItem=HashMap<String, List<StudentRecord>>()
                mapItem[it.classId.toString()] = classRecord
                resultList.add(mapItem)
            }

        }
        return resultList
    }

    override fun getStudentMesg(studentId: Long): PersonalRecord {
        var student=studentRepository.findByStudentNumber(studentId.toString())!!
        var ids =clazzRepository.findById(student.classId!!).get()

        println("student id $studentId, find student class ${student.classId},Course class ${ids.num}")

        //据sid查班级，据班级查课程list
        var courseList= courseClassRepository.findByClassId(student.classId!!)

        //记录课程达标的List
        var coursePercentList=HashMap<String, PersonalCourse>()

        //记录课程目标的list
        var courseTargetPercentList=HashMap<String,List<PersonalCourseTarget>>()

        //记录专业目标的List
        var collegeTargetList=ArrayList<PersonalCollegeTarget>()

        //记录毕业目标的List
        var abilityList=ArrayList<PersonalAbility>()

        var personalRecord=PersonalRecord()

        //开始迭代
        courseList.map {
            /**
             *  课程目标达标，根据课程号和学号查出一门课的课程达标记录，为Map<String,List<StudentCourseTarget>>
             *  将记录加到存储课程目标的list中
             */

            var courseTargetPercent=studentCourseTargetRepository.findByCourseIdAndStudentId(
                    it.courseId,studentId
            )
            if (courseTargetPercent!=null){
                var personalCourseTargetList=courseTargetPercent.map { mapItem->
                    var personalCourseTarget=PersonalCourseTarget()
                    personalCourseTarget.name=courseTargetRepository.findById(mapItem.courseTargetId).get().name
                    personalCourseTarget.studentCourseTarget=mapItem
                    return@map personalCourseTarget
                }
                courseTargetPercentList[it.classId.toString()]=personalCourseTargetList
            }

            /**
             *  课程达标记录
             */

            var coursePercent=studentCourseRepository.findByCourseIdAndStudentId(it.courseId,studentId)
            if (coursePercent != null) {
                var personalCourse=PersonalCourse()
                personalCourse.name=courseRepository.findById(it.courseId).get().name
                personalCourse.studentCourse=coursePercent

                personalCourse.studentCourseTargetList=courseTargetPercentList
                coursePercentList[it.courseId.toString()]=personalCourse
            }



        }

        if (courseTargetPercentList.size!=0){
            //专业目标达标记录，根据sid查即可
            var temp=studentCollegeTargetRepository.findAllByStudentId(studentId)
            if (temp!=null){
                var list=temp.map { mapItem->
                    var personalCollegeTarget=PersonalCollegeTarget()
                    personalCollegeTarget.name=collegeTargetRepository.findById(mapItem.collegeTargetId).get().name
                    personalCollegeTarget.studentCollegeTarget=mapItem
                    return@map personalCollegeTarget
                }
                collegeTargetList= list as ArrayList<PersonalCollegeTarget>
            }

            //毕业目标记录，据sid查询
            var temp2=student12AbilityRepository.findByStudentId(studentId)
            if (temp2!=null){
                var list=temp2.map { mapItem->
                    var personalAbility=PersonalAbility()
                    personalAbility.name=abilityRepository.findById(mapItem.abilityId).get().name!!
                    personalAbility.ability=mapItem
                    return@map personalAbility
                }
                abilityList= list as ArrayList<PersonalAbility>
            }

        }


        personalRecord.classId=ids.num!!
        personalRecord.name= student.name.toString()
        personalRecord.studentAbilityList=abilityList
        personalRecord.studentCollegeTargetList=collegeTargetList
        personalRecord.studentCourseList=coursePercentList
        return personalRecord

    }


}