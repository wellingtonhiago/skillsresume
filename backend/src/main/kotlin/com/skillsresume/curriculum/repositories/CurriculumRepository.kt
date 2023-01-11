package com.skillsresume.curriculum.repositories

import com.skillsresume.curriculum.entities.Curriculum
import org.springframework.data.jpa.repository.JpaRepository

interface CurriculumRepository:JpaRepository<Curriculum, Long> {
}