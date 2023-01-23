package com.skillsresume.curriculum.services.exceptions

import org.springframework.security.core.AuthenticationException

class InvalidJwtAuthenticationException(exception: String?)
    : AuthenticationException(exception)


