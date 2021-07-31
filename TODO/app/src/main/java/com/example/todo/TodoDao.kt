package com.example.todo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todoModel: TodoModel) : Long
    //show all task
    @Query("Select * from TodoModel where isFinished != -1")
    fun getTask() : LiveData<List<TodoModel>>

    //update task on left swipe
    @Query("Update TodoModel set isFinished =1 where id=:uid")
    fun finishTask(uid : Long)

    //delete task when completed
    @Query("delete from TodoModel where id=:uid")
    fun deleteTask(uid : Long)
}