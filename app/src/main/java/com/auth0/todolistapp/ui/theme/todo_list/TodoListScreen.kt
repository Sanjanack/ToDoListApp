package com.auth0.todolistapp.ui.theme.todo_list

//import android.annotation.SuppressLint
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.SnackbarResult
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.collectAsState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import com.auth0.todolistapp.util.UiEvent
//
//private val Any.snackbarHostState: Any
//    get() {
//        TODO("Not yet implemented")
//    }
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun TodoListScreen(
//    onNavigate: (UiEvent.Navigate) -> Unit,
//    viewModel: TodoListViewModel<Any?, Any?, Any?> = hiltViewModel()
//) {
//    val todos = viewModel.todos.collectAsState(initial = emptyList())
//    val scaffoldState = rememberScaffoldState()
//    LaunchedEffect(key1 = true) {
//        viewModel.uiEvent.collect { event ->
//            when(event) {
//                is UiEvent.ShowSnackbar -> {
//                    val result = scaffoldState.snackbarHostState.showSnackbar(
//                        message = event.message,
//                        actionLabel = event.action
//                    )
//                    if(result == SnackbarResult.ActionPerformed) {
//                        viewModel.onEvent(TodoListEvent.OnUndoDeleteClick)
//                    }
//                }
//                is UiEvent.Navigate -> onNavigate(event)
//                else -> Unit
//            }
//        }
//    }
//    Scaffold(
////        scaffoldState = scaffoldState,
//        floatingActionButton = {
//            FloatingActionButton(onClick = {
//                viewModel.onEvent(TodoListEvent.OnAddTodoClick)
//            }) {
//                Icon(
//                    imageVector = Icons.Default.Add,
//                    contentDescription = "Add"
//                )
//            }
//        }
//    ) {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(todos.value) { todo ->
//                TodoItem(
//                    todo = todo,
//                    onEvent = viewModel::onEvent,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .clickable {
//                            viewModel.onEvent(TodoListEvent.OnTodoClick(todo))
//                        }
//                        .padding(16.dp)
//                )
//            }
//        }
//    }
//}
//
//private fun Any.showSnackbar(message: String, actionLabel: String?) {
//}
//
//fun rememberScaffoldState() {
//}



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.auth0.todolistapp.util.UiEvent
import com.plcoding.mvvmtodoapp.util.UiEvent
import kotlinx.coroutines.flow.collect

private val Any.snackbarHostState: Any
    get() {
        TODO("Not yet implemented")
    }

@Composable
fun TodoListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TodoListViewModel = hiltViewModel()
) {
    val todos = viewModel.todos.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.ShowSnackbar -> {
                    val result = scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                    if(result == SnackbarResult.ActionPerformed) {
                        viewModel.onEvent(TodoListEvent.OnUndoDeleteClick)
                    }
                }
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Scaffold(
//        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(TodoListEvent.OnAddTodoClick)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(todos.value) { todo ->
                TodoItem(
                    todo = todo,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.onEvent(TodoListEvent.OnTodoClick(todo))
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}

private fun Any.showSnackbar(message: String, actionLabel: String?): Any {
    TODO("Not yet implemented")
}

fun rememberScaffoldState(): Any {
    TODO("Not yet implemented")
}