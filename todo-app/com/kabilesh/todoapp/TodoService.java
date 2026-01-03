/**
 * TodoService 
 * Fields: ArrayList<Task> for storing tasks
 * Methods: addTask(), viewTasks(), completeTask(), deleteTask(), isEmpty()
 * 
 * @see TodoApp
 * @author M.Kabileshwaran
 * */
package com.kabilesh.todoapp;
import java.util.ArrayList;
class TodoService{
	private ArrayList<Task> tasks;
	TodoService(){
		this.tasks=new ArrayList<>();
	}
	// addTask
	public boolean addTask(String description){
		if(description==null || description.trim().isEmpty()){
			// this will checks whether description is empty.
			System.out.println("Description cannot be empty");
			return false;
		}
		tasks.add(new Task(description));
		return true; // successfully added task description.
	}
	// viewTasks
	public void viewTasks(){
		if(tasks.isEmpty()){
			System.out.println("No Tasks Available");
			return;
		}
		System.out.println("=== Tasks ===");
		for(int task=0;task<tasks.size();task++){
			System.out.println(String.format("%d.%s",task+1,tasks.get(task)));
		}
	}
	// completeTask
	public boolean completeTask(int taskNo){
		if(taskNo < 1 || taskNo >tasks.size()){
			return false;
		}
		tasks.get(taskNo-1).markAsCompleted();
		return true;
	}
	// deleteTask
	public boolean deleteTask(int taskNo){
		if(taskNo < 1 || taskNo >tasks.size()){
			return false;
		}
		tasks.remove(taskNo-1);
		return true;
	}
	// isEmpty
	public boolean isEmpty(){
		return tasks.isEmpty();
	}
}



