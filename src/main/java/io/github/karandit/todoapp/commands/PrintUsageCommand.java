package io.github.karandit.todoapp.commands;

import static java.lang.System.out;

import java.util.List;

public class PrintUsageCommand implements Command {

	@Override
	public void run(List<String> args) {
		out.println("Yet Another Awesome Todo application");
		out.println("=======================");
		out.println("Command line arguments:");
		out.println(" -l   Lists all the tasks");
		out.println(" -a   Adds a new task");
		out.println(" -r   Removes a task");
		out.println(" -c   Completes a task");
		out.println(" -u   Uncompletes a task");
	}

}
