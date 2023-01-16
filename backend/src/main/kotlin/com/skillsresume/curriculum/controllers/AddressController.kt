package com.skillsresume.curriculum.controllers

import com.skillsresume.curriculum.DTOs.AddressCurriculumDTO
import com.skillsresume.curriculum.services.AddressService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI


@RestController
@RequestMapping(value = ["/address"])
class AddressController(val addressService: AddressService) {

    @PostMapping
    fun createAddress(@RequestBody addressCurriculumDTO: AddressCurriculumDTO): ResponseEntity<AddressCurriculumDTO> {
        val addressCurriculumDTOS: AddressCurriculumDTO = addressService.createAddressByCurriculum(addressCurriculumDTO)
        val uri: URI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(addressCurriculumDTOS.idAddress).toUri()
        return ResponseEntity.created(uri).body(addressCurriculumDTOS)
    }
}