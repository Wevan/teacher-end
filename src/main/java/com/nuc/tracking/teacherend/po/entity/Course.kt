package com.nuc.tracking.teacherend.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "uek_acdemic_course")
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var collegeId: Long = 0
    var num: String = ""
    var name: String = ""
    var introduce: String = ""
    var percent: Float = 0f
    var coverImage: String? = null
    var level: String? = null
    var direction: String? = null
    var score: String? = null
    var classHour: String? = null
    var requirement: String? = null


}
