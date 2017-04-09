package io.github.karandit.todoapp.commands;

import io.github.karandit.todoapp.Task;

import java.util.List;

public class PrintTasksCommand extends TaskCommand {

	public PrintTasksCommand() {
		super("Prints all todo tasks");
	}

	@Override
	protected List<Task> processTasks(List<String> args, List<Task> tasks) {
		if (tasks.isEmpty()) {
			System.out.println("No todos for today! :)");
		} else {
			int id = 1;
			for (Task task : tasks) {
				System.out.println(id++ + " " + task);
			}
		}
		return tasks;
	}

}
