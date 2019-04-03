package com.nuc.tracking.teacherend.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_resource_dirctory_file")
class ResourceDirctoryFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var name: String? = null
    var pid: Long = 0
    var addtime: String? = null
    var url: String? = null
    var type: Long = 0
    var size: String? = null
    var percent: Long = 0
    var courseId: Long = 0
    var chapterId: Long = 0

}
