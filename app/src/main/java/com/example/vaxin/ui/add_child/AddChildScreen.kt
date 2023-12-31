package com.example.vaxin.ui.add_child

import android.util.Log
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    val TAG = "UI_ADDCHILD"

    val childs = viewModel.childs.collectAsState(initial = emptyList())

    val snackbarHostState = remember { SnackbarHostState() }

    val dateDialogState = rememberMaterialDialogState()

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect() { event ->
            when(event) {
                is UiEvent.Navigate -> {
                    Log.d("UI_COLLECT", "Navigate to ${event.route}")
                    onNavigate(event)
                }
                is UiEvent.ShowSnackbar -> {
                    val snackbarResult = snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.actionLabel,
                        duration = SnackbarDuration.Short
                    )
                    when (snackbarResult) {
                        SnackbarResult.ActionPerformed -> {
                            viewModel.onEvent(AddChildEvent.OnChildDeleteUndo)
                        }
                        else -> Unit
                    }
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
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                OutlinedTextField(
                    value = viewModel.childName.value,
                    onValueChange = {
                        viewModel.onEvent(AddChildEvent.OnChildNameChange(it))
                    },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        textColor = MaterialTheme.colorScheme.onBackground
                    ),
                    placeholder = {
                        Text(text = "Name")
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.72f)
                        .padding(8.dp),
                    singleLine = true
                )
                Button(onClick = { dateDialogState.show() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )) {
                    Text(text = "Date of Birth")

                }
                Text(
                    text = viewModel.formattedDate.value,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(8.dp) )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                item {
                    Text(
                        text = "Children:",
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                items(childs.value) {child ->
                    AddChildCard(
                        child = child,
                        onEvent = viewModel::onEvent)
                }
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
