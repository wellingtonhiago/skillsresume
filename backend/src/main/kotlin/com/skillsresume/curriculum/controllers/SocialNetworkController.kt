package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.DTOs.v1.AddressDTO
import com.skillsresume.curriculum.DTOs.v1.SocialNetworkCurriculumDTO
import com.skillsresume.curriculum.DTOs.v1.SocialNetworkDTO
import com.skillsresume.curriculum.services.SocialNetworkService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping("/api/social/v1")
class SocialNetworkController (val socialNetworkService: SocialNetworkService) {
    @Operation(summary = "Create Social Network", description = "Create Social Network",
        tags = ["Social"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = SocialNetworkCurriculumDTO::class)))
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
    @PostMapping
    fun createSocial(@RequestBody socialNetworkCurriculumDTO: SocialNetworkCurriculumDTO): ResponseEntity<SocialNetworkCurriculumDTO> {
        val socialNetworkCurriculumDTO = socialNetworkService.createSocialByCurriculum(socialNetworkCurriculumDTO)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(socialNetworkCurriculumDTO.idNetwork).toUri()
        return ResponseEntity.created(uri).body(socialNetworkCurriculumDTO)
    }

    @PutMapping(value = ["/{id}"])
    @Operation(summary = "Update Social Network By Id", description = "Update Social Network By Id",
        tags = ["Social"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = AddressDTO::class)))
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
    fun updateAddress(@PathVariable id: Long, @RequestBody socialNetworkDTO: SocialNetworkDTO): ResponseEntity<SocialNetworkDTO> {
        return ResponseEntity.ok(socialNetworkService.updateSocialById(id, socialNetworkDTO))
    }

    @Operation(summary = "Update Social Network By Id", description = "Update Social Network By Id",
        tags = ["Social"],
        responses = [
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
    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: Long): ResponseEntity<Void?>? {
        socialNetworkService.deleteSocialById(id)
        return ResponseEntity.noContent().build()
    }
}