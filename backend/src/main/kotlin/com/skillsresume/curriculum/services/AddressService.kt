package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.AddressCurriculumDTO
import com.skillsresume.curriculum.entities.Address
import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.AddressRepository
import com.skillsresume.curriculum.repositories.CurriculumRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AddressService(val addressRepository: AddressRepository, val curriculumRepository: CurriculumRepository) {

    @Transactional(readOnly = false)
    fun createAddressByCurriculum(addressCurriculumDTO: AddressCurriculumDTO): AddressCurriculumDTO {
        val id = addressCurriculumDTO.curriculum_id
        val curriculumEntity: Curriculum = curriculumRepository.findById(id).orElse(null)
        val address = Address(
            state = addressCurriculumDTO.state,
            city = addressCurriculumDTO.city,
            zipCode = addressCurriculumDTO.zipCode,
            curriculum = curriculumEntity
        )

        curriculumEntity.address = address
        curriculumRepository.save(address.curriculum!!)
        return AddressCurriculumDTO(address)
//        return CurriculumAddressDTO(curriculumEntity.address!!)
    }


}