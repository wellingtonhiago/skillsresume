package com.skillsresume.curriculum.entities

import jakarta.persistence.*
import org.springframework.security.core.GrantedAuthority

@Entity
@Table(name = "tb_permission")
class Permission : GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    @Column(name = "description", length = 255)

    var description: String? = null
    override fun getAuthority() = description

}