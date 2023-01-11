package com.skillsresume.curriculum.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "tb_curriculum")
data class Curriculum(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCurriculum: Long? = null,
    var title: String,
    var objetive: String,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var socialNetwork: MutableList<SocialNetwork>,

    @JsonBackReference(value = "curriculum")
    @OneToOne(mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var address: Address,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var experience: MutableList<Experience>,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var skill: MutableList<Skill>,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var formation: MutableList<Formation>
)

