package com.skillsresume.curriculum.DTOs.v1

import com.skillsresume.curriculum.entities.SocialNetwork

class SocialNetworkDTO() {
    var idNetwork: Long = 0
    var name: String = ""
    var url: String = ""

    constructor(socialNetworkEntity: SocialNetwork) : this() {
        this.idNetwork = socialNetworkEntity.idNetwork
        this.name = socialNetworkEntity.name
        this.url = socialNetworkEntity.url
    }
}