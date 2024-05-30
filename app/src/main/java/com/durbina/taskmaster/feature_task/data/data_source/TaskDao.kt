package com.durbina.taskmaster.feature_task.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.durbina.taskmaster.feature_task.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getTasks(): Flow<List<Task>>

    @Upsert
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

}