package io.github.karandit.todoapp;

import io.github.karandit.todoapp.commands.AddTaskCommand;
import io.github.karandit.todoapp.commands.Command;
import io.github.karandit.todoapp.commands.PrintQuoteCommand;
import io.github.karandit.todoapp.commands.PrintTasksCommand;
import io.github.karandit.todoapp.commands.PrintUsageCommand;
import io.github.karandit.todoapp.commands.RemoveTaskCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TodoApp {
	
	public static void main(String[] argsArr) {
		List<String> args = Arrays.<String>asList(argsArr);
		Optional<String> firstArg = args.isEmpty() ? Optional.empty() : Optional.of(args.get(0));
		List<String> extraArgs = args.subList(1, args.size());

		Command cmd = getCommand(firstArg);
		cmd.run(extraArgs);
	}

	private static Command getCommand(Optional<String> firstArg) {
		if (!firstArg.isPresent()) {
			return new PrintUsageCommand();
		}
		String flag = firstArg.get();
		switch (flag) {
			case "-l": 	return new PrintTasksCommand();
			case "-a": 	return new AddTaskCommand();
			case "-r": 	return new RemoveTaskCommand();
			case "-m": 	return new PrintQuoteCommand();
			case "-h":
			default: 	return new PrintUsageCommand();
		}
	}
}
