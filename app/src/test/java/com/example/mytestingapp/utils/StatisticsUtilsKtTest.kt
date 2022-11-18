package com.example.mytestingapp.utils

import com.example.mytestingapp.data.Task
import org.junit.Assert.assertEquals
import org.junit.Test


class StatisticsUtilsKtTest {

  @Test
  fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
    // Create an active task
    val tasks = listOf(
      Task("title", "desc", isCompleted = false)
    )
    // Call your function
    val result = getActiveAndCompletedStats(tasks)

    // Check the result
    assertEquals(result.completedTasksPercent, 0f)
    assertEquals(result.activeTasksPercent, 100f)
  }

  @Test
  fun getActiveAndCompletedStats_completed_returnsHundredZero() {
    // Create an active task
    val tasks = listOf(
      Task("title", "desc", isCompleted = true)
    )
    // Call your function
    val result = getActiveAndCompletedStats(tasks)

    // Check the result
    assertEquals("not following", result.completedTasksPercent, 100f)
    assertEquals(result.activeTasksPercent, 0f)
  }

  @Test
  fun getActiveAndCompletedStats_partial_completed_returnsHundredZero() {
    // Create an active task
    val tasks = listOf(
      Task("title", "desc", isCompleted = true),
      Task("title", "desc", isCompleted = false),
      Task("title", "desc", isCompleted = false),
      Task("title", "desc", isCompleted = true),
    )
    // Call your function
    val result = getActiveAndCompletedStats(tasks)

    // Check the result
    assertEquals(result.completedTasksPercent, 50f)
    assertEquals(result.activeTasksPercent, 50f)
  }

  @Test
  fun `test when title is empty`() {
    // Create an active task
    val tasks = listOf(
      Task("", "desc", isCompleted = true),
    )
    // Check the result
    assertEquals(tasks.first().titleForList, tasks.first().description)
  }

  @Test
  fun `test when title is NOT empty`() {
    // Create an active task
    val tasks = listOf(
      Task("title", "desc", isCompleted = true),
    )
    // Check the result
    assertEquals(tasks.first().titleForList, tasks.first().title)
  }

  @Test
  fun `test when title and description is empty`() {
    // Create an active task
    val tasks = listOf(
      Task("", "", isCompleted = true),
    )
    // Check the result
    assertEquals(tasks.first().isEmpty, true)
  }

  @Test
  fun `test when title and description is not empty`() {
    // Create an active task
    val tasks = listOf(
      Task("title", "desc", isCompleted = true),
    )
    // Check the result
    assertEquals(tasks.first().isEmpty, false)
  }

  @Test
  fun `test when title is empty and description is not empty`() {
    // Create an active task
    val tasks = listOf(
      Task("", "desc", isCompleted = true),
    )
    // Check the result
    assertEquals(tasks.first().isEmpty, true)
  }

  @Test
  fun `test when title is not empty and description is empty`() {
    // Create an active task
    val tasks = listOf(
      Task("", "desc", isCompleted = true),
    )
    // Check the result
    assertEquals(tasks.first().isEmpty, true)
  }
}