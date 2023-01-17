package com.skillsresume.curriculum.services.exeptions

class ResourceNotFoundException : RuntimeException {
    constructor(): super("It is not allowed to persist a null object!")
    constructor(exception: String?): super(exception)
}