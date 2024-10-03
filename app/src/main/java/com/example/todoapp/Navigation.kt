package com.example.todoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.database.AssignmentViewModel
import com.example.todoapp.ui.theme.AddEditScreen
import com.example.todoapp.ui.theme.MainScreen
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Navigation(navController: NavHostController= rememberNavController(), viewModel:AssignmentViewModel = viewModel()){
    NavHost(navController = navController, startDestination = Screen.mainScreen.route){
        composable(route = Screen.mainScreen.route) {
            MainScreen(navController, viewModel)
        }
        composable(route = Screen.addScreen.route){
            AddEditScreen(viewModel = viewModel)
        }
    }

}