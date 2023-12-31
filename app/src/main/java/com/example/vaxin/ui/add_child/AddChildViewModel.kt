package com.example.vaxin.ui.add_child

import android.net.Uri
import android.util.Log
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaxin.data.Child
import com.example.vaxin.data.VaxinRepository
import com.example.vaxin.util.Routes
import com.example.vaxin.util.SampleData
import com.example.vaxin.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AddChildViewModel @Inject constructor(
    private val vaxinRepository: VaxinRepository
): ViewModel() {

    val TAG = "ADD_CHILD"

    /*
    * Handle the calendar for date-picking,
    * using a third-party plugin for calendar/clock.
    * */
    var pickedDate = mutableStateOf(LocalDate.now())

    var formattedDate = derivedStateOf {
        DateTimeFormatter
            .ofPattern("yyyy-MM-dd")
            .format(pickedDate.value)
    }

    /*
    * Handle user-originated event to add a new child
    * and display the up-to-date list of children
    * in the UI.
    * */
    var childName = mutableStateOf<String>("")
        private set

    var selectedImageURI = mutableStateOf<Uri?>(null)

    val childs = vaxinRepository.getChilds()

    val vaccines = vaxinRepository.getVaccines()

    private var deletedChild: Child? = null

    private val _uiEvent = MutableSharedFlow<UiEvent>(replay = 0)
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(addChildEvent: AddChildEvent) {
        when(addChildEvent) {
            is AddChildEvent.OnChildNameChange -> {
                childName.value = addChildEvent.childName
            }
            is AddChildEvent.OnChildSelected -> {
                viewModelScope.launch {
                    val childId = addChildEvent.child.childName
                    Log.d("VM_EMIT", "Navigate to SHOW_SCHEDULE_SCREEN with $childId.")
                    _uiEvent.emit(UiEvent.Navigate(Routes.SHOW_SCHEDULE_SCREEN + "?childId=$childId"))

                }
            }
            is AddChildEvent.OnAddChild -> {
                /*
                * Check that the child's name is not blank and
                * proceed to insert the record in the database.
                * Otherwise, if name is left blank then
                * show appropriate error message in snackbar.
                * Note that when child is added,
                * the vaccinations schedule must be generated
                * and added to the backend.
                * */
                viewModelScope.launch(Dispatchers.IO) {
                    if (childName.value.isBlank()) {
                        withContext(Dispatchers.Main) {
                            Log.d(TAG, "Found no name for child!")
                            _uiEvent.emit(UiEvent.ShowSnackbar(
                                message = "Found no name for child!",
                                actionLabel = null
                            ))
                        }
                        return@launch
                    }
                    val child = Child(
                        childName = childName.value,
                        dob = formattedDate.value,
                        imageURI = selectedImageURI.value?.toString()
                    )
                    val childVaccineCrossRefs = SampleData.generateChildVaccineCrossRefs(
                        child = child
                    ).toList()
                    vaxinRepository.insertChild(child)
                    childVaccineCrossRefs.forEach { childVaccineCrossRef ->
                        vaxinRepository.insertChildVaccineCrossRef(childVaccineCrossRef)
                    }
                }
            }
            is AddChildEvent.OnChildDelete -> {
                viewModelScope.launch(Dispatchers.IO) {
                    deletedChild = addChildEvent.child
                    vaxinRepository.deleteVaccinesOfChild(addChildEvent.child.childName)
                    vaxinRepository.deleteChild(addChildEvent.child)
                    withContext(Dispatchers.Main) {
                        _uiEvent.emit(UiEvent.ShowSnackbar(
                            message = "You have deleted ${addChildEvent.child.childName}!",
                            actionLabel = "Undo"
                        ))
                    }
                }

            }
            is AddChildEvent.OnChildDeleteUndo -> {
                deletedChild?.let{ child ->
                    viewModelScope.launch(Dispatchers.IO) {
                        val childVaccineCrossRefs = SampleData.generateChildVaccineCrossRefs(
                            child = child
                        ).toList()
                        vaxinRepository.insertChild(child)
                        childVaccineCrossRefs.forEach { childVaccineCrossRef ->
                            vaxinRepository.insertChildVaccineCrossRef(childVaccineCrossRef)
                        }
                    }
                }
            }
            is AddChildEvent.OnAddChildPhoto -> {
                Log.d(TAG, "Picked snap at ${addChildEvent.imageURI}")
                viewModelScope.launch(Dispatchers.IO) {
                    vaxinRepository.insertChild(addChildEvent.child.copy(
                        imageURI = addChildEvent.imageURI.toString()
                    ))
                }
                /*
                Get file URI (file://) for file generated from
                contents at content URI (content://) and update
                child's record in DB.
                 */
            }
            else -> Unit
        }
    }

    /*
    * Pre-populate the DB with sample data.
    * */
    fun populateDBDefaults() {
        viewModelScope.launch(Dispatchers.IO) {
            SampleData.childs.forEach { child ->
                vaxinRepository.insertChild(child) }
            SampleData.vaccines.forEach { vaccine ->
                vaxinRepository.insertVaccine(vaccine)
            }
            SampleData.childVaccineRelations.forEach { childVaccineCrossRef ->
                vaxinRepository.insertChildVaccineCrossRef(childVaccineCrossRef)
            }
        }
    }

    fun clearDBContents() {
        viewModelScope.launch(Dispatchers.IO) {
            vaxinRepository.deleteChilds()
            vaxinRepository.deleteChildVaccinesCrossRefs()
        }
    }

    init {
        // Debug: // clearDBContents()  // One-Time ONLY!
        populateDBDefaults()
    }

}