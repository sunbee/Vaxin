package com.example.vaxin.ui.show_schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vaxin.data.Vaccine
import com.example.vaxin.data.VaxinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowScheduleViewModel @Inject constructor(
    private val vaxinRepository: VaxinRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val childId: String = savedStateHandle["childId"] ?: "Balakrishna"

    val balakrishnaWithVaccines = vaxinRepository.getVaccinesOfChild("Balakrishna")

    val childWithVaccines = vaxinRepository.getVaccinesOfChild(childId)

    var vaccinesDue90 = vaxinRepository.getVaccinesOfChild(childId).map {
        it.first().vaccines.filter { vaccine ->
            vaccine.daysAfterBirth > 90
        }
    }

}