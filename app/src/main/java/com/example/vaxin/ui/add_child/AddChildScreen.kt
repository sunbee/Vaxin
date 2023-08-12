package com.example.vaxin.ui.add_child

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vaxin.data.relations.ChildWithVaccines

@Composable
fun AddChildScreen(
    modifier: Modifier = Modifier
        .fillMaxSize(),
    viewModel: AddChildViewModel = hiltViewModel()
) {

    val balaVaccines = viewModel.balakrishnaWithVaccines.collectAsState(initial = emptyList())
    Text(
        text = "Hello!"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        items(balaVaccines.value) {
            Text(text = it.child.childName)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))
            it.vaccines.forEach { 
                Text(text = it.vaccineName)
            }
        }
    }
}
