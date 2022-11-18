package com.example.mytestingapp.ui.others

class ViewModelA(val repository: TaskRepository) {

  fun getTasksFromRepo() = repository.getTasks()


}