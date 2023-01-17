package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.CurriculumDetailsDTO
import com.skillsresume.curriculum.DTOs.CurriculumMinDTO
import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.CurriculumRepository
import com.skillsresume.curriculum.services.exceptions.DataBaseException
import com.skillsresume.curriculum.services.exceptions.ResourceNotFoundException
import org.hibernate.exception.ConstraintViolationException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.NullPointerException


@Service
class CurriculumService(val curriculumRepository: CurriculumRepository) {
    @Transactional(readOnly = true)
    fun findAllSearchCurriculums(titleSearch: String, pageable: Pageable):
            Page<CurriculumMinDTO> {
        val curriculums: Page<Curriculum> =
            curriculumRepository.findByTitleContaining(titleSearch.uppercase(), pageable)
        return curriculums.map { x -> CurriculumMinDTO(x) }
    }

    @Transactional(readOnly = true)
    fun finCurriculumById(id: Long): CurriculumDetailsDTO {
        try {
            val curriculum: Curriculum =
                curriculumRepository.findById(id).orElseThrow { ResourceNotFoundException("User not found") }
            return (CurriculumDetailsDTO(curriculum))
        } catch (e: NullPointerException) {
            throw ResourceNotFoundException("Curriculum has no registered Address")
        }
    }

    @Transactional(readOnly = true)
    fun createCurriculum(curriculumMinDTO: CurriculumMinDTO): CurriculumMinDTO {
        try {
            val curriculumEntity = Curriculum(
                title = curriculumMinDTO.title,
                objetive = curriculumMinDTO.objetive
            )
            curriculumRepository.save(curriculumEntity)
            return CurriculumMinDTO(curriculumEntity)
        } catch (e: ConstraintViolationException) {
            throw ResourceNotFoundException("Personalizar ")
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    fun updateByCurriculum(id: Long, curriculumMinDTO: CurriculumMinDTO): CurriculumMinDTO {
        try {
            val curriculumEntity = curriculumRepository.getReferenceById(id)
            curriculumEntity.title = curriculumMinDTO.title
            curriculumEntity.objetive = curriculumMinDTO.objetive
            return CurriculumMinDTO(curriculumRepository.save(curriculumEntity))
        } catch (e: EmptyResultDataAccessException) {
            throw ResourceNotFoundException("Curriculum not found")
        } catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Curriculum not found")
        } catch (e: DataIntegrityViolationException) {
            throw DataBaseException("Referential integrity failure")
        }
    }

}



