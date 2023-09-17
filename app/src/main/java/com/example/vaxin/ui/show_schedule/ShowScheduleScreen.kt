package com.example.vaxin.ui.show_schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vaxin.util.UiEvent


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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Text(
            text = "${childId}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text = "You have upcoming vaccinations as follows:",
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Spacer(modifier = Modifier.height(8.dp))

        /*
        * First show the vaccines overdue.
        * */
        val itemsPerRowOverdue = 2
        val rowsVaccinesOverdue = vaccinesOverdue.value.chunked(itemsPerRowOverdue)

        if (rowsVaccinesOverdue.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                item {
                    Text(
                        text = "Overdue:",
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                items(rowsVaccinesOverdue) {chunkedChildVaccineCrossRefs ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        chunkedChildVaccineCrossRefs.forEach { childVaccineCrossRef ->
                            ShowVaccineCard(
                                childName = childId,
                                vaccineCrossRef = childVaccineCrossRef,
                                onEvent = viewModel::onEvent,
                                modifier = Modifier
                                    .background(
                                        color = MaterialTheme.colorScheme.tertiary,
                                        shape = RoundedCornerShape(16.dp)
                                    )
                            )
                        }  // end FOREACH
                    }  // end ROW
                }  // end ITEMS
            }  // end LAZY COLUMN
        } else {
            Text(
                text = "You are all caught up!",
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        /*
        * Then show the vaccines that are coming due, picking the top 5 from the list.
        * */
        val itemsPerRowDue = 2
        val rowsVaccinesDue = vaccinesDue.value.take(6).chunked(itemsPerRowDue)

        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            item {
                Text(
                    text = "Coming up next:",
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            items(rowsVaccinesDue) {chunkedChildVaccineCrossRefs ->
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    chunkedChildVaccineCrossRefs.forEach { childVaccineCrossRef ->
                        ShowVaccineCard(
                            childName = childId,
                            vaccineCrossRef = childVaccineCrossRef,
                            onEvent = viewModel::onEvent,
                            modifier = Modifier
                                .background(
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = RoundedCornerShape(16.dp)
                                )
                        )
                    }  // end FOREACH
                }  // end ROW
            }  // end ITEMS
        }  // end LAZYCOLUMN
    }  // end COLUMN
}
