package com.skillsresume.curriculum.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_skill")
data class Skill (
    @Id
    @GeneratedValue
    var idSkill: Long? = null,
    var name: String,
)
