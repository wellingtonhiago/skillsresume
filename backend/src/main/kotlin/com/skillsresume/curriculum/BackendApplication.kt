package com.skillsresume.curriculum

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

@SpringBootApplication
class BackendApplication

fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
/*
    val encoders: MutableMap<String, PasswordEncoder> = HashMap<String, PasswordEncoder>()
    val pbkdf2Encoder = Pbkdf2PasswordEncoder("", 8, 185000,
        Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256)
    encoders["pbkdf2"] = pbkdf2Encoder
    val passwordEncoder = DelegatingPasswordEncoder("pbkdf2", encoders)
    passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder)

    val result = passwordEncoder.encode("amora")
    println("My hash $result")
 */
}
