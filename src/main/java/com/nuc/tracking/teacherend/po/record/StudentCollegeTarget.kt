package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生对专业目标的完成度
 */
@Entity
@Table(name = "student_college_target")
@JsonIgnoreProperties(value = ["id"])
class StudentCollegeTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId = 0
    var percent: Float = 0f
    var collegeTargetId: Long = 0
    var tqPercent: Float = 0f
    var dateTime: String = ""
}