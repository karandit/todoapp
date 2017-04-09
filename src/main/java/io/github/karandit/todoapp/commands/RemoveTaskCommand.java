package io.github.karandit.todoapp.commands;

import io.github.karandit.todoapp.Task;

import java.util.List;

public class RemoveTaskCommand extends TaskCommand {

	public RemoveTaskCommand() {
		super("Removes a task");
	}

	@Override
	protected List<Task> processTasks(List<String> args, List<Task> tasks) {
		if (args.isEmpty()) {
			System.out.println("Unable to remove: no task provided");
			return tasks;
		} else if (args.size() == 1) {
			try {
		       removeTask(tasks, Integer.valueOf(args.get(0)));
		    } catch (NumberFormatException e) {
		       System.out.println("Unable to remove: index is not a number");
		    }	
			return tasks;
		} else { 
			System.out.println("Too many arguments!");		
			return tasks;
		}
	}

	private static void removeTask(List<Task> tasks, int index) {
	    if (index > tasks.size()) {
	      System.out.println("Unable to remove: index is out of bound");
	      return;
	    }
	    tasks.remove(index - 1);
	}

}
