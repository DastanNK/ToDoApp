package com.example.todoapp.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AssignmentDao  {
    @Delete
    abstract  fun deleteAssignment(assignment: Assignment)

    @Update
    abstract  fun updateAssignment(assignment: Assignment)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract  fun insertAssignment(assignment: Assignment)

    @Query("Select * from 'Assignment_table'")
    abstract fun getAllAssignment(): Flow<List<Assignment>>

    @Query("Select * from 'Assignment_table' where id=:id")
    abstract fun getAssignment(id: Int):Flow<Assignment>

}