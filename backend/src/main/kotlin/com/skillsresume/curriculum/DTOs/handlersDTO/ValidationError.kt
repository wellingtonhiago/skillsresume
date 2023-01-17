package com.skillsresume.curriculum.DTOs.handlersDTO

import java.time.Instant


class ValidationError(timestamp: Instant?, status: Int?, error: String?, path: String?) :
    CustomError(timestamp!!, status!!, error!!, path!!) {
    private val fieldMessages: MutableList<FieldMessage> = ArrayList()
    fun getFieldMessages(): List<FieldMessage> {
        return fieldMessages
    }

    fun addError(fieldName: String?, message: String?) {
        fieldMessages.add(FieldMessage(fieldName!!, message!!))
    }
}