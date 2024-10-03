package com.example.todoapp

import android.app.Application
import com.example.todoapp.database.graph

class AssignmentApp: Application() {

    override fun onCreate() {
            super.onCreate()
            graph.provide(this)
    }

}