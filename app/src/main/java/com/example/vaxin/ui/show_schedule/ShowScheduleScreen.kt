package com.example.vaxin.ui.show_schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vaxin.util.UiEvent
import kotlinx.coroutines.flow.first

@Composable
fun ShowScheduleScreen(
    childId: String,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: ShowScheduleViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() { event ->
            when(event) {
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
                is UiEvent.ShowSnackbar -> {
                    TODO("Implement snackbar after adding scaffold.")

                }
                else -> Unit
            }
        }
    }

    /*
    * DEMO, NOT USED
    * Collect data from from Singe Source of Truth in the data layer.
    * */
    val balaVaccines = viewModel.balakrishnaWithVaccines.collectAsState(initial = emptyList())
    val childVaccines = viewModel.childWithVaccines.collectAsState(initial = emptyList())
    val vaccinesDue90 = viewModel.vaccinesDue90.collectAsState(initial = emptyList())

    /*
    * Get the vaccines due, collecting as state. Get the vaccines overdue in a separate list.
    * Note that by collecting state, any updates to the Single Source of Truth
    * will immediately update the UI, which is our desired behavior.
    * Use App Inspection to verify this by accessing the DB and making small changes to the data
    * via the console. You can also check "Live updates" option to see changes from UI first-hand.
    * */
    val vaccinesDue = viewModel.childVaccinesDue.collectAsState(initial = emptyList())

    val vaccinesOverdue = viewModel.childVaccinesOverdue.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Hello, ${childId}")
        /*
        * First show the vaccines overdue.
        * */
        LazyColumn() {
            items(vaccinesOverdue.value) {childVaccineCrossRef ->
                ShowVaccineCard(
                    childName = childId,
                    vaccineCrossRef = childVaccineCrossRef,
                    onEvent = viewModel::onEvent)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        /*
        * Then show the vaccines that are coming due, picking the top 5 from the list.
        * */
        LazyColumn() {
            items(vaccinesDue.value.take(5)) {childVaccineCrossRef ->
                ShowVaccineCard(
                    childName = childId,
                    vaccineCrossRef = childVaccineCrossRef,
                    onEvent = viewModel::onEvent)
            }
        }

        /*
        * DEMO, NOT USED
        * Show the roster of vaccines for selected child.
        * Used for verifying that the navigation feature works correctly,
        * i.e. navigates to this screen with child's name
        * and shows the child's name with vaccines roster.
        * Note the nested lists arising from use of the relation ChildWithVaccines.
        * The data structure is unsuitable in practice
        * because qualifying data about the many-many relationship, such as due-date,
        * is not part of vaccine data puled from table Vaccine
        * when it is joined with child's data from table Child.
        * Nevertheless, this approach illustrates the preprocessing
        * to extract the vaccines from the data structure returned by the query
        * following the relation between the two tables.
        * The better approach is to query cross-ref table directly
        * and obtain information about a child's vaccination schedule.
        * HENCE DEPRECATED!

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(childVaccines.value) {
                Text(text = it.child.childName)
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp))
                it.vaccines.forEach {
                    Text(text = it.vaccineName)
                }  // end
            }  // end ITEMS
        }

         */
    }


}