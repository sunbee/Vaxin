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
        Child("Balakrishna", today, null)
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
            """
<h1>RV1 (Rotavirus Vaccine)</h1>
<p>The RV1, or Rotavirus Vaccine (brand name: Rotarix), is an important vaccine used to protect infants and young children from rotavirus infections.</p>

<h2>Disease Targeted</h2>
<p>Rotavirus is a highly contagious virus that primarily affects infants and young children. It is a leading cause of severe diarrhea and can lead to dehydration, hospitalization, and in some cases, even death. RV1 specifically targets rotavirus infections.</p>

<h2>Vaccine Type</h2>
<p>RV1 is an oral vaccine. It is administered in liquid form, typically as oral drops, rather than through injection.</p>

<h2>Vaccine Composition</h2>
<p>RV1 is a live attenuated vaccine, meaning it contains a weakened form of the rotavirus. The vaccine does not cause the disease but instead stimulates the immune system to develop protection against the virus.</p>

<h2>Vaccination Schedule</h2>
<p>RV1 is usually administered to infants in a series of doses. The recommended schedule can vary by country and healthcare guidelines, but it typically involves giving the vaccine in two or three doses, with the first dose often given at around 2 months of age. The subsequent doses are administered with an interval of several weeks.</p>

<h2>Effectiveness</h2>
<p>RV1 has been shown to be highly effective in preventing rotavirus infections, reducing the risk of severe diarrhea, hospitalization, and related complications. It provides protection against several strains of rotavirus.</p>

<h2>Importance of Vaccination</h2>
<p>Rotavirus infections are a significant global health concern, especially in regions with limited access to clean water and healthcare facilities. RV1 vaccination is essential for reducing the burden of rotavirus-related illnesses, which can be life-threatening in some cases.</p>

<h2>Safety</h2>
<p>RV1 is generally safe and well-tolerated. Like all vaccines, it can have mild side effects, such as temporary fussiness, mild diarrhea, or vomiting. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The RV1 vaccine is part of global vaccination efforts to reduce childhood mortality and morbidity due to rotavirus infections. It has been included in national immunization programs in many countries.</p>

<h2>Recommendations</h2>
<p>The administration of the RV1 vaccine is typically recommended by healthcare authorities and pediatricians as part of routine childhood vaccinations. The specific recommendations, schedule, and availability of the vaccine may vary from one country to another.</p>

<h2>Booster Doses</h2>
<p>In most cases, RV1 does not require booster doses. However, healthcare professionals and parents should follow the recommended vaccination schedule to ensure full protection.</p>

<p>It's essential to consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the RV1 vaccine at the appropriate age and schedule. Rotavirus vaccination plays a vital role in reducing the incidence of severe diarrheal diseases and their associated health risks in infants and young children.</p>
            """.trimIndent(),
            60),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis)",
            """
<h1>DTaP (Diphtheria, Tetanus, Pertussis) Vaccine</h1>
<p>The DTaP vaccine, which stands for Diphtheria, Tetanus, and Pertussis, is a vital immunization used to protect individuals, especially children, from three serious bacterial infections: diphtheria, tetanus, and pertussis.</p>

<h2>Diseases Targeted</h2>
<p>1. <strong>Diphtheria:</strong> Diphtheria is a bacterial infection that can lead to a thick coating in the back of the throat, making it difficult to breathe. It can also damage the heart, kidneys, and nerves.</p>
<p>2. <strong>Tetanus:</strong> Tetanus, often called "lockjaw," is caused by a toxin produced by a bacterium. It can cause severe muscle stiffness and spasms, and it can be life-threatening.</p>
<p>3. <strong>Pertussis (Whooping Cough):</strong> Pertussis is a highly contagious respiratory disease characterized by severe coughing fits. It can lead to serious complications, especially in infants and young children.</p>

<h2>Vaccine Type</h2>
<p>The DTaP vaccine is an inactivated (killed) vaccine, meaning it contains inactivated or non-live components of the bacteria that cause these diseases. It cannot cause the diseases it protects against.</p>

<h2>Vaccination Schedule</h2>
<p>DTaP is typically administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, 15-18 months, and 4-6 years of age. Booster doses may be recommended in later childhood and adolescence.</p>

<h2>Effectiveness</h2>
<p>The DTaP vaccine is highly effective in preventing diphtheria, tetanus, and pertussis. It stimulates the immune system to produce antibodies that protect against these diseases.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with DTaP is crucial for preventing potentially life-threatening diseases, especially in infants and young children who are most vulnerable to these infections. It also contributes to herd immunity, protecting those who cannot receive vaccines for medical reasons.</p>

<h2>Side Effects</h2>
<p>The DTaP vaccine is generally safe, with mild side effects such as redness or swelling at the injection site and low-grade fever. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>DTaP vaccination is part of routine childhood immunization programs in many countries and has contributed significantly to the reduction of diphtheria, tetanus, and pertussis cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of tetanus and diphtheria-containing vaccines are recommended for adolescents and adults to maintain immunity throughout life.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you and your family receive the DTaP vaccine according to the recommended schedule. Vaccination is a critical measure in preventing these serious bacterial infections.</p>
            """.trimIndent(),
            60),
        Vaccine("Hib (Haemophilus influenzae type b)",
            """
<h1>Hib (Haemophilus influenzae type b) Vaccine</h1>
<p>The Hib vaccine, or Haemophilus influenzae type b vaccine, is a crucial immunization used to protect infants and young children from Haemophilus influenzae type b (Hib) infections.</p>

<h2>Disease Targeted</h2>
<p>Haemophilus influenzae type b (Hib) is a bacterial infection that can lead to serious diseases, including:</p>
<ul>
    <li><strong>Meningitis:</strong> An infection of the lining of the brain and spinal cord.</li>
    <li><strong>Pneumonia:</strong> A lung infection that can cause breathing difficulties.</li>
    <li><strong>Epiglottitis:</strong> A severe throat infection that can block the airway.</li>
    <li><strong>Septicemia:</strong> A bloodstream infection.</li>
    <li><strong>Other Invasive Diseases:</strong> Hib can also cause infections in the joints, bones, and other parts of the body.</li>
</ul>

<h2>Vaccine Type</h2>
<p>The Hib vaccine is typically available in different formulations, including conjugate vaccines. It contains components of the Hib bacterium that stimulate the immune system to develop protection against Hib infections.</p>

<h2>Vaccination Schedule</h2>
<p>The Hib vaccine is administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. The exact schedule may vary by country and healthcare guidelines.</p>

<h2>Effectiveness</h2>
<p>The Hib vaccine is highly effective in preventing Hib infections and the serious diseases they can cause. It provides long-lasting immunity against Hib.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with Hib is crucial for preventing potentially life-threatening diseases, especially in infants and young children. It has significantly reduced the incidence of Hib-related illnesses since its introduction.</p>

<h2>Side Effects</h2>
<p>The Hib vaccine is generally safe, with mild side effects such as redness or swelling at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The Hib vaccine is widely used as part of childhood immunization programs in many countries and has led to a substantial decrease in Hib-related diseases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of Hib vaccine are typically not required if the primary series is completed during infancy. However, healthcare providers may recommend additional doses in certain situations, such as for individuals with weakened immune systems.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the Hib vaccine according to the recommended schedule. Hib vaccination is a vital step in protecting children from Hib-related diseases.</p>
            """.trimIndent(),
            60),
        Vaccine("IPV (Inactivated Poliovirus Vaccine)",
            """
<h1>IPV (Inactivated Poliovirus Vaccine)</h1>
<p>The IPV, or Inactivated Poliovirus Vaccine, is a critical immunization used to protect individuals from polio, a highly contagious and potentially paralytic viral disease.</p>

<h2>Disease Targeted</h2>
<p>Polio, short for poliomyelitis, is a viral infection caused by polioviruses. It can lead to paralysis, primarily affecting the legs, and in severe cases, it can be life-threatening. Polio was a widespread and devastating disease until vaccination efforts began.</p>

<h2>Vaccine Type</h2>
<p>IPV is an inactivated (killed) vaccine, meaning it contains inactivated or non-live polioviruses. It cannot cause the disease but stimulates the immune system to develop protection against all three types of poliovirus.</p>

<h2>Vaccination Schedule</h2>
<p>IPV is typically administered in a series of doses to ensure immunity. The recommended schedule includes doses at 2 months, 4 months, 6-18 months, and a booster dose at 4-6 years of age. Booster doses may be recommended in later childhood and adulthood, depending on the individual's vaccination history.</p>

<h2>Effectiveness</h2>
<p>IPV is highly effective in preventing polio. It provides robust immunity against all three types of poliovirus, helping to maintain polio-free communities.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with IPV is essential for preventing the transmission of poliovirus and the occurrence of polio cases. Global vaccination efforts have made significant progress in eradicating polio, and IPV plays a crucial role in achieving this goal.</p>

<h2>Side Effects</h2>
<p>The IPV vaccine is generally safe, with mild side effects such as pain or redness at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>IPV is a key tool in the global effort to eradicate polio. It is administered as part of routine immunization programs in many countries and has contributed to the reduction of polio cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of IPV may be recommended in adulthood, especially for individuals traveling to regions where polio is still endemic or for healthcare workers at risk of exposure.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you receive IPV according to the recommended schedule. IPV vaccination is a vital step in preventing polio and maintaining a polio-free world.</p>
            """.trimIndent(),
            60),
        Vaccine("PCV13 (Pneumococcal Conjugate Vaccine)",
            """"
<h1>PCV13 (Pneumococcal Conjugate Vaccine)</h1>
<p>The PCV13, or Pneumococcal Conjugate Vaccine 13, is an important vaccine used to protect individuals, especially infants, children, and older adults, from infections caused by the bacteria Streptococcus pneumoniae.</p>

<h2>Diseases Targeted</h2>
<p>PCV13 provides protection against a range of diseases caused by Streptococcus pneumoniae, including:</p>
<ul>
    <li><strong>Pneumonia:</strong> An infection of the lungs that can cause fever, cough, and difficulty breathing.</li>
    <li><strong>Meningitis:</strong> An infection of the protective membranes covering the brain and spinal cord.</li>
    <li><strong>Ear Infections:</strong> These can range from mild earaches to severe and recurrent ear infections.</li>
    <li><strong>Sinusitis:</strong> An infection or inflammation of the sinus cavities in the skull.</li>
</ul>

<h2>Vaccine Type</h2>
<p>PCV13 is a conjugate vaccine, which means it combines a part of the bacterial capsule of Streptococcus pneumoniae with a protein to stimulate the immune system. This vaccine helps the body recognize and fight the bacteria effectively.</p>

<h2>Vaccination Schedule</h2>
<p>PCV13 is administered in a series of doses, especially to infants and young children. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. Older adults may receive one or more doses depending on their age and health condition.</p>

<h2>Effectiveness</h2>
<p>PCV13 is highly effective in preventing pneumococcal diseases caused by the strains of Streptococcus pneumoniae included in the vaccine. It helps reduce the risk of serious infections and their complications.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with PCV13 is crucial for protecting individuals, especially those at higher risk, from pneumococcal infections that can lead to severe illnesses and hospitalization. It is particularly important for infants, older adults, and individuals with certain medical conditions.</p>

<h2>Side Effects</h2>
<p>The PCV13 vaccine is generally safe, with mild side effects such as pain or redness at the injection site being common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>PCV13 vaccination is a significant part of vaccination programs in many countries and has contributed to the reduction of pneumococcal disease cases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of PCV13 may be recommended for certain populations, including older adults and individuals with specific medical conditions. Consult with a healthcare provider to determine if booster doses are needed.</p>

<p>It's important to consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you or your child receives the PCV13 vaccine according to the recommended schedule. PCV13 vaccination is a key preventive measure against pneumococcal infections.</p>
            """.trimMargin(),
            60),
        Vaccine("RV1 (Rotavirus Vaccine) 2nd Dose",
            """
<h1>RV1 (Rotavirus Vaccine)</h1>
<p>The RV1, or Rotavirus Vaccine (brand name: Rotarix), is an important vaccine used to protect infants and young children from rotavirus infections.</p>

<h2>Disease Targeted</h2>
<p>Rotavirus is a highly contagious virus that primarily affects infants and young children. It is a leading cause of severe diarrhea and can lead to dehydration, hospitalization, and in some cases, even death. RV1 specifically targets rotavirus infections.</p>

<h2>Vaccine Type</h2>
<p>RV1 is an oral vaccine. It is administered in liquid form, typically as oral drops, rather than through injection.</p>

<h2>Vaccine Composition</h2>
<p>RV1 is a live attenuated vaccine, meaning it contains a weakened form of the rotavirus. The vaccine does not cause the disease but instead stimulates the immune system to develop protection against the virus.</p>

<h2>Vaccination Schedule</h2>
<p>RV1 is usually administered to infants in a series of doses. The recommended schedule can vary by country and healthcare guidelines, but it typically involves giving the vaccine in two or three doses, with the first dose often given at around 2 months of age. The subsequent doses are administered with an interval of several weeks.</p>

<h2>Effectiveness</h2>
<p>RV1 has been shown to be highly effective in preventing rotavirus infections, reducing the risk of severe diarrhea, hospitalization, and related complications. It provides protection against several strains of rotavirus.</p>

<h2>Importance of Vaccination</h2>
<p>Rotavirus infections are a significant global health concern, especially in regions with limited access to clean water and healthcare facilities. RV1 vaccination is essential for reducing the burden of rotavirus-related illnesses, which can be life-threatening in some cases.</p>

<h2>Safety</h2>
<p>RV1 is generally safe and well-tolerated. Like all vaccines, it can have mild side effects, such as temporary fussiness, mild diarrhea, or vomiting. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The RV1 vaccine is part of global vaccination efforts to reduce childhood mortality and morbidity due to rotavirus infections. It has been included in national immunization programs in many countries.</p>

<h2>Recommendations</h2>
<p>The administration of the RV1 vaccine is typically recommended by healthcare authorities and pediatricians as part of routine childhood vaccinations. The specific recommendations, schedule, and availability of the vaccine may vary from one country to another.</p>

<h2>Booster Doses</h2>
<p>In most cases, RV1 does not require booster doses. However, healthcare professionals and parents should follow the recommended vaccination schedule to ensure full protection.</p>

<p>It's essential to consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the RV1 vaccine at the appropriate age and schedule. Rotavirus vaccination plays a vital role in reducing the incidence of severe diarrheal diseases and their associated health risks in infants and young children.</p>
            """.trimIndent(),
            120),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis) 2nd Dose",
            """
<h1>DTaP (Diphtheria, Tetanus, Pertussis) Vaccine</h1>
<p>The DTaP vaccine, which stands for Diphtheria, Tetanus, and Pertussis, is a vital immunization used to protect individuals, especially children, from three serious bacterial infections: diphtheria, tetanus, and pertussis.</p>

<h2>Diseases Targeted</h2>
<p>1. <strong>Diphtheria:</strong> Diphtheria is a bacterial infection that can lead to a thick coating in the back of the throat, making it difficult to breathe. It can also damage the heart, kidneys, and nerves.</p>
<p>2. <strong>Tetanus:</strong> Tetanus, often called "lockjaw," is caused by a toxin produced by a bacterium. It can cause severe muscle stiffness and spasms, and it can be life-threatening.</p>
<p>3. <strong>Pertussis (Whooping Cough):</strong> Pertussis is a highly contagious respiratory disease characterized by severe coughing fits. It can lead to serious complications, especially in infants and young children.</p>

<h2>Vaccine Type</h2>
<p>The DTaP vaccine is an inactivated (killed) vaccine, meaning it contains inactivated or non-live components of the bacteria that cause these diseases. It cannot cause the diseases it protects against.</p>

<h2>Vaccination Schedule</h2>
<p>DTaP is typically administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, 15-18 months, and 4-6 years of age. Booster doses may be recommended in later childhood and adolescence.</p>

<h2>Effectiveness</h2>
<p>The DTaP vaccine is highly effective in preventing diphtheria, tetanus, and pertussis. It stimulates the immune system to produce antibodies that protect against these diseases.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with DTaP is crucial for preventing potentially life-threatening diseases, especially in infants and young children who are most vulnerable to these infections. It also contributes to herd immunity, protecting those who cannot receive vaccines for medical reasons.</p>

<h2>Side Effects</h2>
<p>The DTaP vaccine is generally safe, with mild side effects such as redness or swelling at the injection site and low-grade fever. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>DTaP vaccination is part of routine childhood immunization programs in many countries and has contributed significantly to the reduction of diphtheria, tetanus, and pertussis cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of tetanus and diphtheria-containing vaccines are recommended for adolescents and adults to maintain immunity throughout life.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you and your family receive the DTaP vaccine according to the recommended schedule. Vaccination is a critical measure in preventing these serious bacterial infections.</p>
            """.trimIndent(),
            120),
        Vaccine("Hib (Haemophilus influenzae type b) 2nd Dose",
            """
<h1>Hib (Haemophilus influenzae type b) Vaccine</h1>
<p>The Hib vaccine, or Haemophilus influenzae type b vaccine, is a crucial immunization used to protect infants and young children from Haemophilus influenzae type b (Hib) infections.</p>

<h2>Disease Targeted</h2>
<p>Haemophilus influenzae type b (Hib) is a bacterial infection that can lead to serious diseases, including:</p>
<ul>
    <li><strong>Meningitis:</strong> An infection of the lining of the brain and spinal cord.</li>
    <li><strong>Pneumonia:</strong> A lung infection that can cause breathing difficulties.</li>
    <li><strong>Epiglottitis:</strong> A severe throat infection that can block the airway.</li>
    <li><strong>Septicemia:</strong> A bloodstream infection.</li>
    <li><strong>Other Invasive Diseases:</strong> Hib can also cause infections in the joints, bones, and other parts of the body.</li>
</ul>

<h2>Vaccine Type</h2>
<p>The Hib vaccine is typically available in different formulations, including conjugate vaccines. It contains components of the Hib bacterium that stimulate the immune system to develop protection against Hib infections.</p>

<h2>Vaccination Schedule</h2>
<p>The Hib vaccine is administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. The exact schedule may vary by country and healthcare guidelines.</p>

<h2>Effectiveness</h2>
<p>The Hib vaccine is highly effective in preventing Hib infections and the serious diseases they can cause. It provides long-lasting immunity against Hib.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with Hib is crucial for preventing potentially life-threatening diseases, especially in infants and young children. It has significantly reduced the incidence of Hib-related illnesses since its introduction.</p>

<h2>Side Effects</h2>
<p>The Hib vaccine is generally safe, with mild side effects such as redness or swelling at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The Hib vaccine is widely used as part of childhood immunization programs in many countries and has led to a substantial decrease in Hib-related diseases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of Hib vaccine are typically not required if the primary series is completed during infancy. However, healthcare providers may recommend additional doses in certain situations, such as for individuals with weakened immune systems.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the Hib vaccine according to the recommended schedule. Hib vaccination is a vital step in protecting children from Hib-related diseases.</p>
            """.trimIndent(),
            120),
        Vaccine("IPV (Inactivated Poliovirus Vaccine) 2nd Dose",
            """
<h1>IPV (Inactivated Poliovirus Vaccine)</h1>
<p>The IPV, or Inactivated Poliovirus Vaccine, is a critical immunization used to protect individuals from polio, a highly contagious and potentially paralytic viral disease.</p>

<h2>Disease Targeted</h2>
<p>Polio, short for poliomyelitis, is a viral infection caused by polioviruses. It can lead to paralysis, primarily affecting the legs, and in severe cases, it can be life-threatening. Polio was a widespread and devastating disease until vaccination efforts began.</p>

<h2>Vaccine Type</h2>
<p>IPV is an inactivated (killed) vaccine, meaning it contains inactivated or non-live polioviruses. It cannot cause the disease but stimulates the immune system to develop protection against all three types of poliovirus.</p>

<h2>Vaccination Schedule</h2>
<p>IPV is typically administered in a series of doses to ensure immunity. The recommended schedule includes doses at 2 months, 4 months, 6-18 months, and a booster dose at 4-6 years of age. Booster doses may be recommended in later childhood and adulthood, depending on the individual's vaccination history.</p>

<h2>Effectiveness</h2>
<p>IPV is highly effective in preventing polio. It provides robust immunity against all three types of poliovirus, helping to maintain polio-free communities.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with IPV is essential for preventing the transmission of poliovirus and the occurrence of polio cases. Global vaccination efforts have made significant progress in eradicating polio, and IPV plays a crucial role in achieving this goal.</p>

<h2>Side Effects</h2>
<p>The IPV vaccine is generally safe, with mild side effects such as pain or redness at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>IPV is a key tool in the global effort to eradicate polio. It is administered as part of routine immunization programs in many countries and has contributed to the reduction of polio cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of IPV may be recommended in adulthood, especially for individuals traveling to regions where polio is still endemic or for healthcare workers at risk of exposure.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you receive IPV according to the recommended schedule. IPV vaccination is a vital step in preventing polio and maintaining a polio-free world.</p>
            """.trimIndent(),
            120),
        Vaccine("PCV13 (Pneumococcal Conjugate Vaccine) 2nd Dose",
            """"
<h1>PCV13 (Pneumococcal Conjugate Vaccine)</h1>
<p>The PCV13, or Pneumococcal Conjugate Vaccine 13, is an important vaccine used to protect individuals, especially infants, children, and older adults, from infections caused by the bacteria Streptococcus pneumoniae.</p>

<h2>Diseases Targeted</h2>
<p>PCV13 provides protection against a range of diseases caused by Streptococcus pneumoniae, including:</p>
<ul>
    <li><strong>Pneumonia:</strong> An infection of the lungs that can cause fever, cough, and difficulty breathing.</li>
    <li><strong>Meningitis:</strong> An infection of the protective membranes covering the brain and spinal cord.</li>
    <li><strong>Ear Infections:</strong> These can range from mild earaches to severe and recurrent ear infections.</li>
    <li><strong>Sinusitis:</strong> An infection or inflammation of the sinus cavities in the skull.</li>
</ul>

<h2>Vaccine Type</h2>
<p>PCV13 is a conjugate vaccine, which means it combines a part of the bacterial capsule of Streptococcus pneumoniae with a protein to stimulate the immune system. This vaccine helps the body recognize and fight the bacteria effectively.</p>

<h2>Vaccination Schedule</h2>
<p>PCV13 is administered in a series of doses, especially to infants and young children. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. Older adults may receive one or more doses depending on their age and health condition.</p>

<h2>Effectiveness</h2>
<p>PCV13 is highly effective in preventing pneumococcal diseases caused by the strains of Streptococcus pneumoniae included in the vaccine. It helps reduce the risk of serious infections and their complications.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with PCV13 is crucial for protecting individuals, especially those at higher risk, from pneumococcal infections that can lead to severe illnesses and hospitalization. It is particularly important for infants, older adults, and individuals with certain medical conditions.</p>

<h2>Side Effects</h2>
<p>The PCV13 vaccine is generally safe, with mild side effects such as pain or redness at the injection site being common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>PCV13 vaccination is a significant part of vaccination programs in many countries and has contributed to the reduction of pneumococcal disease cases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of PCV13 may be recommended for certain populations, including older adults and individuals with specific medical conditions. Consult with a healthcare provider to determine if booster doses are needed.</p>

<p>It's important to consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you or your child receives the PCV13 vaccine according to the recommended schedule. PCV13 vaccination is a key preventive measure against pneumococcal infections.</p>
            """.trimMargin(),
            120),
        Vaccine("RV1 (Rotavirus Vaccine) 3rd Dose",
            """
<h1>RV1 (Rotavirus Vaccine)</h1>
<p>The RV1, or Rotavirus Vaccine (brand name: Rotarix), is an important vaccine used to protect infants and young children from rotavirus infections.</p>

<h2>Disease Targeted</h2>
<p>Rotavirus is a highly contagious virus that primarily affects infants and young children. It is a leading cause of severe diarrhea and can lead to dehydration, hospitalization, and in some cases, even death. RV1 specifically targets rotavirus infections.</p>

<h2>Vaccine Type</h2>
<p>RV1 is an oral vaccine. It is administered in liquid form, typically as oral drops, rather than through injection.</p>

<h2>Vaccine Composition</h2>
<p>RV1 is a live attenuated vaccine, meaning it contains a weakened form of the rotavirus. The vaccine does not cause the disease but instead stimulates the immune system to develop protection against the virus.</p>

<h2>Vaccination Schedule</h2>
<p>RV1 is usually administered to infants in a series of doses. The recommended schedule can vary by country and healthcare guidelines, but it typically involves giving the vaccine in two or three doses, with the first dose often given at around 2 months of age. The subsequent doses are administered with an interval of several weeks.</p>

<h2>Effectiveness</h2>
<p>RV1 has been shown to be highly effective in preventing rotavirus infections, reducing the risk of severe diarrhea, hospitalization, and related complications. It provides protection against several strains of rotavirus.</p>

<h2>Importance of Vaccination</h2>
<p>Rotavirus infections are a significant global health concern, especially in regions with limited access to clean water and healthcare facilities. RV1 vaccination is essential for reducing the burden of rotavirus-related illnesses, which can be life-threatening in some cases.</p>

<h2>Safety</h2>
<p>RV1 is generally safe and well-tolerated. Like all vaccines, it can have mild side effects, such as temporary fussiness, mild diarrhea, or vomiting. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The RV1 vaccine is part of global vaccination efforts to reduce childhood mortality and morbidity due to rotavirus infections. It has been included in national immunization programs in many countries.</p>

<h2>Recommendations</h2>
<p>The administration of the RV1 vaccine is typically recommended by healthcare authorities and pediatricians as part of routine childhood vaccinations. The specific recommendations, schedule, and availability of the vaccine may vary from one country to another.</p>

<h2>Booster Doses</h2>
<p>In most cases, RV1 does not require booster doses. However, healthcare professionals and parents should follow the recommended vaccination schedule to ensure full protection.</p>

<p>It's essential to consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the RV1 vaccine at the appropriate age and schedule. Rotavirus vaccination plays a vital role in reducing the incidence of severe diarrheal diseases and their associated health risks in infants and young children.</p>
            """.trimIndent(),
            180),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis) 3rd Dose",
            """
<h1>DTaP (Diphtheria, Tetanus, Pertussis) Vaccine</h1>
<p>The DTaP vaccine, which stands for Diphtheria, Tetanus, and Pertussis, is a vital immunization used to protect individuals, especially children, from three serious bacterial infections: diphtheria, tetanus, and pertussis.</p>

<h2>Diseases Targeted</h2>
<p>1. <strong>Diphtheria:</strong> Diphtheria is a bacterial infection that can lead to a thick coating in the back of the throat, making it difficult to breathe. It can also damage the heart, kidneys, and nerves.</p>
<p>2. <strong>Tetanus:</strong> Tetanus, often called "lockjaw," is caused by a toxin produced by a bacterium. It can cause severe muscle stiffness and spasms, and it can be life-threatening.</p>
<p>3. <strong>Pertussis (Whooping Cough):</strong> Pertussis is a highly contagious respiratory disease characterized by severe coughing fits. It can lead to serious complications, especially in infants and young children.</p>

<h2>Vaccine Type</h2>
<p>The DTaP vaccine is an inactivated (killed) vaccine, meaning it contains inactivated or non-live components of the bacteria that cause these diseases. It cannot cause the diseases it protects against.</p>

<h2>Vaccination Schedule</h2>
<p>DTaP is typically administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, 15-18 months, and 4-6 years of age. Booster doses may be recommended in later childhood and adolescence.</p>

<h2>Effectiveness</h2>
<p>The DTaP vaccine is highly effective in preventing diphtheria, tetanus, and pertussis. It stimulates the immune system to produce antibodies that protect against these diseases.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with DTaP is crucial for preventing potentially life-threatening diseases, especially in infants and young children who are most vulnerable to these infections. It also contributes to herd immunity, protecting those who cannot receive vaccines for medical reasons.</p>

<h2>Side Effects</h2>
<p>The DTaP vaccine is generally safe, with mild side effects such as redness or swelling at the injection site and low-grade fever. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>DTaP vaccination is part of routine childhood immunization programs in many countries and has contributed significantly to the reduction of diphtheria, tetanus, and pertussis cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of tetanus and diphtheria-containing vaccines are recommended for adolescents and adults to maintain immunity throughout life.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you and your family receive the DTaP vaccine according to the recommended schedule. Vaccination is a critical measure in preventing these serious bacterial infections.</p>
            """.trimIndent(),
            180),
        Vaccine("Hib (Haemophilus influenzae type b) 3rd Dose",
            """
<h1>Hib (Haemophilus influenzae type b) Vaccine</h1>
<p>The Hib vaccine, or Haemophilus influenzae type b vaccine, is a crucial immunization used to protect infants and young children from Haemophilus influenzae type b (Hib) infections.</p>

<h2>Disease Targeted</h2>
<p>Haemophilus influenzae type b (Hib) is a bacterial infection that can lead to serious diseases, including:</p>
<ul>
    <li><strong>Meningitis:</strong> An infection of the lining of the brain and spinal cord.</li>
    <li><strong>Pneumonia:</strong> A lung infection that can cause breathing difficulties.</li>
    <li><strong>Epiglottitis:</strong> A severe throat infection that can block the airway.</li>
    <li><strong>Septicemia:</strong> A bloodstream infection.</li>
    <li><strong>Other Invasive Diseases:</strong> Hib can also cause infections in the joints, bones, and other parts of the body.</li>
</ul>

<h2>Vaccine Type</h2>
<p>The Hib vaccine is typically available in different formulations, including conjugate vaccines. It contains components of the Hib bacterium that stimulate the immune system to develop protection against Hib infections.</p>

<h2>Vaccination Schedule</h2>
<p>The Hib vaccine is administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. The exact schedule may vary by country and healthcare guidelines.</p>

<h2>Effectiveness</h2>
<p>The Hib vaccine is highly effective in preventing Hib infections and the serious diseases they can cause. It provides long-lasting immunity against Hib.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with Hib is crucial for preventing potentially life-threatening diseases, especially in infants and young children. It has significantly reduced the incidence of Hib-related illnesses since its introduction.</p>

<h2>Side Effects</h2>
<p>The Hib vaccine is generally safe, with mild side effects such as redness or swelling at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The Hib vaccine is widely used as part of childhood immunization programs in many countries and has led to a substantial decrease in Hib-related diseases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of Hib vaccine are typically not required if the primary series is completed during infancy. However, healthcare providers may recommend additional doses in certain situations, such as for individuals with weakened immune systems.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the Hib vaccine according to the recommended schedule. Hib vaccination is a vital step in protecting children from Hib-related diseases.</p>
            """.trimIndent(),
            180),
        Vaccine("IPV (Inactivated Poliovirus Vaccine) 3rd Dose",
            """
<h1>IPV (Inactivated Poliovirus Vaccine)</h1>
<p>The IPV, or Inactivated Poliovirus Vaccine, is a critical immunization used to protect individuals from polio, a highly contagious and potentially paralytic viral disease.</p>

<h2>Disease Targeted</h2>
<p>Polio, short for poliomyelitis, is a viral infection caused by polioviruses. It can lead to paralysis, primarily affecting the legs, and in severe cases, it can be life-threatening. Polio was a widespread and devastating disease until vaccination efforts began.</p>

<h2>Vaccine Type</h2>
<p>IPV is an inactivated (killed) vaccine, meaning it contains inactivated or non-live polioviruses. It cannot cause the disease but stimulates the immune system to develop protection against all three types of poliovirus.</p>

<h2>Vaccination Schedule</h2>
<p>IPV is typically administered in a series of doses to ensure immunity. The recommended schedule includes doses at 2 months, 4 months, 6-18 months, and a booster dose at 4-6 years of age. Booster doses may be recommended in later childhood and adulthood, depending on the individual's vaccination history.</p>

<h2>Effectiveness</h2>
<p>IPV is highly effective in preventing polio. It provides robust immunity against all three types of poliovirus, helping to maintain polio-free communities.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with IPV is essential for preventing the transmission of poliovirus and the occurrence of polio cases. Global vaccination efforts have made significant progress in eradicating polio, and IPV plays a crucial role in achieving this goal.</p>

<h2>Side Effects</h2>
<p>The IPV vaccine is generally safe, with mild side effects such as pain or redness at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>IPV is a key tool in the global effort to eradicate polio. It is administered as part of routine immunization programs in many countries and has contributed to the reduction of polio cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of IPV may be recommended in adulthood, especially for individuals traveling to regions where polio is still endemic or for healthcare workers at risk of exposure.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you receive IPV according to the recommended schedule. IPV vaccination is a vital step in preventing polio and maintaining a polio-free world.</p>
            """.trimIndent(),
            180),
        Vaccine("PCV13 (Pneumococcal Conjugate Vaccine) 3rd Dose",
            """"
<h1>PCV13 (Pneumococcal Conjugate Vaccine)</h1>
<p>The PCV13, or Pneumococcal Conjugate Vaccine 13, is an important vaccine used to protect individuals, especially infants, children, and older adults, from infections caused by the bacteria Streptococcus pneumoniae.</p>

<h2>Diseases Targeted</h2>
<p>PCV13 provides protection against a range of diseases caused by Streptococcus pneumoniae, including:</p>
<ul>
    <li><strong>Pneumonia:</strong> An infection of the lungs that can cause fever, cough, and difficulty breathing.</li>
    <li><strong>Meningitis:</strong> An infection of the protective membranes covering the brain and spinal cord.</li>
    <li><strong>Ear Infections:</strong> These can range from mild earaches to severe and recurrent ear infections.</li>
    <li><strong>Sinusitis:</strong> An infection or inflammation of the sinus cavities in the skull.</li>
</ul>

<h2>Vaccine Type</h2>
<p>PCV13 is a conjugate vaccine, which means it combines a part of the bacterial capsule of Streptococcus pneumoniae with a protein to stimulate the immune system. This vaccine helps the body recognize and fight the bacteria effectively.</p>

<h2>Vaccination Schedule</h2>
<p>PCV13 is administered in a series of doses, especially to infants and young children. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. Older adults may receive one or more doses depending on their age and health condition.</p>

<h2>Effectiveness</h2>
<p>PCV13 is highly effective in preventing pneumococcal diseases caused by the strains of Streptococcus pneumoniae included in the vaccine. It helps reduce the risk of serious infections and their complications.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with PCV13 is crucial for protecting individuals, especially those at higher risk, from pneumococcal infections that can lead to severe illnesses and hospitalization. It is particularly important for infants, older adults, and individuals with certain medical conditions.</p>

<h2>Side Effects</h2>
<p>The PCV13 vaccine is generally safe, with mild side effects such as pain or redness at the injection site being common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>PCV13 vaccination is a significant part of vaccination programs in many countries and has contributed to the reduction of pneumococcal disease cases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of PCV13 may be recommended for certain populations, including older adults and individuals with specific medical conditions. Consult with a healthcare provider to determine if booster doses are needed.</p>

<p>It's important to consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you or your child receives the PCV13 vaccine according to the recommended schedule. PCV13 vaccination is a key preventive measure against pneumococcal infections.</p>
            """.trimMargin(),
            180),
        Vaccine("Hepatitis B Vaccine (HepB) Supplemental",
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
            180),
        Vaccine("MMR (Measles, Mumps, Rubella)",
            """
<h1>MMR (Measles, Mumps, Rubella) Vaccine</h1>
<p>The MMR vaccine is a combined vaccine that provides protection against three contagious viral infections: measles, mumps, and rubella (also known as German measles).</p>

<h2>Diseases Targeted</h2>
<p>The MMR vaccine targets three diseases:</p>
<ul>
    <li><strong>Measles:</strong> A highly contagious viral infection that can cause fever, rash, cough, and other symptoms. Measles can lead to serious complications, including pneumonia and encephalitis.</li>
    <li><strong>Mumps:</strong> A viral infection that can cause swelling of the salivary glands, fever, and other symptoms. Mumps can lead to complications such as orchitis (swelling of the testicles), pancreatitis, and deafness.</li>
    <li><strong>Rubella (German Measles):</strong> A viral infection that causes a mild rash and fever. Rubella can be particularly dangerous for pregnant women, as it can lead to congenital rubella syndrome in their babies, causing birth defects.</li>
</ul>

<h2>Vaccine Type</h2>
<p>The MMR vaccine is a live attenuated vaccine, meaning it contains weakened forms of the viruses that cannot cause the diseases but stimulate the immune system to develop immunity.</p>

<h2>Vaccination Schedule</h2>
<p>The MMR vaccine is typically administered in two doses. The first dose is given at around 1 year of age, and the second dose is usually given between 4 and 6 years of age. The timing may vary by country and healthcare guidelines.</p>

<h2>Effectiveness</h2>
<p>The MMR vaccine is highly effective in preventing measles, mumps, and rubella. It provides long-lasting immunity against these diseases.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with MMR is essential for preventing the spread of these highly contagious diseases and their potential complications, including severe illness and birth defects.</p>

<h2>Side Effects</h2>
<p>The MMR vaccine is generally safe, with mild side effects such as fever or rash being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The MMR vaccine is a crucial component of vaccination programs worldwide and has significantly reduced the incidence of measles, mumps, and rubella.</p>

<h2>Booster Doses</h2>
<p>Booster doses of the MMR vaccine are usually not required if the two-dose primary series is completed. However, in some situations, especially for healthcare workers and travelers, additional doses may be recommended.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you and your family receive the MMR vaccine according to the recommended schedule. MMR vaccination is a fundamental step in preventing these contagious diseases.</p>
            """.trimIndent(),
            365),
        Vaccine("Varicella (Chickenpox) Vaccine",
            """
<h1>Varicella (Chickenpox) Vaccine</h1>
<p>The Varicella vaccine, commonly known as the chickenpox vaccine, is a preventive measure used to protect individuals from the varicella-zoster virus, which causes chickenpox.</p>

<h2>Disease Targeted</h2>
<p>Chickenpox is a highly contagious viral infection that leads to an itchy rash, fever, and other symptoms. It can cause discomfort and complications, especially in adolescents, adults, and individuals with weakened immune systems.</p>

<h2>Vaccine Type</h2>
<p>The Varicella vaccine is a live attenuated vaccine, meaning it contains a weakened form of the varicella-zoster virus that cannot cause chickenpox in healthy individuals but stimulates the immune system to develop immunity.</p>

<h2>Vaccination Schedule</h2>
<p>The Varicella vaccine is typically administered in two doses. The first dose is recommended at around 1 year of age, and the second dose is often given between 4 and 6 years of age. The timing may vary by country and healthcare guidelines.</p>

<h2>Effectiveness</h2>
<p>The Varicella vaccine is highly effective in preventing chickenpox. It provides long-lasting immunity against the virus and reduces the risk of severe illness and complications.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with the Varicella vaccine is essential for preventing chickenpox and its potential complications. It also helps reduce the spread of the virus in communities.</p>

<h2>Side Effects</h2>
<p>The Varicella vaccine is generally safe, with mild side effects such as soreness at the injection site being common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The Varicella vaccine is widely used in vaccination programs around the world and has contributed to the reduction of chickenpox cases, especially in children.</p>

<h2>Booster Doses</h2>
<p>Booster doses of the Varicella vaccine are not routinely recommended for healthy individuals who have completed the two-dose series. However, in some situations, such as for certain healthcare workers, additional doses may be recommended.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you or your child receives the Varicella vaccine according to the recommended schedule. Varicella vaccination is an important step in preventing chickenpox and its associated discomfort and complications.</p>
            """.trimIndent(),
            365),
        Vaccine("Hepatitis A Vaccine",
            """
<h1>Hepatitis A Vaccine</h1>
<p>The Hepatitis A vaccine is a vital immunization used to protect individuals from the Hepatitis A virus (HAV), a contagious liver infection.</p>

<h2>Disease Targeted</h2>
<p>Hepatitis A is a viral infection that affects the liver and can cause symptoms such as jaundice (yellowing of the skin and eyes), abdominal pain, nausea, and fatigue. It is typically transmitted through contaminated food or water or close contact with an infected person.</p>

<h2>Vaccine Type</h2>
<p>The Hepatitis A vaccine is an inactivated (killed) vaccine. It contains inactivated HAV particles that cannot cause the disease but stimulate the immune system to develop protection against the virus.</p>

<h2>Vaccination Schedule</h2>
<p>The Hepatitis A vaccine is administered in a series of two doses. The first dose is typically given at around 1 year of age, and the second dose is administered 6 to 18 months after the first dose. Booster doses may be recommended in certain situations, such as for travelers to regions with a high risk of HAV exposure.</p>

<h2>Effectiveness</h2>
<p>The Hepatitis A vaccine is highly effective in preventing Hepatitis A infection. It provides long-lasting immunity against the virus.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with the Hepatitis A vaccine is crucial for preventing Hepatitis A infections, especially in individuals traveling to regions with high HAV prevalence and in populations at risk of exposure due to food, water, or close contact with infected individuals.</p>

<h2>Side Effects</h2>
<p>The Hepatitis A vaccine is generally safe, with mild side effects such as pain or redness at the injection site being common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The Hepatitis A vaccine is an important component of vaccination programs in many countries and has contributed to the reduction of Hepatitis A cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of the Hepatitis A vaccine may be recommended for travelers or individuals at continued risk of HAV exposure. Consult with a healthcare provider to determine if booster doses are needed.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you receive the Hepatitis A vaccine according to the recommended schedule. Vaccination is a key preventive measure against Hepatitis A.</p>
            """.trimIndent(),
            365),
        Vaccine("DTaP (Diphtheria, Tetanus, Pertussis) 4th Dose",
            """
<h1>DTaP (Diphtheria, Tetanus, Pertussis) Vaccine</h1>
<p>The DTaP vaccine, which stands for Diphtheria, Tetanus, and Pertussis, is a vital immunization used to protect individuals, especially children, from three serious bacterial infections: diphtheria, tetanus, and pertussis.</p>

<h2>Diseases Targeted</h2>
<p>1. <strong>Diphtheria:</strong> Diphtheria is a bacterial infection that can lead to a thick coating in the back of the throat, making it difficult to breathe. It can also damage the heart, kidneys, and nerves.</p>
<p>2. <strong>Tetanus:</strong> Tetanus, often called "lockjaw," is caused by a toxin produced by a bacterium. It can cause severe muscle stiffness and spasms, and it can be life-threatening.</p>
<p>3. <strong>Pertussis (Whooping Cough):</strong> Pertussis is a highly contagious respiratory disease characterized by severe coughing fits. It can lead to serious complications, especially in infants and young children.</p>

<h2>Vaccine Type</h2>
<p>The DTaP vaccine is an inactivated (killed) vaccine, meaning it contains inactivated or non-live components of the bacteria that cause these diseases. It cannot cause the diseases it protects against.</p>

<h2>Vaccination Schedule</h2>
<p>DTaP is typically administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, 15-18 months, and 4-6 years of age. Booster doses may be recommended in later childhood and adolescence.</p>

<h2>Effectiveness</h2>
<p>The DTaP vaccine is highly effective in preventing diphtheria, tetanus, and pertussis. It stimulates the immune system to produce antibodies that protect against these diseases.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with DTaP is crucial for preventing potentially life-threatening diseases, especially in infants and young children who are most vulnerable to these infections. It also contributes to herd immunity, protecting those who cannot receive vaccines for medical reasons.</p>

<h2>Side Effects</h2>
<p>The DTaP vaccine is generally safe, with mild side effects such as redness or swelling at the injection site and low-grade fever. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>DTaP vaccination is part of routine childhood immunization programs in many countries and has contributed significantly to the reduction of diphtheria, tetanus, and pertussis cases worldwide.</p>

<h2>Booster Doses</h2>
<p>Booster doses of tetanus and diphtheria-containing vaccines are recommended for adolescents and adults to maintain immunity throughout life.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that you and your family receive the DTaP vaccine according to the recommended schedule. Vaccination is a critical measure in preventing these serious bacterial infections.</p>
            """.trimIndent(),
            545),
        Vaccine("Hib (Haemophilus influenzae type b) 4th Dose",
            """
<h1>Hib (Haemophilus influenzae type b) Vaccine</h1>
<p>The Hib vaccine, or Haemophilus influenzae type b vaccine, is a crucial immunization used to protect infants and young children from Haemophilus influenzae type b (Hib) infections.</p>

<h2>Disease Targeted</h2>
<p>Haemophilus influenzae type b (Hib) is a bacterial infection that can lead to serious diseases, including:</p>
<ul>
    <li><strong>Meningitis:</strong> An infection of the lining of the brain and spinal cord.</li>
    <li><strong>Pneumonia:</strong> A lung infection that can cause breathing difficulties.</li>
    <li><strong>Epiglottitis:</strong> A severe throat infection that can block the airway.</li>
    <li><strong>Septicemia:</strong> A bloodstream infection.</li>
    <li><strong>Other Invasive Diseases:</strong> Hib can also cause infections in the joints, bones, and other parts of the body.</li>
</ul>

<h2>Vaccine Type</h2>
<p>The Hib vaccine is typically available in different formulations, including conjugate vaccines. It contains components of the Hib bacterium that stimulate the immune system to develop protection against Hib infections.</p>

<h2>Vaccination Schedule</h2>
<p>The Hib vaccine is administered to infants and young children in a series of doses. The recommended schedule includes doses at 2 months, 4 months, 6 months, and a booster dose between 12 and 15 months of age. The exact schedule may vary by country and healthcare guidelines.</p>

<h2>Effectiveness</h2>
<p>The Hib vaccine is highly effective in preventing Hib infections and the serious diseases they can cause. It provides long-lasting immunity against Hib.</p>

<h2>Importance of Vaccination</h2>
<p>Vaccination with Hib is crucial for preventing potentially life-threatening diseases, especially in infants and young children. It has significantly reduced the incidence of Hib-related illnesses since its introduction.</p>

<h2>Side Effects</h2>
<p>The Hib vaccine is generally safe, with mild side effects such as redness or swelling at the injection site being the most common. Serious side effects are rare.</p>

<h2>Global Impact</h2>
<p>The Hib vaccine is widely used as part of childhood immunization programs in many countries and has led to a substantial decrease in Hib-related diseases on a global scale.</p>

<h2>Booster Doses</h2>
<p>Booster doses of Hib vaccine are typically not required if the primary series is completed during infancy. However, healthcare providers may recommend additional doses in certain situations, such as for individuals with weakened immune systems.</p>

<p>Consult with a healthcare provider or follow your country's vaccination guidelines to ensure that your child receives the Hib vaccine according to the recommended schedule. Hib vaccination is a vital step in protecting children from Hib-related diseases.</p>
            """.trimIndent(),
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