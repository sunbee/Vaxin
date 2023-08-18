package com.example.vaxin.ui.show_schedule

import com.example.vaxin.data.Vaccine

sealed class ShowScheduleEvent {
    data class OnVaccineClicked(val vaccineId: String): ShowScheduleEvent()
    data class OnVaccineChecked(val childId: String, val vaccineId: String, val isDone: Boolean): ShowScheduleEvent()
}
