package com.example.kotlinrandd.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User(

    var id: Int? = null,
    var email: String? = null,
    var password: String? = null,
    var name:String?=null
) {
    @PrimaryKey(autoGenerate = false)
    val uid: Int = CURRENT_USER_ID
}