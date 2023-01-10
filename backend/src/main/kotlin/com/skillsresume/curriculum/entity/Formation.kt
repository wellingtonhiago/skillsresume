package com.skillsresume.curriculum.entity

import jakarta.persistence.*

@Entity
@Table(name = "tb_formation")
data class Formation(
    @Id
    @GeneratedValue
    var idFormation: Long? = null,
    var name: String,

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)