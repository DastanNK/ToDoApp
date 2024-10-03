package com.example.todoapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Assignment_table")
data class Assignment(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "doing_column")
    val doing:String,
    @ColumnInfo(name = "is_visible_column")
    var isVisible:Boolean
)
