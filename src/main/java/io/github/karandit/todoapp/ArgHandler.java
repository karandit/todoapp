package io.github.karandit.todoapp;

import io.github.karandit.todoapp.commands.Command;
import io.github.karandit.todoapp.commands.PrintUsageCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ArgHandler {

	private final Command printUsageCommand;

	private final Map<String, Command> commands = new HashMap<>();
	
	public ArgHandler() {
		printUsageCommand = new PrintUsageCommand(commands);
		commands.put("-h", printUsageCommand);
	}

	public ArgHandler registerCommand(final String flag, final Command cmd) {
		commands.put(flag, cmd);
		return this;
	}

	public Command getCommand(Optional<String> firstArg) {
		if (!firstArg.isPresent()) {
			return printUsageCommand;
		}
		return commands.getOrDefault(firstArg.get(), printUsageCommand);
	}
	
}
