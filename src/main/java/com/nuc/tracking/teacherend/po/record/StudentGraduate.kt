package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 *  学生毕业达成度
 */
@Entity
@Table(name = "nuc_tracking_student_graduate")
@JsonIgnoreProperties(value = ["id"])
class StudentGraduate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId: Long = 0
    var percent:Float=0f
}