package com.example.vaxin.ui.show_schedule

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.vaxin.data.VaxinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowScheduleViewModel @Inject constructor(
    private val vaxinRepository: VaxinRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val childId: String = savedStateHandle["childId"] ?: "Balakrishna"

    val balakrishnaWithVaccines = vaxinRepository.getVaccinesOfChild("Balakrishna")

    val childWithVaccines = vaxinRepository.getVaccinesOfChild(childId)

}