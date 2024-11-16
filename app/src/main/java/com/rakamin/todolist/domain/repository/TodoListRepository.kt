package com.rakamin.todolist.domain.repository

import com.rakamin.todolist.domain.model.TodoList

interface TodoListRepository {
    suspend fun getList(): List<TodoList>
    suspend fun insertTodoList(todoList: TodoList)
    suspend fun deleteTodoList(todoList: TodoList)
}
