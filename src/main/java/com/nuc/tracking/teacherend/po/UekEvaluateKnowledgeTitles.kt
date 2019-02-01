package com.nuc.tracking.teacherend.po

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*


@Entity
@Table(name = "uek_evaluate_knowledge_titles")
@JsonIgnoreProperties(value = ["id"])

class UekEvaluateKnowledgeTitles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var knowledgeId: Long = 0
    var titleId: Long = 0
    var status: String? = null

}
