package com.example.vaxin.data.relations

import androidx.room.Entity

@Entity(primaryKeys = ["childName", "vaccineName"])
data class ChildVaccineCrossRef(
    val childName: String,
    val vaccineName: String,
    val dueDate: String,
    val isDone: Boolean
)
