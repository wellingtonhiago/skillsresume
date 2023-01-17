package com.skillsresume.curriculum.services.exeptions

class ResourceNotFoundException : RuntimeException {
    constructor(exception: String?) : super(exception)
}