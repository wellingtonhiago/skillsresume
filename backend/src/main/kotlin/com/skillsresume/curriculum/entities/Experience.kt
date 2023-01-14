package com.skillsresume.curriculum.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "tb_experience")
data class Experience(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idExperience: Long? = null,
    var startDate: Date,
    var endDate: Date,
    var resume: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum_id")
    @JsonIgnore
    var curriculum: Curriculum

) {
    override fun toString(): String {
        return "Experience(idExperience=$idExperience, startDate=$startDate, endDate=$endDate, resume='$resume', curriculum=$curriculum)"
    }
}
