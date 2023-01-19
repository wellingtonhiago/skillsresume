package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.v1.SocialNetworkCurriculumDTO
import com.skillsresume.curriculum.DTOs.v1.SocialNetworkDTO
import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.entities.SocialNetwork
import com.skillsresume.curriculum.repositories.CurriculumRepository
import com.skillsresume.curriculum.repositories.SocialNetworkCurriculumRepository
import com.skillsresume.curriculum.services.exceptions.DataBaseException
import com.skillsresume.curriculum.services.exceptions.ResourceNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Service
class SocialNetworkService(
    val socialNetworkCurriculumRepository: SocialNetworkCurriculumRepository,
    val curriculumRepository: CurriculumRepository
) {
    @Transactional(readOnly = false)
    fun createSocialByCurriculum(socialNetworkCurriculumDTO: SocialNetworkCurriculumDTO): SocialNetworkCurriculumDTO {
        val id = socialNetworkCurriculumDTO.socialNetwork_id
        val curriculumEntity: Curriculum =
            curriculumRepository.findById(id).orElseThrow { ResourceNotFoundException("Curriculum Not Found") }
        val socialNetworkEntity = SocialNetwork(
            name = socialNetworkCurriculumDTO.name,
            url = socialNetworkCurriculumDTO.url,
            curriculum = curriculumEntity
        )
        return SocialNetworkCurriculumDTO(socialNetworkCurriculumRepository.save(socialNetworkEntity))
    }

    @Transactional(readOnly = false)
    fun updateSocialById(id: Long, socialNetworkDTO: SocialNetworkDTO): SocialNetworkDTO {
        try {
            val socialNetworkEntity = socialNetworkCurriculumRepository.getReferenceById(id)
            socialNetworkEntity.name = socialNetworkDTO.name
            socialNetworkEntity.url = socialNetworkDTO.url
            return SocialNetworkDTO(socialNetworkCurriculumRepository.save(socialNetworkEntity))
        } catch (e: EmptyResultDataAccessException) {
            throw ResourceNotFoundException("Social Network Not Found")
        } catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Curriculum Not Found")
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    fun deleteSocialById(id: Long) {
        try {
            val socialEntity = socialNetworkCurriculumRepository.findById(id)
                .orElseThrow { ResourceNotFoundException("Social Network Not Found") }
            socialEntity.curriculum.socialNetwork?.remove(socialEntity)
            socialNetworkCurriculumRepository.delete(socialEntity)
        } catch (e: EmptyResultDataAccessException) {
            throw ResourceNotFoundException("Social Network Not Found")
        } catch (e: JpaObjectRetrievalFailureException) {
            throw ResourceNotFoundException("Curriculum Not Found")
        } catch (e: DataIntegrityViolationException) {
            throw DataBaseException("Referential integrity failure")
        }
    }
}