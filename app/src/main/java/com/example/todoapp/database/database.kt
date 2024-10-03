package com.example.todoapp.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Assignment::class],
    version = 1,
    exportSchema = false)
abstract class database:RoomDatabase() {
    abstract fun getAssignmentDao():AssignmentDao
}