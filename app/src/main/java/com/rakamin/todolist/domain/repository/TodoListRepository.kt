package com.rakamin.todolist.domain.repository

import com.rakamin.todolist.domain.model.TodoList
import kotlinx.coroutines.flow.Flow

interface TodoListRepository {
    suspend fun getList(): Flow<List<TodoList>>
    suspend fun insertTodoList(todoList: TodoList)
    suspend fun deleteTodoList(todoList: TodoList)
}
