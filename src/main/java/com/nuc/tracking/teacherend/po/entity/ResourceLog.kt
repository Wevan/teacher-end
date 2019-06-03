package com.nuc.tracking.teacherend.po.entity

import java.sql.Timestamp
import javax.persistence.*

/**
 * 资源对该班级应该完成的时间段
 */
@Entity
@Table(name = "nuc_tracking_resource_log")
class ResourceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId: Long = 0
    var resourceId: Long = 0
    lateinit var time: Timestamp
    var name: String? = ""

    override fun toString(): String {
        return "ResourceLog(id=$id, studentId=$studentId, resourceId=$resourceId, time=$time, name=$name)"
    }


}