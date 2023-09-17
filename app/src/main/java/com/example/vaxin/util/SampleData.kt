package com.example.vaxin.util

import com.example.vaxin.data.Child
import com.example.vaxin.data.Vaccine
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

object SampleData {
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    var today: String = LocalDateTime.now().format(formatter)
    var todayPlus060: String = LocalDateTime.now().plusDays(60).format(formatter)
    var todayPlus120: String = LocalDateTime.now().plusDays(120).format(formatter)
    var todayPlus180: String = LocalDateTime.now().plusDays(180).format(formatter)
    var todayPlus365: String = LocalDateTime.now().plusDays(365).format(formatter)
    var todayPlus455: String = LocalDateTime.now().plusDays(455).format(formatter)
    var todayPlus545: String = LocalDateTime.now().plusDays(545).format(formatter)


    val childs = listOf<Child>(
        Child("Balakrishna", today)
    )

    val vaccines = listOf<Vaccine>(
        Vaccine("Hepatitis B Vaccine (HepB)",
            """
                <h1>Hepatitis B Vaccine (HepB)</h1>
    <p>The Hepatitis B vaccine, often referred to as HepB, is a vaccine that provides protection against the hepatitis B virus (HBV). Hepatitis B is a serious viral infection that affects the liver and can lead to chronic liver disease, cirrhosis, liver cancer, and other complications. The vaccine is an effective preventive measure to reduce the risk of HBV infection.</p>

    <h2>Key Points about the Hepatitis B Vaccine:</h2>
    <ul>
        <li><strong>Composition:</strong> The vaccine contains a small, harmless part of the hepatitis B virus, called the hepatitis B surface antigen (HBsAg). This part of the virus is used to stimulate the immune system without causing the disease itself.</li>
        <li><strong>Vaccination Schedule:</strong> The Hepatitis B vaccine is typically administered as a series of injections. The recommended schedule for most individuals is a three-dose series. The second dose is usually given about one month after the first, and the third dose is given six months after the first dose. In some cases, a two-dose series may be used, especially for adolescents and adults.</li>
        <li><strong>Target Population:</strong> The vaccine is recommended for a wide range of people, including infants, children, adolescents, and adults. It is often administered shortly after birth to newborns. High-risk groups, such as healthcare workers, people with multiple sexual partners, and individuals with certain medical conditions, are especially encouraged to receive the vaccine.</li>
        <li><strong>Effectiveness:</strong> The Hepatitis B vaccine is highly effective at preventing hepatitis B infection. After completing the recommended series, most people develop long-lasting immunity to the virus.</li>
        <li><strong>Combination Vaccines:</strong> In some cases, the Hepatitis B vaccine is combined with other vaccines, such as those for hepatitis A or other diseases, to simplify the vaccination process and reduce the number of injections.</li>
        <li><strong>Side Effects:</strong> The vaccine is generally safe, with mild side effects such as pain or redness at the injection site being the most common. Serious side effects are rare.</li>
        <li><strong>Importance of Vaccination:</strong> Hepatitis B is a vaccine-preventable disease, and vaccination is crucial for reducing the transmission of the virus and preventing its potentially severe consequences.</li>
        <li><strong>Global Impact:</strong> Hepatitis B is a global health concern. The World Health Organization (WHO) recommends universal vaccination against hepatitis B to reduce the prevalence of the disease worldwide.</li>
        <li><strong>Hepatitis B Immunity Testing:</strong> Some individuals, particularly those at higher risk of HBV exposure, may undergo blood tests to check their immunity to hepatitis B after vaccination. This can help determine if additional vaccine doses are needed.</li>
        <li><strong>Booster Shots:</strong> In most cases, booster doses of the Hepatitis B vaccine are not routinely recommended for healthy individuals who have completed the initial series. However, some immunocompromised individuals may require periodic booster shots to maintain immunity.</li>
    </ul>

    <p>It's important to consult with a healthcare provider to determine the appropriate vaccination schedule and whether you should receive the Hepatitis B vaccine based on your individual risk factors and health status. Vaccination is a key public health measure in the prevention of hepatitis B and its complications.</p>
            """.trimIndent(),
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
            isDone = false,
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
            vaccineName = "Hib (Haemophilus influenzae type b) 4th Dose",
            dueDate = todayPlus455,
            isDone = false
        )
    )

