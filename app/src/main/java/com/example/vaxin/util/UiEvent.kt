package com.example.vaxin.util

/*
* Handle events originated by view model to update UI.
* These close the loop with user-originated events,
* where user takes action on the screen, and include:
* 1. Navigate away with "one-way ticket"
* 2. Navigate to destination page
* 3. Show a message in snackbar with optional action
* Note:
* 1. This event class scales for the needs of multiple screens.
* 2. Implement a listener to customize handling in the root composable's launched effect.
* */
sealed class UiEvent {
    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackbar(
        val message: String,
        val actionLabel: String?
    ): UiEvent()
}
