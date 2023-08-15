package com.example.vaxin.data

import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.data.relations.ChildWithVaccines
import com.example.vaxin.data.relations.VaccineWithChilds
import kotlinx.coroutines.flow.Flow

class VaxinRepositoryImpl(
    private val vaxinDao: VaxinDao
): VaxinRepository {
    override suspend fun insertChild(child: Child) {
        vaxinDao.insertChild(child)
    }

    override suspend fun insertVaccine(vaccine: Vaccine) {
        vaxinDao.insertVaccine(vaccine)
    }

    override suspend fun insertChildVaccineCrossRef(childVaccineCrossRef: ChildVaccineCrossRef) {
        vaxinDao.insertChildVaccineCrossRef(childVaccineCrossRef)
    }

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
}