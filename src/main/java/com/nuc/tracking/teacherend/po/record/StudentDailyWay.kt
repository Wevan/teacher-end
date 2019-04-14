package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 全局考核方式的关系
 */
@Entity
@Table(name = "student_daily_way")
@JsonIgnoreProperties(value = ["id"])
class StudentDailyWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var typeId:Long = 0
    var courseId: Long = 0
    var studentId: Long = 0
    var typeName: String = ""
    var percent: Float = 0f
}