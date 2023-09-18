package com.example.vaxin.ui.add_child

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.vaxin.data.Child
import java.io.File
import java.io.FileOutputStream

@Composable
fun AddChildCard(
    child: Child,
    onEvent: (AddChildEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    /*
    Convert content URI (content://) to file URI (file://).
    READ the contents into a byte stream and WRITE to file.
    This way, the file is always available to the app from
    its local file store and the file URI can be persisted.
    The file will be available even if the original is deleted.
     */
    fun getFileURI(contentUri: Uri, childId: String, context: Context, contentResolver: ContentResolver): Uri {
        /* Read contents at content URI into byte array */
        val imBytes = contentResolver.openInputStream(contentUri)?.use {
            it.readBytes()
        }
        /* Write byte array into a local file with appropriate name */
        val file = File(context.filesDir, "${childId}.jpeg")
        FileOutputStream(file)?.use {
            it.write(imBytes)
        }
        /* Get the file URI to persistently access image */
        return file.toUri()
    }

    val TAG = "UI_CHILDCARD"

    val context = LocalContext.current

    val contentResolver = remember { context.contentResolver }

    val imageURI = remember {
        mutableStateOf<String>(
            child.imageURI?.toString() ?: "android.resource://${context.packageName}/drawable/child"
        )
    }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            Log.d(TAG, "Got content uri: ${uri}")
            uri?.let {
                imageURI.value = it.toString()  // For immediate preview
                val fileURI = getFileURI(it, child.childName, context, contentResolver)
                Log.d(TAG, "Got file uri: ${fileURI}")
                onEvent(AddChildEvent.OnAddChildPhoto(
                    imageURI = fileURI,
                    child=child))
            }
        })




    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .clickable(onClick = { onEvent(AddChildEvent.OnChildSelected(child)) })
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = imageURI.value,
                    contentDescription = "Generic Child",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(75.dp)
                        .clip(shape = CircleShape)
                        .clickable {
                            singlePhotoPickerLauncher.launch(
                                PickVisualMediaRequest(
                                    ActivityResultContracts.PickVisualMedia.ImageOnly
                                )
                            )
                        })
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = child.childName,
                            fontSize = 20.sp,
                            color =MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(
                            onClick = { onEvent(AddChildEvent.OnChildDelete(child)) }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete",
                                tint = MaterialTheme.colorScheme.onPrimary)
                        }
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = child.dob,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}