package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生对课程目标的完成度
 */
@Entity
@Table(name = "nuc_tracking_student_course_target")
@JsonIgnoreProperties(value = ["id"])
class StudentCourseTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId:Long = 0
    var percent: Float = 0f
    var courseTargetId: Long = 0
    var courseId:Long=0
    var tqPercent: Float = 0f
    var dateTime: String = ""
}