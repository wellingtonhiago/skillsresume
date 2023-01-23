package com.skillsresume.curriculum.config

import com.skillsresume.curriculum.security.jwt.JwtConfigurer
import com.skillsresume.curriculum.security.jwt.JwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Autowired
    private lateinit var tokenProvider: JwtTokenProvider

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        val encoders: MutableMap<String, PasswordEncoder> = HashMap<String, PasswordEncoder>()
        val pbkdf2Encoder = Pbkdf2PasswordEncoder(
            "", 8, 185000,
            Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256
        )
        encoders["pbkdf2"] = pbkdf2Encoder
        val passwordEncoder = DelegatingPasswordEncoder("pbkdf2", encoders)
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder)
        return passwordEncoder
    }

    @Bean
    fun authenticationManagerBean(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic().disable()
            .csrf { o: CsrfConfigurer<HttpSecurity> -> o.disable() }
            .sessionManagement { session:
                                 SessionManagementConfigurer<HttpSecurity?> ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }
            .authorizeHttpRequests { authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers(
                        "/auth/signin",
                        "/auth/refresh/**",
                        "/v3/api-docs/**",
                        "/swagger-ui/**",
                        "/h2-console/**"
                    )
                    .permitAll()
                    .requestMatchers("/api/**").authenticated()
                    .requestMatchers("/users").denyAll()
            }
            .cors()
            .and()
            .apply(JwtConfigurer(tokenProvider))
            .and()
            .build()
    }
}

//    @Bean
//    @Throws(Exception::class)
//    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
//        http.headers().frameOptions().disable()
//        http.cors().and().csrf().disable()
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        http.authorizeHttpRequests().anyRequest().permitAll()
//        return http.build()
//    }

//    @Bean
//    fun corsConfigurationSource(): CorsConfigurationSource? {
//        val configuration = CorsConfiguration().applyPermitDefaultValues()
//        configuration.allowedMethods = listOf("POST", "GET", "PUT", "DELETE", "OPTIONS")
//        val source = UrlBasedCorsConfigurationSource()
//        source.registerCorsConfiguration("/**", configuration)
//        return source
//    }

