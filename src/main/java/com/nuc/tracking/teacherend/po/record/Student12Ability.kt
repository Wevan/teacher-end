package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生对毕业目标的达成度
 */
@Entity
@Table(name = "student_ability")
@JsonIgnoreProperties(value = ["id"])
class Student12Ability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId: Long = 0
    var date: String = ""
    var percent:Float=0f
    var tqPercent:Float=0f
}
