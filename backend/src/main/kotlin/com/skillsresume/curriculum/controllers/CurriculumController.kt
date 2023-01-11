package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.entities.Curriculum
import com.skillsresume.curriculum.repositories.CurriculumRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*


@RestController
@RequestMapping(value = ["/curriculum"])
class CurriculumController(var curriculumRepository: CurriculumRepository) {

    @GetMapping(value = ["/search"])
    fun getCurriculumsAndSearch(
        @RequestParam(value = "title", defaultValue = "") title: String,
        pageable: Pageable
    ): ResponseEntity<Page<Curriculum>> {
        return ResponseEntity.ok(curriculumRepository.findByTitleContaining(title, pageable))
    }

    @GetMapping(value = ["/{id}"])
    fun getCurriculumById(@PathVariable id: Long): ResponseEntity<Optional<Curriculum>> {
        val curriculum: Optional<Curriculum> = curriculumRepository.findById(id)
        return ResponseEntity.ok(curriculum)
    }
}