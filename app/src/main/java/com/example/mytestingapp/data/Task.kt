package com.example.mytestingapp.data

import java.util.*

data class Task @JvmOverloads constructor(
  var title: String = "",
  var description: String = "",
  var isCompleted: Boolean = false,
  var id: String = UUID.randomUUID().toString()
) {
  val isActive
    get() = !isCompleted

  val isEmpty
    get() = title.isEmpty() || description.isEmpty()

  val titleForList: String
    get() = if (title.isNotEmpty()) title else description
}