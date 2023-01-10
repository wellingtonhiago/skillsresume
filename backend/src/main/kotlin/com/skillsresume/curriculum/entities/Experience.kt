package com.skillsresume.curriculum.entities

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "tb_experience")
data class Experience(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idExperience: Long? = null,
    val startDate: Date,
    val endDate: Date,
    val resume: String,

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)
