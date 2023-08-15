package com.example.vaxin.ui.add_child

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vaxin.util.UiEvent
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddChildScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: AddChildViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
        .fillMaxSize()
) {

    val balaVaccines = viewModel.balakrishnaWithVaccines.collectAsState(initial = emptyList())

    val childs = viewModel.childs.collectAsState(initial = emptyList())

    val snackbarHostState = remember { SnackbarHostState() }

    val dateDialogState = rememberMaterialDialogState()

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() { event ->
            when(event) {
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
                is UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.actionLabel
                    )
                }
                else -> Unit
            }
        }
    }
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.onEvent(AddChildEvent.OnAddChild) }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription ="Add")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
                .background(
                    color = Color.DarkGray,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        color = Color.Cyan,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {
                TextField(
                    value = viewModel.childName.value,
                    onValueChange = {
                        viewModel.onEvent(AddChildEvent.OnChildNameChange(it))
                    },
                    placeholder = {
                        Text(text = "Name")
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.72f)
                        .padding(8.dp),
                    singleLine = true
                )
                Button(onClick = {
                    dateDialogState.show()
                }) {
                    Text(text = "Date of Birth")

                }
                Text(
                    text = viewModel.formattedDate.value,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )
            }
            Spacer(modifier = Modifier.height(8.dp) )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        color = Color.Cyan,
                        shape = RoundedCornerShape(16.dp)
                    )
            ) {

                items(childs.value) {child ->
                    AddChildCard(
                        child = child,
                        onEvent = viewModel::onEvent)
                }
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
            }  // end LAZY COLUMN
        }  // end COLUMN
    }  // end SCAFFOLD
    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(
                text = "OK"
            ) {
                Toast.makeText(
                    context,
                    "Clicked OK!",
                    Toast.LENGTH_LONG
                ).show()
            }
            negativeButton(
                text = "Cancel"
            )
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = "Pick DoB",
            allowedDateValidator = {
                it < LocalDate.now().plusDays(1)
            }
        ) {
            viewModel.pickedDate.value = it
        }
    }
}
