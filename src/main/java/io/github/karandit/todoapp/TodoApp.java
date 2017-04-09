package io.github.karandit.todoapp;

import static java.util.Collections.emptyList;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import io.github.karandit.todoapp.commands.AddTaskCommand;
import io.github.karandit.todoapp.commands.Command;
import io.github.karandit.todoapp.commands.PrintQuoteCommand;
import io.github.karandit.todoapp.commands.PrintTasksCommand;
import io.github.karandit.todoapp.commands.RemoveTaskCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TodoApp {
	
	public static void main(String[] argsArr) {
		List<String> args = Arrays.<String>asList(argsArr);
		Optional<String> firstArg = args.isEmpty() ? empty() : of(args.get(0));
		List<String> extraArgs = args.isEmpty() ? emptyList() : args.subList(1, args.size());

		Command cmd = getCommand(firstArg);
		cmd.run(extraArgs);
	}

	private static Command getCommand(Optional<String> firstArg) {
		return new ArgHandler()
			.registerCommand("-l", new PrintTasksCommand())
			.registerCommand("-a", new AddTaskCommand())
			.registerCommand("-r", new RemoveTaskCommand())
			.registerCommand("-m", new PrintQuoteCommand())
			.getCommand(firstArg);
	}
}
