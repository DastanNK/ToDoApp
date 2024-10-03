package com.example.todoapp.database

import kotlinx.coroutines.flow.Flow

class AssignmentRepository(private val assignmentDao: AssignmentDao) {
    suspend fun deleteRepositoryAssignment(assignment: Assignment){
        assignmentDao.deleteAssignment(assignment)
    }
    suspend fun updateRepositoryAssignment(assignment: Assignment){
        assignmentDao.updateAssignment(assignment)
    }
    suspend fun insertRepositoryAssignment(assignment: Assignment){
        assignmentDao.insertAssignment(assignment)
    }
    val getRepositoryAllAssignment:Flow<List<Assignment>> = assignmentDao.getAllAssignment()

    fun getRepositoryAssignment(id:Int): Flow<Assignment> {
        return assignmentDao.getAssignment(id)
    }


}