package com.task_tracker.main.task;

import java.util.Scanner;

public class InputOperations {
	
	static Scanner scan = new Scanner(System.in);
	static TaskOperations operator = new TaskOperations();
	
	public static void start() {
		while(true) {
			System.out.print("Task-tracker-CLI ");
			String input = input().toLowerCase();
			switch(input) {
			case "add": addInput();
			         break;
			case "update": updateInput();
			         break;
			case "delete": deleteInput();
			         break;
			case "mark": markInput();
			         break;
			case "view": viewInput();
			         break;
			case "viewall": operator.viewAll();
			         break;
			case "exit": System.exit(0);
			         break;
			default : System.out.println("Use correct keyworks\n Keyword List : add , update , delete etc,.");
			}
			
		}
	}
	
	private static void markInput() {
		System.out.print("Task ID : ");
		int id = scan.nextInt();
		System.out.print("Status : ");
		String status = scan.next().toLowerCase();
		switch(status){
		case "in-progress": operator.inProgress(id);
		          break;   
		case "done": operator.done(id);
                  break;   
        default : System.out.println("\u001B[31m"+"---- Invaild Status code ----"+"\u001B[0m");
		}
	}

	private static void viewInput() {
		System.out.print("Task ID : ");
		int id = scan.nextInt();
		operator.view(id);		
	}

	private static void deleteInput() {
		System.out.print("Task ID : ");
		int id = scan.nextInt();
		operator.delete(id);
	}

	private static void updateInput() {
		System.out.print("Task ID : ");
		int id = scan.nextInt();
		scan.nextLine();
		System.out.print("New Description : ");
		String desc = scan.nextLine();
		operator.update(id, desc);
	}

	private static void addInput() {
		scan.nextLine();
		System.out.print("Task Description : ");
		String desc = scan.nextLine();
		operator.add(desc);				
	}

	private static String input(){
		String input = scan.next(); 
		return input;
	}
}

