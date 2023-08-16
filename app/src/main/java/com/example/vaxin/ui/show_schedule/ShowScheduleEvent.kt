package com.example.vaxin.ui.show_schedule

import com.example.vaxin.data.Vaccine

sealed class ShowScheduleEvent {
    data class OnVaccineClicked(val vaccine: Vaccine): ShowScheduleEvent()
    data class OnVaccineChecked(val vaccineId: String, val isDone: Boolean): ShowScheduleEvent()
}
