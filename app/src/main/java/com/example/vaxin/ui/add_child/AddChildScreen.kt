package com.example.vaxin.ui.add_child

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddChildScreen(
    modifier: Modifier = Modifier
        .fillMaxSize(),
    viewModel: AddChildViewModel = hiltViewModel()
) {

    Text(
        text = "Hello!"
    )
}
