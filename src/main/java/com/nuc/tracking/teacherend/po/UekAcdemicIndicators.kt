package com.nuc.tracking.teacherend.po

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 专业指标点
 */
@Entity
@Table(name = "uek_acdemic_indicators")
@JsonIgnoreProperties(value = ["id"])
class UekAcdemicIndicators {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var num: String? = null
    var name: String? = null
    var weight: Double = 0.toDouble()
    var theme: String? = null

}
