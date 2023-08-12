package com.example.vaxin.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.vaxin.data.Child
import com.example.vaxin.data.Vaccine

class VaccineWithChilds (
    @Embedded val vaccine: Vaccine,
    @Relation(
        parentColumn = "vaccineName",
        entityColumn = "childName",
        associateBy = Junction(ChildVaccineCrossRef::class)
    )
    val childs: List<Child>
)