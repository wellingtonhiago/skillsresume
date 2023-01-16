package com.skillsresume.curriculum.entities

import jakarta.persistence.*

@Entity
@Table(name = "tb_curriculum")
data class Curriculum(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idCurriculum: Long = 0,
    var title: String = "",
    var objetive: String = ""
) {
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var socialNetwork: MutableList<SocialNetwork>? = arrayListOf()

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var address: Address? = null

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var experience: MutableList<Experience>? = arrayListOf()

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var skill: MutableList<Skill>? = arrayListOf()

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "curriculum", cascade = [CascadeType.ALL])
    var formation: MutableList<Formation>? = arrayListOf()
    override fun toString(): String {
        return ""
    }

}





