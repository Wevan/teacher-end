package com.nuc.tracking.teacherend.po.teacher

import javax.persistence.*

@Entity
@Table(name = "nuc_admin_course_direct")
class CourseDirect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var collegeId: Long = 0
    var direction: Float = 0f
    var commen: Float = 0f
}