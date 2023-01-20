package com.skillsresume.curriculum.services.exceptions

class ResourceNotFoundException : RuntimeException {
    constructor(exception: String?) : super(exception)
}