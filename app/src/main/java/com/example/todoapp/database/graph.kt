package com.example.todoapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object graph{
    lateinit var newDatabase:database

    val assignmentRepository by lazy {
        AssignmentRepository(newDatabase.getAssignmentDao())
    }
    fun provide(context: Context){
        newDatabase= Room.databaseBuilder(context, database::class.java,"assignment.db").createFromAsset("database/Assignment_table.db").build()
    }
}