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
    * 1. Use in initialization to pre-populate the DB with sample data in view-model initialization.
    * 2. Use in user-originated event to add a child from UI.
    * 3. Update the vaccination status of a child from UI.
    * Note that the set-up requires manually populating the cross-ref table
    * one record at a time to establish the many-many relationship between
    * child and vaccine. This cross-ref table holds qualifying attributes
    * of the relationship, such as, due-date and completion status.
    * Use the insert method to update completion status from UI as well.
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
    * Cross-Ref
    * Use cross-ref table to access child's vaccination schedule and update status.
    * This table has qualifying information such as vaccine due-date and completion status.
    * The relation ChildWithVaccines does not yield this information and gets vaccines
    * associated with child using the cross-ref only for navigation. Our strategy, therefore,
    * is to directly query the cross-ref table to get a child's vaccination schedule.
    * */
    @Transaction
    @Query("SELECT * FROM Child WHERE childName = :childName")
    fun getVaccinesOfChild(childName: String): Flow<List<ChildWithVaccines>>

    @Transaction
    @Query("SELECT * FROM Vaccine WHERE vaccineName = :vaccineName")
    fun getChildsOfVaccine(vaccineName: String): Flow<List<VaccineWithChilds>>

    @Query("SELECT * FROM Child")  // Get list of children
    fun getChilds(): Flow<List<Child>>

    @Query("SELECT * FROM Vaccine")  // Get list of vaccines
    fun getVaccines(): Flow<List<Vaccine>>

    /*
    * Get a child's vaccination record with schedule and completion status.
    * Use this method of querying the cross-ref directly instead of using
    * relation ChildWithVaccines or relation VaccineWithChilds. This direct approach
    * puts the onus of referential integrity on the app's codebase as, for example,
    * it is possible to delete a child from table Child leaving orphaned records
    * pertaining to that child's vaccination schedule in table ChildVaccineCrossRef.
    * TODO("Explore options like ON CASCADE DELETE for ACID properties.")
    * */
    @Query("SELECT * FROM ChildVaccineCrossRef WHERE childName = :childName")
    fun getChildVaccineCrossRefs(childName: String): Flow<List<ChildVaccineCrossRef>>

    @Query("SELECT * FROM ChildVaccineCrossRef WHERE childName = :childName AND vaccineName = :vaccineName")
    fun getChildVaccineCrossRef(childName: String, vaccineName: String): ChildVaccineCrossRef

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