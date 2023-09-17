package com.example.vaxin.ui.show_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.vaxin.data.VaxinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowDetailViewModel @Inject constructor(
    private val vaxinRepository: VaxinRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val TAG = "SHOW_DETAIL"

    val vaccineId = savedStateHandle["vaccineId"] ?: "Hepatitis B Vaccine (HepB)"

    val vaccineWithChilds = vaxinRepository.getChildsOfVaccine(vaccineId)

}