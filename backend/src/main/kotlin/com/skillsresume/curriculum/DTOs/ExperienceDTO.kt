package com.skillsresume.curriculum.DTOs

import com.skillsresume.curriculum.entities.Experience
import java.util.*

class ExperienceDTO() {
    var idExperience: Long? = null
    lateinit var startDate: Date
    lateinit var endDate: Date
    lateinit var resume: String

    constructor(experienceEntity: Experience) : this() {
        this.idExperience = experienceEntity.idExperience
        this.startDate = experienceEntity.startDate
        this.endDate = experienceEntity.endDate
        this.resume = experienceEntity.resume
    }
}