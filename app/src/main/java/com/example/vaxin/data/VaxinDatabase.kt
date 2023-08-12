package com.example.vaxin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vaxin.data.relations.ChildVaccineCrossRef

@Database(
    entities = [
        Child::class,
        Vaccine::class,
        ChildVaccineCrossRef::class],
    version = 1
)
abstract class VaxinDatabase : RoomDatabase() {
    abstract fun vaxinDao(): VaxinDao
}
