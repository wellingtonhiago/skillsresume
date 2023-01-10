package com.skillsresume.curriculum.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idAndress: Long? = null,
    var city: String,
    var state: String,
    var zipCode: String,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)