package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.CurriculumAddressDTO
import com.skillsresume.curriculum.entities.Address
import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.AddressRepository
import com.skillsresume.curriculum.repositories.CurriculumRepository
import org.springframework.stereotype.Service

@Service
class AddressService(val addressRepository: AddressRepository, val curriculumRepository: CurriculumRepository) {
    fun createAddressByCurriculum(curriculumAddressDTO: CurriculumAddressDTO): CurriculumAddressDTO {
        val id = curriculumAddressDTO.curriculum_id
        val curriculumEntity: Curriculum = curriculumRepository.findById(id).orElse(null)
        val address = Address(
            state = curriculumAddressDTO.state,
            city = curriculumAddressDTO.city,
            zipCode = curriculumAddressDTO.zipCode,
            curriculum = curriculumEntity
        )

        curriculumEntity.address = address
        curriculumRepository.save(address.curriculum!!)
        return CurriculumAddressDTO(address)
//        return CurriculumAddressDTO(curriculumEntity.address!!)
    }


}