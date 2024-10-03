package com.example.todoapp.ui.theme

import android.icu.util.Calendar
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todoapp.database.Assignment
import com.example.todoapp.database.AssignmentViewModel
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun AddEditScreen(
    viewModel: AssignmentViewModel
){
    var assImportance by remember { mutableStateOf("Нет") }
    var expanded by remember { mutableStateOf(false) }
    val items= arrayOf("Нет","Низкий","!!Высокий")
    val doings= remember { mutableStateOf("") }
    Column {
        Row(modifier = Modifier.height(56.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {

            }){
                Icon(imageVector = Icons.Default.Close, contentDescription = null)
            }
            TextButton(onClick = {
                viewModel.insertAss(Assignment(0, doings.value, true))
                
            }){
                Text("Сохранить")
            }
        }
        OutlinedTextField(modifier = Modifier.padding(16.dp).fillMaxWidth().height(104.dp), shape = RoundedCornerShape(8.dp), maxLines = 3, value=viewModel.doing, onValueChange = { viewModel.updateDoing(it) }, label = {Text("Что надо сделать...")})
        Column(modifier = Modifier.fillMaxWidth().height(72.dp).padding(16.dp)) {
            Text("Важность", fontSize = 20.sp, fontWeight = FontWeight.Bold )
            Text(text = assImportance, modifier = Modifier.clickable{expanded=true}, fontSize = 14.sp, color = Color.Gray)
            if(expanded){
                Card(modifier = Modifier.padding(8.dp), shape = RoundedCornerShape(8.dp)){
                    DropdownMenu(expanded = expanded, onDismissRequest = {expanded=false}){
                        items.forEach { item->
                            DropdownMenuItem(text={Text(item)}, onClick = {
                                assImportance=item
                            })

                        }
                    }
                }
            }
        }
        Divider(thickness = 1.dp, color = Color.Black, modifier = Modifier.padding(horizontal = 16.dp))
        ShowCalendar()
        Spacer(modifier = Modifier.height(24.dp))
        Divider(thickness = 1.dp, color = Color.Black)
        Row(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = if(viewModel.doing.isBlank()){Color.Gray}else{Color.Red})
            Spacer(modifier = Modifier.width(4.dp))
            Text("Удалить", fontSize = 20.sp, color = if(viewModel.doing.isBlank()){Color.Gray}else{Color.Red})
        }


    }



}


@Composable
fun ShowCalendar(){
    val calendar=Calendar.getInstance()
    val context= LocalContext.current
    var selectedDate by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    val datePickerDialog= android.app.DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            calendar.set(year, month, dayOfMonth)
            val dateFormat= SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            selectedDate = dateFormat.format(calendar.time)},
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Row(modifier = Modifier.padding(16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text("Сделать до", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            if(checked){
                Text(selectedDate, color = Color.Blue, fontSize = 14.sp)
            }
        }

        Switch(checked=checked, onCheckedChange = {checked=it
            if(checked) {
                datePickerDialog.show()
            }}
        )

    }
}