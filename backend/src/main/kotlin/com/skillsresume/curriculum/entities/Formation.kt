package com.skillsresume.curriculum.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tb_formation")
data class Formation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idFormation: Long? = null,
    var name: String,
    var startDate: Date,
    var endDate: Date,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curriculum_id")
    @JsonIgnore
    var curriculum: Curriculum


) {
    override fun toString(): String {
        return "Formation(idFormation=$idFormation, name='$name', startDate=$startDate, endDate=$endDate, curriculum=$curriculum)"
    }
}