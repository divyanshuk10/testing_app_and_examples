package com.example.mytestingapp.utils

import com.example.mytestingapp.data.Task

object Data {

  fun fetchTasksList(): List<Task> = listOf(
    Task("Task 1", "Desc 1", true),
    Task("Task 2", "Desc 2", true),
    Task("Task 3", "Desc 3", false),
    Task("Task 4", "Desc 4", true),
    Task("Task 5", "Desc 5", true),
    Task("Task 6", "Desc 6", false),
    Task("Task 7", "Desc 7", false),
  )
}