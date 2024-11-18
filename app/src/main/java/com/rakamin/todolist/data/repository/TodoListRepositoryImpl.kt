package com.rakamin.todolist.data.repository

import com.rakamin.todolist.data.datasource.TodoListDao
import com.rakamin.todolist.domain.model.TodoList
import com.rakamin.todolist.domain.repository.TodoListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoListRepositoryImpl @Inject constructor(
    private val dao: TodoListDao,
): TodoListRepository {
    override suspend fun getList(): Flow<List<TodoList>> {
        return dao.getAllTodoList()
    }

    override suspend fun insertTodoList(todoList: TodoList) {
        dao.insertTodoList(todoList)
    }

    override suspend fun deleteTodoList(todoList: TodoList) {
        dao.deleteTodoList(todoList)
    }


}
