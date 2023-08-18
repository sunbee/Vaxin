package com.example.vaxin.ui.show_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.vaxin.util.SampleData

@Composable
fun ShowDetailScreen(
    vaccineId: String,
    viewModel: ShowDetailViewModel = hiltViewModel()
) {
    Column {
        Text(text = vaccineId)
        Image(
            painter = rememberAsyncImagePainter(model = SampleData.vaccineImages.get(vaccineId)),
            contentDescription = "CDC Image",
            modifier = Modifier.size(256.dp) )
        Text(text = viewModel.vaccineId)
    }
}