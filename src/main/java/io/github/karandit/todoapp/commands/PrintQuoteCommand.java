package io.github.karandit.todoapp.commands;

import static java.lang.System.out;

import java.util.List;

public class PrintQuoteCommand implements Command {

	@Override
	public void run(List<String> args) {
		out.println("TADA");
	}

}
