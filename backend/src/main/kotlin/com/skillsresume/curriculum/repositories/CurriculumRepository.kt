package com.skillsresume.curriculum.repositories

import com.skillsresume.curriculum.entities.Curriculum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CurriculumRepository:JpaRepository<Curriculum, Long> {
    fun findByTitleContaining(title: String, pageable: Pageable): Page<Curriculum>

}