package com.nuc.tracking.teacherend.po.record

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 学生对单个资源的完成度
 */
@Entity
@Table(name = "nuc_tracking_student_resource")
@JsonIgnoreProperties(value = ["id"])

class StudentResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId:Long =0
    var resourceId:Long =0
    var knowledgeId:Long =0
    var courseId: Long = 0
    var percent: Float = 0f
}