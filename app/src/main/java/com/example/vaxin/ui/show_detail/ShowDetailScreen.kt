package com.example.vaxin.ui.show_detail

import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import com.example.vaxin.util.SampleData

@Composable
fun ShowDetailScreen(
    viewModel: ShowDetailViewModel = hiltViewModel()
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        val vaccineId = viewModel.vaccineId
        /*
        TODO("""
            Replace with DB query, update schema,
            eventually migrate to Firebase BaaS.
        """.trimIndent())

         */
        val vaccineImage = SampleData.vaccineImages.get(vaccineId)
        val vaccineWithChilds = viewModel.vaccineWithChilds.collectAsState(initial = emptyList())?.value?.getOrNull(0)
        val vaccineDetails = vaccineWithChilds?.vaccine?.description ?: " "
        val vaccineHTML = HtmlCompat.fromHtml(vaccineDetails, 0)
        val scroll = rememberScrollState(0)

        Text(
            text = vaccineId,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 24.sp,
            overflow = TextOverflow.Ellipsis
       )
        Spacer(modifier = Modifier.height(8.dp))
        SubcomposeAsyncImage(
            model = vaccineImage,
            contentDescription = "CDC Image",
            contentScale =  ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .size(256.dp)
                .clip(CircleShape),
            loading = { CircularProgressIndicator() }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .verticalScroll(scroll)
                .background(MaterialTheme.colorScheme.background),
            factory = {
                TextView(it)
            },
            update = {
                it.text = vaccineHTML
            })

    }
}