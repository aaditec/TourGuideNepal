package com.example.tour_guide_nepal.ENTITY

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var email: String? = null,
    var fullname: String? = null,
    var phone: String? = null,
    var password: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}