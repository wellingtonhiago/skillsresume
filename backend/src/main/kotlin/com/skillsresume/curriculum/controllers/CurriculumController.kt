package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.DTOs.CurriculumDetailsDTO
import com.skillsresume.curriculum.DTOs.CurriculumMinDTO
import com.skillsresume.curriculum.services.CurriculumService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/curriculum"])
class CurriculumController(val curriculumService: CurriculumService) {

    @GetMapping
    fun getSearchCurriculums(
        @RequestParam(value = "searchTitle", defaultValue = "") title: String,
        pageable: Pageable
    ): ResponseEntity<Page<CurriculumMinDTO>> {
        return ResponseEntity.ok(curriculumService.findAllSearchCurriculums(title, pageable))
    }
    @GetMapping(value = ["/{id}"])
     fun getCurriculumById(@PathVariable id: Long): ResponseEntity<CurriculumDetailsDTO> {
        return ResponseEntity.ok(curriculumService.finCurriculumById(id))
    }

}