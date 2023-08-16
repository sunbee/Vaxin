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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.first

@Composable
fun ShowScheduleScreen(
    childId: String,
    viewModel: ShowScheduleViewModel = hiltViewModel()
) {
    val balaVaccines = viewModel.balakrishnaWithVaccines.collectAsState(initial = emptyList())

    val childVaccines = viewModel.childWithVaccines.collectAsState(initial = emptyList())

    /*
    * Sample usage to illustrate collecting info from from Singe Source of Truth
    * in the data layer with the application of a filter transform in the view model.
    * */
    val vaccinesDue90 = viewModel.vaccinesDue90.collectAsState(initial = emptyList())

    val vaccinesDue = viewModel.childVaccinesDue.collectAsState(initial = emptyList())

    val vaccinesOverdue = viewModel.childVaccinesOverdue.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        Text("Hello, ${childId}")
        LazyColumn() {
            items(vaccinesOverdue.value) {childVaccineCrossRef ->
                ShowVaccineCard(
                    vaccineCrossRef = childVaccineCrossRef,
                    onEvent = viewModel::onEvent)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn() {
            items(vaccinesDue.value) {
                Text(it.dueDate.toString())

            }
        }
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
    }


}