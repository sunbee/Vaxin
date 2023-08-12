package com.example.vaxin.ui.add_child

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaxin.data.Child
import com.example.vaxin.data.Vaccine
import com.example.vaxin.data.VaxinRepository
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AddChildViewModel @Inject constructor(
    private val vaxinRepository: VaxinRepository
): ViewModel() {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    var today = LocalDateTime.now().format(formatter)
    var todayPlus060 = LocalDateTime.now().plusDays(60).format(formatter)
    var todayPlus120 = LocalDateTime.now().plusDays(120).format(formatter)
    var todayPlus180 = LocalDateTime.now().plusDays(180).format(formatter)
    var todayPlus365 = LocalDateTime.now().plusDays(365).format(formatter)
    var todayPlus455 = LocalDateTime.now().plusDays(455).format(formatter)
    var todayPlus545 = LocalDateTime.now().plusDays(545).format(formatter)


    val childs = listOf<Child>(
        Child("Balakrishna", today)
    )

    val vaccines = listOf<Vaccine>(
        Vaccine("Hepatitis B Vaccine (HepB)",
            "Helps prevent hepatitis B virus infection. Administered shortly after birth.",
            0),
        Vaccine("RV1 (Rotavirus Vaccine)",
            "Protects against rotavirus, a common cause of severe diarrhea and dehydration in infants.",
            60),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis)",
            "Guards against diphtheria, tetanus, and pertussis (whooping cough).",
            60),
        Vaccine("Hib (Haemophilus influenzae type b)",
            "Prevents Haemophilus influenzae type b infections, such as meningitis and pneumonia.",
            60),
        Vaccine("IPV (Inactivated Poliovirus Vaccine)",
            "Provides immunity against polio.",
            60),
        Vaccine("PCV13 (Pneumococcal Conjugate Vaccine)",
            "Protects against pneumococcal infections, including pneumonia and meningitis.",
            60),
        Vaccine("RV1 (Rotavirus Vaccine) 2nd Dose",
            "Second dose to strengthen immunity against rotavirus.",
            120),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis) 2nd Dose",
            "Second dose to reinforce immunity against diphtheria, tetanus, and pertussis.",
            120),
        Vaccine("Hib (Haemophilus influenzae type b) 2nd Dose",
            "Second dose for continued protection against Hib infections.",
            120),
        Vaccine("IPV (Inactivated Poliovirus Vaccine) 2nd Dose",
            "Second dose to further immunize against polio.",
            120),
        Vaccine("PCV13 (Pneumococcal Conjugate Vaccine) 2nd Dose",
            "Second dose to enhance immunity against pneumococcal infections.",
            120),
        Vaccine("RV1 (Rotavirus Vaccine) 3rd Dose",
            "Third dose to complete the rotavirus vaccine series.",
            180),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis) 3rd Dose",
            "Third dose to complete the primary DTaP series.",
            180),
        Vaccine("Hib (Haemophilus influenzae type b) 3rd Dose",
            "Third dose to complete the primary Hib series.",
            180),
        Vaccine("IPV (Inactivated Poliovirus Vaccine) 3rd Dose",
            "Third dose and boosters to maintain immunity against polio.",
            180),
        Vaccine("PCV13 (Pneumococcal Conjugate Vaccine) 3rd Dose",
            "Third dose to complete the primary PCV13 series.",
            180),
        Vaccine("Hepatitis B Vaccine (HepB) Supplemental",
            "Additional doses to complete the hepatitis B vaccine series if not already done.",
            180),
        Vaccine("MMR (Measles, Mumps, Rubella)",
            "Guards against measles, mumps, and rubella infections.",
            365),
        Vaccine("Varicella (Chickenpox) Vaccine",
            "Provides immunity against chickenpox.",
            365),
        Vaccine("Hepatitis A Vaccine",
            "Protects against hepatitis A virus.",
            365),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis) 4th Dose",
            "Fourth dose to reinforce immunity against diphtheria, tetanus, and pertussis.",
            545),
        Vaccine("Hib (Haemophilus influenzae type b) 4th Dose",
            "Fourth dose for continued protection against Hib infections.",
            455)
    )

    val childVaccineRelations = listOf<ChildVaccineCrossRef>(
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hepatitis B Vaccine (HepB)",
            dueDate = today,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "RV1 (Rotavirus Vaccine)",
            dueDate = todayPlus060,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "DTaP (Diphtheria, Tetanus, Pertussis)",
            dueDate = todayPlus060,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hib (Haemophilus influenzae type b)",
            dueDate = todayPlus060,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "IPV (Inactivated Poliovirus Vaccine)",
            dueDate = todayPlus060,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "PCV13 (Pneumococcal Conjugate Vaccine)",
            dueDate = todayPlus060,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "RV1 (Rotavirus Vaccine) 2nd Dose",
            dueDate = todayPlus120,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "DTaP (Diphtheria, Tetanus, Pertussis) 2nd Dose",
            dueDate = todayPlus120,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hib (Haemophilus influenzae type b) 2nd Dose",
            dueDate = todayPlus120,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "IPV (Inactivated Poliovirus Vaccine) 2nd Dose",
            dueDate = todayPlus120,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "PCV13 (Pneumococcal Conjugate Vaccine) 2nd Dose",
            dueDate = todayPlus120,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "RV1 (Rotavirus Vaccine) 3rd Dose",
            dueDate = todayPlus180,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "DTaP (Diphtheria, Tetanus, Pertussis) 3rd Dose",
            dueDate = todayPlus180,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hib (Haemophilus influenzae type b) 3rd Dose",
            dueDate = todayPlus180,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "IPV (Inactivated Poliovirus Vaccine) 3rd Dose",
            dueDate = todayPlus180,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "PCV13 (Pneumococcal Conjugate Vaccine) 3rd Dose",
            dueDate = todayPlus180,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hepatitis B Vaccine (HepB) Supplemental",
            dueDate = todayPlus180,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "MMR (Measles, Mumps, Rubella)",
            dueDate = todayPlus365,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Varicella (Chickenpox) Vaccine",
            dueDate = todayPlus365,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hepatitis A Vaccine",
            dueDate = todayPlus365,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "DTaP (Diphtheria, Tetanus, Pertussis) 4th Dose",
            dueDate = todayPlus545,
            isDone = false
        ),
        ChildVaccineCrossRef(
            childName = "Balakrishna",
            vaccineName = "Hib (Haemophilus influenzae type b)",
            dueDate = todayPlus455,
            isDone = false
        )
    )

    fun populateDBDefaults() {
        viewModelScope.launch(Dispatchers.IO) {
            childs.forEach { child ->
                vaxinRepository.insertChild(child) }
            vaccines.forEach { vaccine ->
                vaxinRepository.insertVaccine(vaccine)
            }
            childVaccineRelations.forEach { childVaccineCrossRef ->
                vaxinRepository.insertChildVaccineCrossRef(childVaccineCrossRef)
            }
        }
    }

    init {
        populateDBDefaults()
    }
}