package com.rakamin.todolist.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rakamin.todolist.domain.model.TodoList
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoListDao {
    @Query("SELECT * FROM todo_list")
    suspend fun getAllTodoList(): Flow<List<TodoList>>
    
    @Insert
    suspend fun insertTodoList(todoList: TodoList)
    
    @Delete
    suspend fun deleteTodoList(todoList: TodoList)
}
