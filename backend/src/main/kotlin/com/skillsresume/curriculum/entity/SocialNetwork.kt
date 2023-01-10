package com.skillsresume.curriculum.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "tb_socialNetowork")
data class SocialNetwork(
    @Id
    @GeneratedValue
    var idNetwork: Long? = null,
    var name: String,
    var url: String,

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)