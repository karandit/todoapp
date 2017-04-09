package io.github.karandit.todoapp.commands;

import static java.lang.System.out;

import java.util.List;

public class PrintQuoteCommand extends Command {

	public PrintQuoteCommand() {
		super("Prints a motivational quote");
	}

	@Override
	public void run(List<String> args) {
		out.println("TADA");
	}

}
