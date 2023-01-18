package com.skillsresume.curriculum.DTOs.v1

import com.skillsresume.curriculum.entities.Formation
import java.util.*

class FormationDTO() {
    var idFormation: Long? = null
    var name: String = ""
    lateinit var startDate: Date
    lateinit var endDate: Date

    constructor(formationEntity: Formation) : this() {
        this.idFormation = formationEntity.idFormation
        this.name = formationEntity.name
        this.startDate = formationEntity.startDate
        this.endDate = formationEntity.endDate
    }
}