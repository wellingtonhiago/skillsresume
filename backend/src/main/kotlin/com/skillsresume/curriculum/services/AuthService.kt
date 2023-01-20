package com.skillsresume.curriculum.services

import com.skillsresume.curriculum.DTOs.AccountCredentialsDTO
import com.skillsresume.curriculum.DTOs.TokenDTO
import com.skillsresume.curriculum.repositories.UserRepository
import com.skillsresume.curriculum.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class AuthService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var tokenProvider: JwtTokenProvider

    fun signin(data: AccountCredentialsDTO): ResponseEntity<*> {
        return try {
            val userName = data.userName
            val password = data.password
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(userName, password))
            val user = userRepository.findByUserName(userName)
            val tokenResponse: TokenDTO = if (user != null) {
                tokenProvider.createAccesToken(userName!!, user.roles)
            } else {
                throw UsernameNotFoundException("Username $userName not found")
            }
            ResponseEntity.ok(tokenResponse)
        } catch (e: AuthenticationException) {
            throw BadCredentialsException("Invalid username or password supplied!")
        }
    }
}