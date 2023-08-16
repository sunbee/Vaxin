package com.example.vaxin.ui.show_schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaxin.data.Vaccine
import com.example.vaxin.data.VaxinRepository
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.util.SampleData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ShowScheduleViewModel @Inject constructor(
    private val vaxinRepository: VaxinRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    val today = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now())

    private val childId: String = savedStateHandle["childId"] ?: "Balakrishna"

    /*
    * DEMO, NOT USED
    * Query the sample data that the database is pre-populated with
    * to get child's vaccination roster. Use this query as model
    * to retrieve the records of any child with the child's name.
    * */
    val balakrishnaWithVaccines = vaxinRepository.getVaccinesOfChild("Balakrishna")

    val childWithVaccines = vaxinRepository.getVaccinesOfChild(childId)

    /*
    * DEMO, NOT USED
    * Filter on the result of querying a many-many relationship
    * that navigates the relation in a transaction.
    * The returned value is a flow of nested lists,
    * necessitating a transform with map as follows:
    * 1. Get the inner list as first element (first)
    * 2. Access the attribute vaccines
    * 3. Apply the filter condition in lambda (filter)
    * Now the result is ready to be collected in composable for display.
    * Use this example as a model for other transformations
    * on vaccination records in the database.
    * */
    var vaccinesDue90 = vaxinRepository.getVaccinesOfChild(childId).map {
        it.first().vaccines.filter { vaccine ->
            vaccine.daysAfterBirth > 90
        }
    }

    /*
    * Filter on the result of querying a many-many relationship
    * using the cross-reference table. This table has the qualifying data
    * upon the m:n relation - due date and completion status.
    * We have chosen to use child's name as primary key of Child table
    * and vaccine name as primary key of the Vaccine table,
    * so these names form a composite key of the cross-referencing table.
    * Ergo, we query the table directly with child's name
    * to retrieve the vaccination schedule with completion status.
    * The returned value is a flow of lists to which a filter is applied with map.
    * Now the result is ready to be collected in composable for display.
    * */
    var childVaccinesDue = vaxinRepository.getChildVaccineCrossRefs(childId).map { childVaccineCrossRefs ->
        childVaccineCrossRefs.filter { childVaccineCrossRef ->
            ((!childVaccineCrossRef.isDone) && (childVaccineCrossRef.dueDate.compareTo(today) > 0))
        }
    }

    var childVaccinesOverdue = vaxinRepository.getChildVaccineCrossRefs(childId).map { childVaccineCrossRefs ->
        childVaccineCrossRefs.filter { childVaccineCrossRef ->
            ((!childVaccineCrossRef.isDone) && (childVaccineCrossRef.dueDate.compareTo(today) < 0))
        }
    }

    fun onEvent(event: ShowScheduleEvent) {
        when(event) {
            is ShowScheduleEvent.OnVaccineChecked -> {
                viewModelScope.launch(Dispatchers.IO) {
                    TODO("Get ChildVaccineCrossRef by childId, vaccineId, copy, modify, insert.")
                }
            }
            is ShowScheduleEvent.OnVaccineClicked -> {
                TODO("Navigate to details with vaccine name.")
            }
        }
    }

}