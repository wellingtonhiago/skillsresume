package com.skillsresume.curriculum.security.jwt

import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.filter.GenericFilterBean
@Service
class JwtTokenFilter(@field:Autowired val tokenProvider: JwtTokenProvider) : GenericFilterBean() {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token = tokenProvider.resolveToken(request as HttpServletRequest)
        if(!token.isNullOrBlank() && tokenProvider.validateToken(token)) {
            val auth = tokenProvider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = auth
        }
        chain?.doFilter(request, response)
    }
}