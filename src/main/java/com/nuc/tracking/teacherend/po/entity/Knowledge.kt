package com.nuc.tracking.teacherend.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程对应的知识点
 */
@Entity
@Table(name = "uek_acdemic_knowledge")
@JsonIgnoreProperties(value = ["id"])
class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var num: String? = null
    var name: String? = null
    var isDifficult: Long = 0
    var isImportant: Long = 0
    var video: String? = null
    var courseId: Long = 0
    var clickNum: Long = 0
    var chapterId: Long = 0
    var percent:Float = 0f

}
