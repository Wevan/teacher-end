package com.nuc.tracking.teacherend.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

import javax.persistence.*

@Entity
@Table(name = "test")
@JsonIgnoreProperties(value = ["id"])
class Excel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: String ? = null

    @Column(length = 45, nullable = false)
    var username: String? = null


    @Column(length = 100, nullable = false)
    var email: String? = null

    @Column(length = 45, nullable = false)
    var password: String? = null

    @Column(length = 45)
    var role: String? = null

    constructor() {}

    constructor(user: Excel) {
        this.id = user.id
        this.username = user.username
        this.role = user.role
        this.email = user.email
        this.password = user.password
    }

    companion object {

        val serialVersionUID = 1L
    }


}
