package com.example.vaxin.data

import androidx.room.Query
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.data.relations.ChildWithVaccines
import com.example.vaxin.data.relations.VaccineWithChilds
import kotlinx.coroutines.flow.Flow

interface VaxinRepository {

    suspend fun insertChild(child: Child)

    suspend fun insertVaccine(vaccine: Vaccine)

    suspend fun insertChildVaccineCrossRef(childVaccineCrossRef: ChildVaccineCrossRef)

    fun getVaccinesOfChild(childName: String): Flow<List<ChildWithVaccines>>

    fun getChildsOfVaccine(vaccineName: String): Flow<List<VaccineWithChilds>>

    fun getChilds(): Flow<List<Child>>

    fun getVaccines(): Flow<List<Vaccine>>
}