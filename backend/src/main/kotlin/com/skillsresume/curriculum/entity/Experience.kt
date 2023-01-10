package com.skillsresume.curriculum.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.Date

@Entity
@Table(name = "tb_experience")
data class Experience (
    @Id
    @GeneratedValue
    var idExperience: Long? = null,
    val startDate: Date,
    val endDate: Date,
    val resume: String
)
