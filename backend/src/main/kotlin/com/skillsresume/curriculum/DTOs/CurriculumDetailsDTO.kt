package com.skillsresume.curriculum.DTOs

import com.skillsresume.curriculum.entities.*

class CurriculumDetailsDTO(){
    var idCurriculum: Long? = null
    var title: String = ""
    var objetive: String = ""
    var socialNetwork: MutableList<SocialNetworkDTO> = arrayListOf()
    lateinit var address: AddressDTO
    var experience: MutableList<ExperienceDTO> = arrayListOf()
    var skill: MutableList<SkillDTO> = arrayListOf()
    var formation: MutableList<FormationDTO> = arrayListOf()

    constructor(curriculumEntity: Curriculum) : this() {
        this.idCurriculum = curriculumEntity.idCurriculum
        this.title = curriculumEntity.title
        this.objetive = curriculumEntity.objetive
        this.socialNetwork = curriculumEntity.socialNetwork.map { x -> SocialNetworkDTO(x) }.toMutableList()
        this.address = AddressDTO(curriculumEntity.address)
        this.experience = curriculumEntity.experience.map { x -> ExperienceDTO(x) }.toMutableList()
        this.skill = curriculumEntity.skill.map { x -> SkillDTO(x) }.toMutableList()
        this.formation = curriculumEntity.formation.map { x -> FormationDTO(x) }.toMutableList()
    }
}
