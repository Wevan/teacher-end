package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生的全局考核方式完成度
 */
@Entity
@Table(name = "uek_student_resource")
@JsonIgnoreProperties(value = ["id"])
class StudentGlobalWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId:Long =0
    var courseId: Long = 0
    var globalWayId:Long=0
    var percent: Float = 0f
}