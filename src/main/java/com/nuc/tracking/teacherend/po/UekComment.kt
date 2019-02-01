package com.nuc.tracking.teacherend.po

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_comment")
@JsonIgnoreProperties(value = ["id"])
class UekComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var userId: Long = 0
    var videoId: Long = 0
    var commentTime: java.sql.Timestamp? = null
    var content: String? = null

}
