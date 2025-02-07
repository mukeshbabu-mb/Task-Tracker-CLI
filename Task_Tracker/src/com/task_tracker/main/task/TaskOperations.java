package com.task_tracker.main.task;

public class TaskOperations extends Database {
	//Color Properties 
	private static String END = "\u001B[0m";
	private static String RED = "\u001B[31m";
	private static String GREEN = "\u001B[32m";
	
	//Store Task Id Generated Value
	private static int TASK_ID_GENERATOR = 0;

	// Task ADD Function
	public void add(String description) {
		int id = ++TASK_ID_GENERATOR;
		tasks.add(new Task(id,description));
		System.out.println(GREEN+"Task added Successfully ID : "+id+END);
	}

	// Task Update Function 
	public void update(int id, String description) {
		Task task = findTask(id);
		if(task!=null) {
			task.setDescription(description);
			System.out.println(GREEN+"---- Task Id "+id+" Updated Successfully ----"+END);
		}else {
			System.out.println(RED+"---- Task Id "+id+" Not Found ----"+END);
		}
	}

	
	// Task Delete Function
	public void delete(int id) {
		Task task = findTask(id);
		tasks.remove(task);
		if(task!=null) {
			System.out.println(GREEN+"Task Id "+id+"---- Deleted Successfully ----"+END);
		}else {
			System.out.println(RED+"---- Task Id "+id+" Not Found ----"+END);
		}
	}
	
	//Display All Task
	public void viewAll() {
		System.out.println(GREEN+"=============================================="+END);
		for(Task task : tasks) {
			System.out.println(task.toString());
			System.out.println(GREEN+"=============================================="+END);
		}
	}
	
	//Display Task by Id
	public void view(int id) {
		Task task = findTask(id);
		if(task!=null) {
			System.out.println(GREEN+"=============================================="+END);
			System.out.println(task.toString());
			System.out.println(GREEN+"=============================================="+END);
		}else {
			System.out.println(RED+"---- Task Id "+id+" Not Found ----"+END);
		}
	}
	
	//Mark a Task In-Progress
	public void inProgress(int id) {
		Task task = findTask(id);
		task.setStatus("IN-PROGRESS");
		System.out.println(GREEN+"---- Status Updated Successfully ----"+END);
	}
	
	//Mark a Task Done
	public void done(int id) {
		Task task = findTask(id);
		task.setStatus("DONE");
		System.out.println(GREEN+"---- Status Updated Successfully ----"+END);
	}
	
	// Find Task In Tasks List by Id Function
	private Task findTask(int id) {
		for(Task task : tasks) {
			if(task.getId() == id) return task;
		} 
		return null;
	}
}
