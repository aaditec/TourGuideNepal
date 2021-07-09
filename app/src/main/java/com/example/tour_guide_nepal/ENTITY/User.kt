package com.example.finalassignment.ENTITY

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var fullname: String? = null,
    var username: String? = null,
    var phone: String? = null,
    var password: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}