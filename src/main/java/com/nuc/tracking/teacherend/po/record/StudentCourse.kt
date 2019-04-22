package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生对知识点和日常考核方式的关系
 */
@Entity
@Table(name = "nuc_tracking_student_course")
@JsonIgnoreProperties(value = ["id"])
class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var studentId: Long = 0
    var percent: Float = 0f
    var tqPercent: Float = 0f
}