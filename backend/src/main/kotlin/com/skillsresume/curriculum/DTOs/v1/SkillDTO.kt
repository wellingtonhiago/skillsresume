package com.skillsresume.curriculum.DTOs.v1

import com.skillsresume.curriculum.entities.Skill

class SkillDTO () {
    var idSkill: Long? = null
    var name: String = ""

    constructor(skillEntity: Skill): this() {
        this.idSkill = skillEntity.idSkill
        this.name = skillEntity.name
    }
}