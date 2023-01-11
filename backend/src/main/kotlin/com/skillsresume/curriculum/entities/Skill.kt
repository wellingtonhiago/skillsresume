package com.skillsresume.curriculum.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_skill")
data class Skill(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idSkill: Long? = null,
    var name: String,

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    @JsonIgnore
    var curriculum: Curriculum
)
