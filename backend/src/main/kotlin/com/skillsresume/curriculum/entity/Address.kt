package com.skillsresume.curriculum.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_andress")
data class Address(
    @Id
    @GeneratedValue
    var idAndress: Long? = null,
    var city: String,
    var state: String,
    var zipCode: String
)