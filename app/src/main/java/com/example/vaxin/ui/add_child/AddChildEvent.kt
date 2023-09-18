package com.example.vaxin.ui.add_child

import android.net.Uri
import com.example.vaxin.data.Child

/*
* Enable user actions as follows:
* 1. Selects a child by clicking on checkbox (OnChildSelected)
* 2. Enters child's name in the text field (OnChildNameChange)
* 3. Adds child by clicking of floating "add" button (OnAddChild)
* */
sealed class AddChildEvent {
    data class OnChildSelected(val child: Child): AddChildEvent()
    data class OnChildNameChange(val childName: String): AddChildEvent()
    object OnAddChild: AddChildEvent()
    data class OnChildDelete(val child: Child): AddChildEvent()
    object OnChildDeleteUndo: AddChildEvent()
    data class OnAddChildPhoto(val imageURI: Uri, val child: Child): AddChildEvent()
}
