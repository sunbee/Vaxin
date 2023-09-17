package com.example.vaxin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Child(
    @PrimaryKey(autoGenerate = false)
    val childName: String,
    val dob: String,
    val imageURI: String?
)