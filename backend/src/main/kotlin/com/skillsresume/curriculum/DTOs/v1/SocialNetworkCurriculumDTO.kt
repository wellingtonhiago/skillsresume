package com.skillsresume.curriculum.DTOs.v1

import com.skillsresume.curriculum.entities.SocialNetwork

class SocialNetworkCurriculumDTO() {
    var idNetwork: Long = 0
    var name: String = ""
    var url: String = ""
    var socialNetwork_id: Long = 0
    constructor(socialNetworkEntity: SocialNetwork) : this() {
        this.idNetwork = socialNetworkEntity.idNetwork
        this.name = socialNetworkEntity.name
        this.url = socialNetworkEntity.url
        this.socialNetwork_id = socialNetworkEntity.idNetwork
    }
}