package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.CurriculumDetailsDTO
import com.skillsresume.curriculum.DTOs.CurriculumMinDTO
import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.CurriculumRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional


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
        val curriculum: Curriculum = curriculumRepository.findById(id).orElse(null)
        return (CurriculumDetailsDTO(curriculum))
    }

    @Transactional(readOnly = true)
    fun createCurriculum(curriculumMinDTO: CurriculumMinDTO): CurriculumMinDTO {
        val curriculumEntity = Curriculum(
            title = curriculumMinDTO.title,
            objetive = curriculumMinDTO.objetive
        )
        curriculumRepository.save(curriculumEntity)
        return CurriculumMinDTO(curriculumEntity)
    }

    @Transactional(readOnly = false)
    fun updateByCurriculum(id: Long, curriculumMinDTO: CurriculumMinDTO): CurriculumMinDTO {
        val curriculumEntity = curriculumRepository.getReferenceById(id)
        curriculumEntity.title = curriculumMinDTO.title
        curriculumEntity.objetive = curriculumMinDTO.objetive
        return CurriculumMinDTO(curriculumRepository.save(curriculumEntity))
    }

}