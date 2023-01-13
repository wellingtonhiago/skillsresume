package com.skillsresume.curriculum.DTOs

import com.skillsresume.curriculum.entities.Curriculum

class CurriculumMinDTO(){
     var idCurriculum: Long? = null
     var title: String = ""
     var objetive: String = ""

    constructor(curriculum: Curriculum) : this() {
        this.idCurriculum = curriculum.idCurriculum
        this.title = curriculum.title
        this.objetive = curriculum.objetive
    }
}
