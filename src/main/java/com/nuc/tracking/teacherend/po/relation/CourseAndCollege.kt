package com.nuc.tracking.teacherend.po.relation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程和专业目标的关系
 */
@Entity
@Table(name = "nuc_tracking_course_college")
@JsonIgnoreProperties(value = ["id"])
class CourseAndCollege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var collegeTargetId: Long = 0
    var percent: Float = 0f
}