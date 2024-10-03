package com.example.todoapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.todoapp.R
import com.example.todoapp.Screen
import com.example.todoapp.database.AssignmentViewModel
import com.example.todoapp.database.Item
import com.example.todoapp.database.Items

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: AssignmentViewModel
) {
    var checked by remember { mutableStateOf(false) }
    //val items=viewModel.getAllAss.collectAsState(initial = listOf())
    var visibility by remember { mutableStateOf(true) }
    val items=Item


    Scaffold(containerColor = Color(0xF7F6F2FF),
        topBar = {
        TopAppBar(title = { Text(text = "Мои дела", fontSize = 38.sp, fontWeight = FontWeight.Bold) },
             actions = {
                if (visibility) {
                    IconButton(onClick = {
                        visibility = !visibility
                    }) {
                        Icon(painter = painterResource(id = R.drawable.visibility), contentDescription = null)
                    }
                } else {
                    IconButton(onClick = {
                        visibility = !visibility
                    }) {
                        Icon(painter = painterResource(id = R.drawable.visibility_off), contentDescription = null)
                    }
                }
            })
    }, floatingActionButton = {
        FloatingActionButton(shape = CircleShape, containerColor = Color.Blue, contentColor = Color.White,onClick = {navController.navigate(Screen.addScreen.route)}, content={Icon(imageVector = Icons.Default.Add, contentDescription = null)})
    }) {
        Surface(modifier = Modifier.fillMaxWidth().padding(8.dp),
            color= MaterialTheme.colorScheme.onSecondary,
            shape = RoundedCornerShape(8.dp)
        ) {
            LazyColumn (modifier = Modifier.fillMaxSize().padding(it) ) {
                items(items
                    //.value
                ) { item ->
                    if (item.isVisible || !visibility) {
                        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Row(modifier = Modifier.widthIn(max = 300.dp)) {
                                Checkbox(checked = !item.isVisible, onCheckedChange = {
                                    item.isVisible = !it
                                    checked = it
                                })
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = item.doing, maxLines = 3)
                            }

                            Icon(imageVector = Icons.Default.Info, contentDescription = null)
                        }
                    }
                }
            }
        }
    }
}
