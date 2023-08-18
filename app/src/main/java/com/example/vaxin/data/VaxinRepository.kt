package com.example.vaxin.data

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.data.relations.ChildWithVaccines
import com.example.vaxin.data.relations.VaccineWithChilds
import kotlinx.coroutines.flow.Flow

interface VaxinRepository {

/* (C)RUD - CREATE */
suspend fun insertChild(child: Child)

suspend fun insertVaccine(vaccine: Vaccine)

suspend fun insertChildVaccineCrossRef(childVaccineCrossRef: ChildVaccineCrossRef)

/* C(R)UD - RETRIEVE */
fun getVaccinesOfChild(childName: String): Flow<List<ChildWithVaccines>>

fun getChildsOfVaccine(vaccineName: String): Flow<List<VaccineWithChilds>>

fun getChilds(): Flow<List<Child>>

fun getVaccines(): Flow<List<Vaccine>>

fun getChildVaccineCrossRefs(childName: String): Flow<List<ChildVaccineCrossRef>>

fun getChildVaccineCrossRef(childName: String, vaccineName: String): ChildVaccineCrossRef

/* CRU(D) - DELETE */
fun deleteChild(child: Child)

fun deleteVaccinesOfChild(childName: String)

fun deleteChilds()

fun deleteChildVaccinesCrossRefs()
}