    val vaccineImages = mapOf(
        "Hepatitis B Vaccine (HepB)" to "https://phil.cdc.gov/PHIL_Images/10755/10755_lores.jpg",
        "RV1 (Rotavirus Vaccine)" to "https://www.cdc.gov/rotavirus/images/disease_rotavirus-3D-lg.jpg",
        "DTaP (Diphtheria, Tetanus, Pertussis)" to "https://www.cdc.gov/diphtheria/images/diphtheria-photo-phil-22877.jpg",
        "Hib (Haemophilus influenzae type b)" to "https://www.cdc.gov/hi-disease/images/PHIL_1946.jpg",
        "IPV (Inactivated Poliovirus Vaccine)" to "https://phil.cdc.gov//PHIL_Images/24871/24871_lores.jpg",
        "PCV13 (Pneumococcal Conjugate Vaccine)" to "https://www.cdc.gov/pneumococcal/images/s_pneumoniae.jpg",
        "RV1 (Rotavirus Vaccine) 2nd Dose" to "https://www.cdc.gov/rotavirus/images/disease_rotavirus2-lg.jpg",
        "DTaP (Diphtheria, Tetanus, Pertussis) 2nd Dose" to "https://www.cdc.gov/tetanus/images/bacteria-phil.jpg",
        "Hib (Haemophilus influenzae type b) 2nd Dose" to "https://www.cdc.gov/hi-disease/images/PHIL_1047.jpg",
        "IPV (Inactivated Poliovirus Vaccine) 2nd Dose" to "https://phil.cdc.gov//PHIL_Images/22906/22906_lores.jpg",
        "PCV13 (Pneumococcal Conjugate Vaccine) 2nd Dose" to "https://www.cdc.gov/pneumococcal/images/phil-2896.jpg",
        "RV1 (Rotavirus Vaccine) 3rd Dose" to "https://www.cdc.gov/rotavirus/images/disease_rotavirus_lg.jpg",
        "DTaP (Diphtheria, Tetanus, Pertussis) 3rd Dose" to "https://www.cdc.gov/pertussis/images/disease_pertussis.jpg",
        "Hib (Haemophilus influenzae type b) 3rd Dose" to "https://www.cdc.gov/hi-disease/images/PHIL_1947.jpg",
        "IPV (Inactivated Poliovirus Vaccine) 3rd Dose" to "https://phil.cdc.gov//PHIL_Images/22891/22891_lores.jpg",
        "PCV13 (Pneumococcal Conjugate Vaccine) 3rd Dose" to "https://www.cdc.gov/pneumococcal/images/phil-3149.jpg",
        "Hepatitis B Vaccine (HepB) Supplemental" to "https://phil.cdc.gov/PHIL_Images/20040409/db3ccc84adda4f9891b01ea70ad052f9/5631_lores.jpg",
        "MMR (Measles, Mumps, Rubella)" to "https://phil.cdc.gov/PHIL_Images/10755/10755_lores.jpg",
        "Varicella (Chickenpox) Vaccine" to "https://www.cdc.gov/chickenpox/images/disease_varicella-lg.jpg",
        "Hepatitis A Vaccine" to "https://phil.cdc.gov/PHIL_Images/8153/8153_lores.jpg",
        "DTaP (Diphtheria, Tetanus, Pertussis) 4th Dose" to "https://www.cdc.gov/diphtheria/images/diphtheria-photo-phil-7323.jpg",
        "Hib (Haemophilus influenzae type b) 4th Dose" to "https://www.cdc.gov/hi-disease/images/PHIL_1616.jpg",
    )

    /*
    * To add a child, we must take care of populating cross-ref table
    * that holds the many-many relationship. Here is the function to do that.
    * */
    fun generateChildVaccineCrossRefs(child: Child): ArrayList<ChildVaccineCrossRef> {
        var childVaccineCrossRefs = ArrayList<ChildVaccineCrossRef>(emptyList())
        SampleData.vaccines.forEach { vaccine ->
            val dob = LocalDate.parse(child.dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            val dueDate = dob.plusDays(vaccine.daysAfterBirth.toLong())
            childVaccineCrossRefs.add(
                ChildVaccineCrossRef(
                    childName = child.childName,
                    vaccineName = vaccine.vaccineName,
                    dueDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dueDate),
                    isDone = false
                )
            )
        }
        return childVaccineCrossRefs
    }
}