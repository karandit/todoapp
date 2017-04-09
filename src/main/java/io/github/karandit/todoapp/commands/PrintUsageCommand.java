package io.github.karandit.todoapp.commands;

import static java.lang.System.out;

import java.util.List;
import java.util.Map;

public class PrintUsageCommand extends Command {

	private Map<String, Command> commands;

	public PrintUsageCommand(Map<String, Command> commands) {
		super("Prints all available commands (this list)");
		this.commands = commands;
	}
	
	@Override
	public void run(List<String> args) {
		out.println("Yet Another Awesome Todo application");
		out.println("=======================");
		out.println("Command line arguments:");

		for(Map.Entry<String, Command> entry : commands.entrySet()) {
			out.println(" " + entry.getKey() + " " + entry.getValue().getDescription());
		}
	}

}
