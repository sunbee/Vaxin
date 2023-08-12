package com.example.vaxin.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.vaxin.data.Child
import com.example.vaxin.data.Vaccine

data class ChildWithVaccines (
    @Embedded val child: Child,
    @Relation(
        parentColumn = "childName",
        entityColumn = "vaccineName",
        associateBy = Junction(ChildVaccineCrossRef::class)
    )
    val vaccines: List<Vaccine>
)
