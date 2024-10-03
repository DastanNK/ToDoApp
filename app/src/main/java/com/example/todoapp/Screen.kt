package com.example.todoapp

sealed class Screen(val route:String) {
    object mainScreen:Screen("mainscreen")
    object addScreen:Screen("addscreen")
}