package com.nuc.tracking.teacherend.po

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_acdemic_course_class")
@JsonIgnoreProperties(value = ["id"])
class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var teacherId:Long=0
    var classId:Long=0
    var courseId: Long = 0
}