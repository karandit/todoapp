package io.github.karandit.todoapp.commands;

import io.github.karandit.todoapp.Task;

import java.util.List;

public class AddTaskCommand extends TaskCommand {

	public AddTaskCommand() {
		super("Adds a task");
	}

	@Override
	protected List<Task> processTasks(List<String> args, List<Task> tasks) {
		if (args.isEmpty()) {
			System.out.println("Unable to add: no task provided");
			return tasks;
		} else if (args.size() == 1) {
			tasks.add(new Task(args.get(0), false));
			return tasks;
		} else{ 
			System.out.println("Too many arguments!");		
			return tasks;
		}
	}


}
