package com.skillsresume.curriculum.controllers.handlers

import com.skillsresume.curriculum.DTOs.handlersDTO.CustomError
import com.skillsresume.curriculum.DTOs.handlersDTO.ValidationError
import com.skillsresume.curriculum.services.exceptions.DataBaseException
import com.skillsresume.curriculum.services.exceptions.ResourceNotFoundException
import jakarta.servlet.http.HttpServletRequest
import org.hibernate.exception.ConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFound(e: ResourceNotFoundException, request: HttpServletRequest): ResponseEntity<CustomError?>? {
        val status: HttpStatus = HttpStatus.NOT_FOUND
        val error = e.message?.let { CustomError(Instant.now(), status.value(), it, request.requestURI) }
        return ResponseEntity.status(status).body<CustomError>(error)
    }

    @ExceptionHandler(DataBaseException::class)
    fun dataBase(e: DataBaseException, request: HttpServletRequest): ResponseEntity<CustomError?>? {
        val status: HttpStatus = HttpStatus.BAD_REQUEST
        val error = e.message?.let { CustomError(Instant.now(), status.value(), it, request.requestURI) }
        return ResponseEntity.status(status).body<CustomError>(error)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValid(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<CustomError?>? {
        val status: HttpStatus = HttpStatus.UNPROCESSABLE_ENTITY
        val err = ValidationError(Instant.now(), status.value(), "Dados inválidos", request.requestURI)
        for (f in e.bindingResult.fieldErrors) {
            err.addError(f.field, f.defaultMessage)
        }
        return ResponseEntity.status(status).body<CustomError>(err)
    }

    @ExceptionHandler(ConstraintViolationException::class)
    fun handleConstraintViolationException(
        e: ConstraintViolationException?,
        request: HttpServletRequest
    ): ResponseEntity<CustomError> {
        val status: HttpStatus = HttpStatus.BAD_REQUEST
        val error = CustomError(Instant.now(), status.value(), "Dados já cadastrado", request.requestURI)
        return ResponseEntity.status(status).body(error)
    }
}