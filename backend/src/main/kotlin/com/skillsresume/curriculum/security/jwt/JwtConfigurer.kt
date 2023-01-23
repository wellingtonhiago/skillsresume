package com.skillsresume.curriculum.security.jwt

import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class JwtConfigurer(val tokenProvider: JwtTokenProvider) :
    SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {

        override fun configure(http: HttpSecurity) {
            val customFilter = JwtTokenFilter(tokenProvider)
            http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter::class.java)
        }
}