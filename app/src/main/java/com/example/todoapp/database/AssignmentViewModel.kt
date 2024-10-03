package com.example.todoapp.database

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.database.graph.assignmentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class AssignmentViewModel(private val assignmentRepository: AssignmentRepository = graph.assignmentRepository):ViewModel() {
    var doing by mutableStateOf("")

    fun updateDoing(newDoing:String){
        doing=newDoing
    }


    fun deleteAss(assignment: Assignment){
        viewModelScope.launch(Dispatchers.IO) {
            assignmentRepository.deleteRepositoryAssignment(assignment)
        }
    }
    fun updateAss(assignment: Assignment){
        viewModelScope.launch(Dispatchers.IO) {
            assignmentRepository.updateRepositoryAssignment(assignment)
        }
    }
    fun insertAss(assignment: Assignment){
        viewModelScope.launch(Dispatchers.IO)  {
            assignmentRepository.insertRepositoryAssignment(assignment)
        }
    }
    lateinit var getAllAss : Flow<List<Assignment>>
    init{
        viewModelScope.launch {
            getAllAss=assignmentRepository.getRepositoryAllAssignment
        }
    }

    fun getAss(id:Int):Flow<Assignment>{
        return assignmentRepository.getRepositoryAssignment(id)
    }


}