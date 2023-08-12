package com.example.vaxin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vaccine(
    @PrimaryKey(autoGenerate = false)
    val vaccineName: String,
    val description: String,
    val daysAfterBirth: Int
)
