# Java CLI To-Do List Application

## Problem Statement
You are required to design and implement a **Command Line Interface (CLI) To-Do List application in Java**. This program allows a user to manage a list of tasks entirely in the terminal. Each task has a **description** (text) and a **status** which is either `Pending` or `Completed`.
The program should **continuously display a menu**, accept user input, and perform actions until the user chooses to exit. Users should be able to **add, view, complete, and delete tasks** in a simple, interactive way.

## Functional Requirements
The program must implement the following operations:
1. **Add Task**
   * Accept a string description from the user.
   * Create a new task with status `Pending` and add it to the list.
   * Provide a confirmation message like “Task added successfully.”

2. **View Tasks**
   * Display all tasks in the list.
   * Each task should show:
     * Task number (starting from 1)
     * Task description
     * Task status (`Pending` or `Completed`)
   * Format example: `1. Learn Java [Pending]`
   * If the list is empty, display: “No tasks available.”

3. **Mark Task as Completed**
   * Accept a task number from the user.
   * Update the corresponding task’s status to `Completed`.
   * Display confirmation: “Task marked as completed.”
   * If the task number is invalid, display: “Invalid task number.”

4. **Delete Task**
   * Accept a task number from the user.
   * Remove the corresponding task from the list.
   * Display confirmation: “Task deleted successfully.”
   * If the task number is invalid, display: “Invalid task number.”

5. **Exit**
   * Terminate the program with a friendly message: “Exiting To-Do List application. Goodbye!”

## Input Format
* Menu choices are selected by entering integers (`1`–`5`).
* Task descriptions are entered as strings.
* Task selection for completing or deleting is **1-based indexing** (user sees 1, 2, 3…).
* Input is read from the console using a `Scanner`.

## Output Format
* Display a menu before every operation.
* Display confirmation messages after adding, completing, or deleting a task.
* Display the full task list when viewing tasks.
* Display user-friendly error messages for invalid input.
* Keep output clean and readable for the user.

## Example Console Interactions

### Case 1: Viewing tasks when the list is empty

**Input:**
```
2
```

**Output:**
```
No tasks available.
```

### Case 2: Adding a task
**Input:**

```
1
Learn Java OOP
```

**Output:**
```
Task added successfully.
```

### Case 3: Adding multiple tasks

**Input:**

```
1
Learn Arrays
1
Solve Prefix Sum Problems
```
**Output:**

```
Task added successfully.
Task added successfully.
```

### Case 4: Viewing tasks after adding
**Input:**

```
2
```

**Output:**
```
Your Tasks:
1. Learn Arrays [Pending]
2. Solve Prefix Sum Problems [Pending]
```

### Case 5: Marking a task as completed

**Input:**

```
3
1
```

**Output:**

```
Task marked as completed.
```

### Case 6: Viewing tasks after marking completion

**Input:**

```
2
```

**Output:**

```
Your Tasks:
1. Learn Arrays [Completed]
2. Solve Prefix Sum Problems [Pending]
```

### Case 7: Deleting a task

**Input:**

```
4
2
```

**Output:**

```
Task deleted successfully.
```

### Case 8: Viewing tasks after deletion

**Input:**

```
2
```

**Output:**

```
Your Tasks:
1. Learn Arrays [Completed]
```

### Case 9: Invalid task number

**Input:**

```
3
5
```

**Output:**

```
Invalid task number.
```

### Case 10: Invalid menu choice

**Input:**

```
9
```

**Output:**

```
Invalid choice. Please select a valid option.
```

### Case 11: Exiting program

**Input:**

```
5
```

**Output:**

```
Exiting To-Do List application. Goodbye!
```

## Constraints & Notes

* Tasks are stored in memory only using an `ArrayList<Task>`; no database or file storage is required.
* Internally, 0-based indexing is fine, but users see 1-based numbering.
* The program must **not crash** on invalid input.
* Only standard Java libraries may be used.
* Validation is important:
  * Task description cannot be empty.
  * Task number must exist before completing or deleting.

This project teaches:

* Core Java programming and syntax
* Object-Oriented Programming with classes, objects, and encapsulation
* CLI application design and user input handling
* Collections (`ArrayList`) usage
* Separation of logic and UI
* Clean code practices suitable for real-world applications
