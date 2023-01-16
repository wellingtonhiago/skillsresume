package com.skillsresume.curriculum.DTOs

import com.skillsresume.curriculum.entities.Address

class CurriculumAddressDTO() {
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