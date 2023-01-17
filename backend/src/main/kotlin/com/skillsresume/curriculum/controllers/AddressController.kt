package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.DTOs.AddressCurriculumDTO
import com.skillsresume.curriculum.services.AddressService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping("/api/address/v1")
class AddressController(val addressService: AddressService) {
    @Operation(summary = "Create Address", description = "Create Address",
        tags = ["Address"],
        responses = [
            ApiResponse(
                description = "Success",
                responseCode = "200",
                content = [
                    Content(array = ArraySchema(schema = Schema(implementation = AddressCurriculumDTO::class)))
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
    fun createAddress(@RequestBody addressCurriculumDTO: AddressCurriculumDTO): ResponseEntity<AddressCurriculumDTO> {
        val addressCurriculumDTOS: AddressCurriculumDTO = addressService.createAddressByCurriculum(addressCurriculumDTO)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(addressCurriculumDTOS.idAddress).toUri()
        return ResponseEntity.created(uri).body(addressCurriculumDTOS)
    }
}