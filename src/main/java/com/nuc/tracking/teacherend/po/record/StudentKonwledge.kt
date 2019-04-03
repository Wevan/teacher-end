package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生对知识点的掌握程度
 */
@Entity
@Table(name = "student_knowledge")
@JsonIgnoreProperties(value = ["id"])
class StudentKonwledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var chapterId: Long = 0
    var knowledgeId: Long = 0
    var dateTime:String=""
    var percent:Float=0f
    var tqPercent:Float=0f
}