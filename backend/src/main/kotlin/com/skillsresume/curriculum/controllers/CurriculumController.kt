package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.DTOs.v1.CurriculumDetailsDTO
import com.skillsresume.curriculum.DTOs.v1.CurriculumMinDTO
import com.skillsresume.curriculum.services.CurriculumService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping("/api/curriculum/v1")
@Tag(name = "Curriculum", description = "Endpoint for Managing Curriculum")
class CurriculumController(val curriculumService: CurriculumService) {

    @GetMapping
    @Operation(summary = "Finds All Curriculum", description = "Finds all Curriculum",
        tags = ["Curriculum"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = CurriculumMinDTO::class)))
                ]
            ),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun getSearchCurriculums(
        @RequestParam(value = "searchTitle", defaultValue = "") title: String,
        pageable: Pageable
    ): ResponseEntity<Page<CurriculumMinDTO>> {
        return ResponseEntity.ok(curriculumService.findAllSearchCurriculums(title, pageable))
    }

    @GetMapping(value = ["/{id}"])
    @Operation(summary = "Find Curriculum By Id", description = "Find Curriculum By Id",
        tags = ["Curriculum"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = CurriculumMinDTO::class)))
                ]
            ),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun getCurriculumById(@PathVariable id: Long): ResponseEntity<CurriculumDetailsDTO> {
        return ResponseEntity.ok(curriculumService.finCurriculumById(id))
    }

    @PostMapping
    @Operation(summary = "Create Curriculum", description = "Create Curriculum",
        tags = ["Curriculum"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = CurriculumMinDTO::class)))
                ]
            ),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun createNewCurriculum(@RequestBody curriculumMinDTO: CurriculumMinDTO): ResponseEntity<CurriculumMinDTO> {
        val curriculumMinDTO = curriculumService.createCurriculum(curriculumMinDTO)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(curriculumMinDTO.idCurriculum).toUri()
        return ResponseEntity.created(uri).body(curriculumMinDTO)
    }

    @PutMapping(value = ["/{id}"])
    @Operation(summary = "Update Curriculum By Id", description = "Update Curriculum By Id",
        tags = ["Curriculum"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = CurriculumMinDTO::class)))
                ]
            ),
            ApiResponse(description = "No Content", responseCode = "204", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Bad Request", responseCode = "400", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Unauthorized", responseCode = "401", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Not Found", responseCode = "404", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
            ApiResponse(description = "Internal Error", responseCode = "500", content = [
                Content(schema = Schema(implementation = Unit::class))
            ]),
        ]
    )
    fun updateCurriculumById(@PathVariable id: Long, @RequestBody curriculumMinDTO: CurriculumMinDTO): ResponseEntity<CurriculumMinDTO> {
        return ResponseEntity.ok(curriculumService.updateByCurriculum(id, curriculumMinDTO))
    }

}