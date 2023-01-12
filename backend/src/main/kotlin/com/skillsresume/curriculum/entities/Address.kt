package com.skillsresume.curriculum.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "tb_address")
data class Address(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idAndress: Long? = null,
    var city: String,
    var state: String,
    var zipCode: String,

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "curriculum_id")
    @JsonIgnore
    var curriculum: Curriculum
)