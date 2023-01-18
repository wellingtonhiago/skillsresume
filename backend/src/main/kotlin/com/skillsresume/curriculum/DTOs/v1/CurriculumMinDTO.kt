package com.skillsresume.curriculum.DTOs.v1

import com.skillsresume.curriculum.entities.Curriculum

class CurriculumMinDTO(
    var idCurriculum: Long = 0,
    var title: String = "",
    var objetive: String = ""
) {

    constructor(curriculum: Curriculum) : this() {
        this.idCurriculum = curriculum.idCurriculum
        this.title = curriculum.title
        this.objetive = curriculum.objetive
    }
}
