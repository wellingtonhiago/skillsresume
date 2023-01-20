package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.v1.AddressCurriculumDTO
import com.skillsresume.curriculum.DTOs.v1.AddressDTO
import com.skillsresume.curriculum.entities.Address
import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.AddressRepository
import com.skillsresume.curriculum.repositories.CurriculumRepository
import com.skillsresume.curriculum.services.exceptions.ResourceNotFoundException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class AddressService(val addressRepository: AddressRepository, val curriculumRepository: CurriculumRepository) {

    @Transactional(readOnly = false)
    fun createAddressByCurriculum(addressCurriculumDTO: AddressCurriculumDTO): AddressCurriculumDTO {
        val id = addressCurriculumDTO.curriculum_id
        val curriculumEntity: Curriculum =
            curriculumRepository.findById(id).orElseThrow { ResourceNotFoundException("Curriculum Not Found") }
        val address = Address(
            state = addressCurriculumDTO.state,
            city = addressCurriculumDTO.city,
            zipCode = addressCurriculumDTO.zipCode,
            curriculum = curriculumEntity
        )
        curriculumEntity.address = address
        addressRepository.save(address)
        return AddressCurriculumDTO(address)
    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    fun updateAddressById(id: Long, addressDTO: AddressDTO): AddressDTO {
        try {
            val addressEntity = addressRepository.getReferenceById(id)
            addressEntity.city = addressDTO.city
            addressEntity.state = addressDTO.state
            addressEntity.zipCode = addressDTO.zipCode
            return AddressDTO(addressRepository.save(addressEntity))
        } catch (e: EmptyResultDataAccessException) {
            throw ResourceNotFoundException("Address Not Found")
        } catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Curriculum Not Found")
        }
    }
}