package com.rakamin.todolist.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.rakamin.todolist.domain.model.TodoList
import com.rakamin.todolist.domain.repository.TodoListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val repository: TodoListRepository
): ViewModel() {
    private var _todoList = MutableStateFlow<List<TodoList>>(listOf())
    val getTodoList = _todoList.asLiveData()
    fun setTodoList() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getList().collectLatest {
                _todoList.value = it
            }
        }
    }
    
    fun insertTodoList(todoList: TodoList) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTodoList(todoList)
        }
    }
    
    fun deleteTodoList(todoList: TodoList) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTodoList(todoList)
        }
    }
}
