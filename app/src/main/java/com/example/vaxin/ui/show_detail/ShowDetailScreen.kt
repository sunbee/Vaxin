package com.example.vaxin.ui.show_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ShowDetailScreen(
    vaccineId: String,
    viewModel: ShowDetailViewModel = hiltViewModel()
) {
    Column {
        Text(text = vaccineId)
        Text(text = viewModel.vaccineId)
    }
}