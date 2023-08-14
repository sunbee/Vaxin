package com.example.vaxin.ui.add_child

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vaxin.data.Child

@Composable
fun AddChildCard(
    child: Child,
    onEvent: (AddChildEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = child.childName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = child.dob,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Checkbox(
            checked = false,
            onCheckedChange = { onEvent(AddChildEvent.OnChildSelected(child))})
    }
}