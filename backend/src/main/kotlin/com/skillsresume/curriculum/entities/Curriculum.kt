package com.skillsresume.curriculum.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_curriculum")
data class Curriculum(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCurriculum: Long? = null,
    var title: String,
    var objetive: String,

    @OneToMany(mappedBy = "curriculum")
    var socialNetwork: MutableList<SocialNetwork>,

    @OneToOne(mappedBy = "curriculum")
    var address: Address,

    @OneToMany(mappedBy = "curriculum")
    var experience: MutableList<Experience>,

    @OneToMany(mappedBy = "curriculum")
    var skill: MutableList<Skill>,

    @OneToMany(mappedBy = "curriculum")
    var formation: MutableList<Formation>
)
