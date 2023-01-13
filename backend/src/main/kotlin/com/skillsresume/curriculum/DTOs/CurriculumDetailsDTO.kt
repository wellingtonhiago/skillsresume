package com.skillsresume.curriculum.DTOs

import com.skillsresume.curriculum.entities.*

class CurriculumDetailsDTO(){
    var idCurriculum: Long? = null
    var title: String = ""
    var objetive: String = ""
    var socialNetwork: MutableList<SocialNetwork> = arrayListOf()
    lateinit var address: Address
    var experience: MutableList<Experience> = arrayListOf()
    var skill: MutableList<Skill> = arrayListOf()
    var formation: MutableList<Formation> = arrayListOf()

    constructor(curriculum: Curriculum) : this() {
        this.idCurriculum = curriculum.idCurriculum
        this.title = curriculum.title
        this.objetive = curriculum.objetive
        this.socialNetwork = curriculum.socialNetwork
        this.address = curriculum.address
        this.experience = curriculum.experience
        this.skill = curriculum.skill
        this.formation = curriculum.formation
    }
}
