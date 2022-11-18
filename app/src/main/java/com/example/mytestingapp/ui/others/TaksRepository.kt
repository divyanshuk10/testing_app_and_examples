package com.example.mytestingapp.ui.others

import com.example.mytestingapp.utils.Data

object TaskRepository {

  fun getTasks() = Data.fetchTasksList()
}