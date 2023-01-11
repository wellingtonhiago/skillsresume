package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.CurriculumRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping(value = ["/curriculum"])
class CurriculumController (var curriculumRepository: CurriculumRepository) {

    @GetMapping
    fun getCurriculums(pageable: Pageable): ResponseEntity<Page<Curriculum>> {
        val curriculum: Page<Curriculum> = curriculumRepository.findAll(pageable)
        return ResponseEntity.ok(curriculum)
    }

    @GetMapping(value = ["/{id}"])
    fun getCurriculumById(@PathVariable id: Long): ResponseEntity<Optional<Curriculum>> {
        val curriculum: Optional<Curriculum> = curriculumRepository.findById(id)
        return ResponseEntity.ok(curriculum)
    }
}