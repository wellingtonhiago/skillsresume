package com.skillsresume.curriculum.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_formation")
data class Formation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idFormation: Long? = null,
    var name: String,
    val startDate: Date,
    val endDate: Date,

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)