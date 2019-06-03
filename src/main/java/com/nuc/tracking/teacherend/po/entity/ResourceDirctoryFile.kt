package com.nuc.tracking.teacherend.po.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "uek_resource_dirctory_file")
class ResourceDirctoryFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var name: String? = null
    var pid: Long = 0
    var addtime: Long? = null
    var url: String? = null
    var type: Long = 0
    var size: String? = null
    var percent: Float = 0f
    var courseId: Long = 0
    var chapterId: Long = 0
    var knowledgeId: Long = 0
    var tq_percent: Float = 0f
    var playTimes: Int = 0

    override fun toString(): String {
        return "ResourceDirctoryFile(id=$id, name=$name, pid=$pid, addtime=$addtime, url=$url, type=$type, size=$size, percent=$percent, courseId=$courseId, chapterId=$chapterId, knowledgeId=$knowledgeId, tq_percent=$tq_percent, playTimes=$playTimes)"
    }


}
