package com.skillsresume.curriculum.repositories

import com.skillsresume.curriculum.entities.SocialNetwork
import org.springframework.data.jpa.repository.JpaRepository

interface SocialNetworkCurriculumRepository: JpaRepository<SocialNetwork, Long> {
}