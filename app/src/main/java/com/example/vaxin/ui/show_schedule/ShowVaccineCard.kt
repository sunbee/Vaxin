package com.example.vaxin.ui.show_schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vaxin.data.Vaccine
import com.example.vaxin.data.relations.ChildVaccineCrossRef
import com.example.vaxin.ui.add_child.AddChildEvent
import com.example.vaxin.ui.show_schedule.ShowScheduleEvent

@Composable
fun ShowVaccineCard(
    childName: String,
    vaccineCrossRef: ChildVaccineCrossRef,
    onEvent: (ShowScheduleEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val date: String = ""

    BoxWithConstraints(
        modifier = modifier
            .padding(8.dp)
            .size(150.dp)
            .aspectRatio(1f)
            .clickable {
                onEvent(ShowScheduleEvent.OnVaccineClicked(vaccineCrossRef.vaccineName))
            }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 8.dp,
                    top = 6.dp,
                    end = 36.dp,
                    bottom = 5.dp
                )
                .align(Alignment.TopStart)
        ) {
            Text(
                text = vaccineCrossRef.vaccineName,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.SemiBold,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = vaccineCrossRef.dueDate,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                fontStyle = FontStyle.Italic
            )
        }
        Checkbox(
            checked = vaccineCrossRef.isDone,
            onCheckedChange = { isChecked ->
                onEvent(
                    ShowScheduleEvent.OnVaccineChecked(
                        childName,
                        vaccineCrossRef.vaccineName,
                        isChecked
                    )
                )
            },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }  // end BOX
}