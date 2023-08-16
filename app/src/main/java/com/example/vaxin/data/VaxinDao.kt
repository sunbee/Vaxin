package com.example.vaxin.data

import androidx.room.Dao
import androidx.room.Delete
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

    /*
    * (C)RUD
    * Populate DB.
    * Use-Case:
    * 1. Use in initialization to pre-populate the DB with sample data.
    * 2. Use in user-originated event to add a child.
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChild(child: Child)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVaccine(vaccine: Vaccine)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChildVaccineCrossRef(crossRef: ChildVaccineCrossRef)

    /*
    * C(R)UD
    * Get information from one or more tables.
    * The operation to get data navigating relationships across tables
    * has the annotation @Transaction to reflect that it is a DB transaction
    * to be performed as one unit with multiple steps.
    * */
    @Transaction
    @Query("SELECT * FROM Child WHERE childName = :childName")
    fun getVaccinesOfChild(childName: String): Flow<List<ChildWithVaccines>>

    @Transaction
    @Query("SELECT * FROM Vaccine WHERE vaccineName = :vaccineName")
    fun getChildsOfVaccine(vaccineName: String): Flow<List<VaccineWithChilds>>

    @Query("SELECT * FROM Child")
    fun getChilds(): Flow<List<Child>>

    @Query("SELECT * FROM Vaccine")
    fun getVaccines(): Flow<List<Vaccine>>

    /*
    * CRU(D)
    * Remove records.
    * A many-many relationship requires manual deletion of related records
    * to avoid leaving orphaned rows in the DB.
    * Use-Case:
    * 1. Remove a child with the vaccination record.
    * 2. Clear out the child and cross-references for initialization or reset.
    * */
    @Delete
    fun deleteChild(child: Child)

    @Query("DELETE FROM ChildVaccineCrossRef WHERE childName = :childName")
    fun deleteVaccinesOfChild(childName: String)

    /*
    * RESET - USE WITH CAUTION!!
    * */
    @Query("DELETE FROM Child")
    fun deleteChilds()

    @Query("DELETE FROM ChildVaccineCrossRef")
    fun deleteChildVaccinesCrossRefs()

}