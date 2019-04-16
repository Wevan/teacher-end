package com.nuc.tracking.teacherend.service.impl

import com.nuc.tracking.teacherend.po.entity.StudentRecord
import com.nuc.tracking.teacherend.po.record.StudentCourse
import com.nuc.tracking.teacherend.repository.ClazzRepository
import com.nuc.tracking.teacherend.repository.CourseClassRepository
import com.nuc.tracking.teacherend.repository.StudentRepository
import com.nuc.tracking.teacherend.repository.student.StudentCourseRepository
import com.nuc.tracking.teacherend.service.CourseClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseClassServiceImpl:CourseClassService {
    @Autowired
    private lateinit var courseClassRepository: CourseClassRepository
    @Autowired
    private lateinit var studentCourseRepository:StudentCourseRepository
    @Autowired
    private lateinit var studentRepository: StudentRepository
    @Autowired
    private lateinit var clazzRepository:ClazzRepository

    override fun getCourseMesg(teacherId: Long, courseId: Long): List<Map<String, List<StudentRecord>>> {

        val classList=courseClassRepository.findByCourseIdAndTeacherId(courseId,teacherId)
        var resultList= ArrayList<Map<String, List<StudentRecord>>>()
        classList.map {

            //it为每个班级,迭代每个班级，查出一个班的学生
            var ids =clazzRepository.findByNum(it.classId.toString())
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
}