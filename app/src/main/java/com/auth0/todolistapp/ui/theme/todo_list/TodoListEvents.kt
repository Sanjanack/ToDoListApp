package com.auth0.todolistapp.ui.theme.todo_list


import com.auth0.todolistapp.data.Todo

sealed class TodoListEvent {
    data class OnDeleteTodoClick(val todo: Todo): TodoListEvent()
    data class OnDoneChange(val todo: Todo, val isDone: Boolean): TodoListEvent()
    object OnUndoDeleteClick: TodoListEvent()
    data class OnTodoClick(val todo: Int): TodoListEvent()
    object OnAddTodoClick: TodoListEvent()
}