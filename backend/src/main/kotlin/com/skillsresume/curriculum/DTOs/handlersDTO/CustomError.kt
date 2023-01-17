package com.skillsresume.curriculum.DTOs.handlersDTO

import java.time.Instant

open class CustomError (
    val timestamp: Instant,
    val status: Int,
    val error: String,
    val path: String
)
