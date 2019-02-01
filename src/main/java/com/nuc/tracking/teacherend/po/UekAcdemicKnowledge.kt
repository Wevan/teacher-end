package com.nuc.tracking.teacherend.po

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_acdemic_knowledge")
@JsonIgnoreProperties(value = ["id"])
class UekAcdemicKnowledge {
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

}
