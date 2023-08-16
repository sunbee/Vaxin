package com.example.vaxin.data

import androidx.room.Delete
import androidx.room.Query
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.data.relations.ChildWithVaccines
import com.example.vaxin.data.relations.VaccineWithChilds
import kotlinx.coroutines.flow.Flow

class VaxinRepositoryImpl(
    private val vaxinDao: VaxinDao
): VaxinRepository {
    /* (C)RUD - CREATE */
    override suspend fun insertChild(child: Child) {
        vaxinDao.insertChild(child)
    }

    override suspend fun insertVaccine(vaccine: Vaccine) {
        vaxinDao.insertVaccine(vaccine)
    }

    override suspend fun insertChildVaccineCrossRef(childVaccineCrossRef: ChildVaccineCrossRef) {
        vaxinDao.insertChildVaccineCrossRef(childVaccineCrossRef)
    }

    /* C(R)UD - RETRIEVE */
    override fun getVaccinesOfChild(childName: String): Flow<List<ChildWithVaccines>> {
        return vaxinDao.getVaccinesOfChild(childName)
    }

    override fun getChildsOfVaccine(vaccineName: String): Flow<List<VaccineWithChilds>> {
        return vaxinDao.getChildsOfVaccine(vaccineName)
    }

    override fun getChilds(): Flow<List<Child>> {
        return vaxinDao.getChilds()
    }

    override fun getVaccines(): Flow<List<Vaccine>> {
        return vaxinDao.getVaccines()
    }

    override fun getChildVaccineCrossRefs(childName: String): Flow<List<ChildVaccineCrossRef>> {
        return vaxinDao.getChildVaccineCrossRefs(childName)
    }

    /* CRU(D) - DELETE */
    override fun deleteChild(child: Child) {
        vaxinDao.deleteChild(child)
    }

    override fun deleteVaccinesOfChild(childName: String) {
        vaxinDao.deleteVaccinesOfChild(childName)
    }

    override fun deleteChilds() {
        vaxinDao.deleteChilds()
    }

    override fun deleteChildVaccinesCrossRefs() {
        vaxinDao.deleteChildVaccinesCrossRefs()
    }
}