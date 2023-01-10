package com.skillsresume.curriculum.entity

import jakarta.persistence.*

@Entity
@Table(name = "tb_andress")
data class Address(
    @Id
    @GeneratedValue
    var idAndress: Long? = null,
    var city: String,
    var state: String,
    var zipCode: String,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)