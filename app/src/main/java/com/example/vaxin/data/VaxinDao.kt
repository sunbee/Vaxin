package com.example.vaxin.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.data.relations.ChildWithVaccines
import com.example.vaxin.data.relations.VaccineWithChilds
import kotlinx.coroutines.flow.Flow

@Dao
interface VaxinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChild(child: Child)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVaccine(vaccine: Vaccine)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChildVaccineCrossRef(crossRef: ChildVaccineCrossRef)

    @Transaction
    @Query("SELECT * FROM Child WHERE childName = :childName")
    fun getVaccinesOfChild(childName: String): Flow<List<ChildWithVaccines>>

    @Transaction
    @Query("SELECT * FROM Vaccine WHERE vaccineName = :vaccineName")
    fun getChildsOfVaccine(vaccineName: String): Flow<List<VaccineWithChilds>>
}