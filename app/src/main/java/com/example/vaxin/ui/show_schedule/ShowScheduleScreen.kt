package com.example.vaxin.ui.show_schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ShowScheduleScreen(
    childId: String,
    viewModel: ShowScheduleViewModel = hiltViewModel()
) {
    val balaVaccines = viewModel.balakrishnaWithVaccines.collectAsState(initial = emptyList())
    /*
                items(balaVaccines.value) {
                    Text(text = it.child.childName)
                    Spacer(modifier = Modifier
                        .fillMaxWidth()
                        .height(16.dp))
                    it.vaccines.forEach {
                        Text(text = it.vaccineName)
                    }  // end
                }  // end ITEMS
                */
}