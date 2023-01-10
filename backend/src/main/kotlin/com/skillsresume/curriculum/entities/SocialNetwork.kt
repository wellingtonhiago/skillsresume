package com.skillsresume.curriculum.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_social_netowork")
data class SocialNetwork(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idNetwork: Long? = null,
    var name: String,
    var url: String,

    @ManyToOne
    @JoinColumn(name = "curriculum_id")
    var curriculum: Curriculum
)