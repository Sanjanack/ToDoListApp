package com.auth0.todolistapp.ui.theme.add_edit_todo

import androidx.compose.foundation.layout.PaddingValues

sealed class AddEditTodoEvent {
    data class OnTitleChange(val title: PaddingValues): AddEditTodoEvent()
    data class OnDescriptionChange(val description: PaddingValues): AddEditTodoEvent()
    object OnSaveTodoClick: AddEditTodoEvent()
}