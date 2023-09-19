package com.example.vaxin.ui.show_schedule

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

@Composable
fun ShowScheduleGeom(
    color: Color
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val pathA = Path()

        val startPath = Offset(size.width * 0f, size.height * 0.75f)
        val endPath = Offset(size.width * 1.0f, size.height * 0.33f)
        val controlOnePathA = Offset(size.width * 0.25f, size.height * 1.0f)
        val controlTwoPathA = Offset(size.width * 0.75f, size.height * -0.2f)

        pathA.moveTo(startPath.x, startPath.y)
        pathA.cubicTo(controlOnePathA.x, controlOnePathA.y,
            controlTwoPathA.x, controlTwoPathA.y,
            endPath.x, endPath.y)
        pathA.lineTo(size.width * 1.0f, size.height * 1.0f)
        pathA.lineTo(size.width * 0f, size.height * 1.0f)
        pathA.close()

        drawPath(
            path = pathA,
            color = color.copy(alpha = 0.2f)
        )

        val pathB = Path()

        val controlOnePathB = Offset(size.width * 0.33f, size.height * 1.2f)
        val controlTwoPathB = Offset(size.width * 0.75f, size.height * 0.2f)

        pathB.moveTo(startPath.x, startPath.y)
        pathB.cubicTo(controlOnePathB.x, controlOnePathB.y,
            controlTwoPathB.x, controlTwoPathB.y,
            endPath.x, endPath.y)
        pathB.lineTo(size.width * 1.0f, size.height * 1.0f)
        pathB.lineTo(size.width * 0f, size.height * 1.0f)
        pathB.close()

        drawPath(
            pathB,
            color.copy(alpha=0.2f)
        )
    }
}