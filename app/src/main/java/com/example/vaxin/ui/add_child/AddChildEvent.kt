package com.example.vaxin.ui.add_child

import com.example.vaxin.data.Child

sealed class AddChildEvent {
    data class OnChildSelected(val child: Child): AddChildEvent()
    data class OnChildNameChange(val childName: String): AddChildEvent()
    data class OnChildBirthDateChange(val birthdate: String): AddChildEvent()
    object OnAddChild: AddChildEvent()
}
