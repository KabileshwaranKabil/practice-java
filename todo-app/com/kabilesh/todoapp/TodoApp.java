/**
 * TodoApp
 * Display menu
 * read user input
 * call TodoService methods
 * 
 * @author M.Kabileshwaran
 * */
 package com.kabilesh.todoapp;
 import java.util.Scanner;
 public class TodoApp{
 	public static void main(String[] args){
 		Scanner input=new Scanner(System.in);
 		TodoService service = new TodoService();
 		while(true){
	 		System.out.println("***** TO-DO LIST MENU *****");
	 		System.out.println("\t1. Add Tasks");
	 		System.out.println("\t2. View Tasks");
	 		System.out.println("\t3. Mark Task as Completed");
	 		System.out.println("\t4. Delete Task");
	 		System.out.println("\t5. Exit");
	 		System.out.print("Enter your choice: ");
	 		int userChoice = input.nextInt();
	 		input.nextLine(); // clear buffer : for detail see description of this video
	 		switch(userChoice){
		 		case 1:
		 			System.out.print("Enter task description: ");
		 			String desc=input.nextLine();
		 			service.addTask(desc);
		 			System.out.println("Tasks Added Successfully.");
		 			break;
		 		case 2:
		 			service.viewTasks();
		 			break;
		 		case 3:
		 			System.out.print("Enter task Number: ");
		 			int completedTask=input.nextInt();
		 			if(service.completeTask(completedTask)){
		 				System.out.println("Task marked Completed");
		 			}else{
		 				System.out.println("Invalid Task Number");
		 			}
		 			break;
		 		case 4:
		 			System.out.print("Enter task Number: ");
		 			int deleteTask=input.nextInt();
		 			if(service.deleteTask(deleteTask)){
		 				System.out.println("Task deleted successfully.");
		 			}else{
		 				System.out.println("Invalid Task Number");
		 			}
		 			break;
		 		case 5:
		 			System.out.println("Existing...");
		 			System.out.println("Thank you for watching..🙏");
		 			System.out.println("Please Don't Forget to Subscribe!");
		 			input.close();
		 			return;
		 		default:
		 			System.out.println("Invalid choice.");
	 		}

 		}
 	}
 }