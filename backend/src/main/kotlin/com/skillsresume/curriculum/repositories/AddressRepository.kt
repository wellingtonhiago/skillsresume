package com.skillsresume.curriculum.repositories

import com.skillsresume.curriculum.entities.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Long> {
}