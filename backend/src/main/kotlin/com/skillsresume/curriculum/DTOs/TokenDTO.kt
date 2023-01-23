package com.skillsresume.curriculum.DTOs

import java.util.Date

data class TokenDTO(
    val userName: String? = null,
    val authenticated: Boolean? = null,
    val created: Date? = null,
    val expiration: Date? = null,
    val accessToken: String? = null,
    val refreshToken: String? = null,
)
