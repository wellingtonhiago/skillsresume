package com.skillsresume.curriculum.DTOs

import com.skillsresume.curriculum.entities.Curriculum

class CurriculumMinDTO(idCurriculum: Long? = null, title: String = "", objetive: String = ""){
    var idCurriculum: Long? = null
    var title: String = ""
    var objetive: String = ""

    constructor(curriculum: Curriculum) : this(curriculum.idCurriculum) {
        this.idCurriculum = curriculum.idCurriculum
        this.title = curriculum.title
        this.objetive = curriculum.objetive

    }



}
