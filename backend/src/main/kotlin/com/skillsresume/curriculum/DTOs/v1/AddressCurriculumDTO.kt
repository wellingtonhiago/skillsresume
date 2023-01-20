package com.skillsresume.curriculum.DTOs.v1

import com.skillsresume.curriculum.entities.Address

class AddressCurriculumDTO() {
    var idAddress: Long = 0
    var city: String = ""
    var state: String = ""
    var zipCode: String = ""
    var curriculum_id: Long = 0

    constructor(addressEntity: Address) : this() {
        this.idAddress = addressEntity.idAddress
        this.city = addressEntity.city
        this.state = addressEntity.state
        this.zipCode = addressEntity.zipCode
        this.curriculum_id = addressEntity.curriculum?.idCurriculum!!
    }
}