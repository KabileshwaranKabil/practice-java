/**
 * Task
 * Fields: description (String), completed (boolean)
 * Methods: constructor , markAsCompleted() , isCompleted() , toString() 
 * 
 * @see TodoService
 * @author M.Kabileshwaran.
 * */
package com.kabilesh.todoapp;
class Task{
	private String description;
	private boolean completed;
	Task(String description){
		this.description=description;
		this.completed=false; // let's set default value to false (pending)
	}
	// markAsCompleted
	public void markAsCompleted(){
		this.completed=true;
	}
	// isCompleted
	public boolean isCompleted(){
		return completed;
	}
	@Override
	public String toString(){
		String status = completed?"Completed":"Pending";
		return description + "["+status+"]";
	}
}
