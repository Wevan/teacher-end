package com.nuc.tracking.teacherend.vo

/**
 * @author 杨晓辉 2019/6/3 20:43
 */
/**
 * 推荐资源返回
 * @property id Long
 * @property name String?
 * @property pid Long
 * @property addtime Long?
 * @property url String?
 * @property type Long
 * @property size String?
 * @property percent Float
 * @property courseId Long
 * @property chapterId Long
 * @property knowledgeId Long
 * @property tq_percent Float
 * @property playTimes Int
 */
class RecommendResource {
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
    var rankScore: Float = 0.0f


    /**
     * id 一致 该资源一致
     * @return Int
     */
    override fun hashCode(): Int {
        return id.toInt()
    }

    /**
     * 比较id一致性
     * @param other Any?
     * @return Boolean
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RecommendResource

        if (id != other.id) return false


        return true
    }

    override fun toString(): String {
        return "RecommendResource(id=$id, name=$name, pid=$pid, addtime=$addtime, url=$url, type=$type, size=$size, percent=$percent, courseId=$courseId, chapterId=$chapterId, knowledgeId=$knowledgeId, tq_percent=$tq_percent, playTimes=$playTimes, rankScore=$rankScore)"
    }


}