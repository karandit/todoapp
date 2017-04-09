package io.github.karandit.todoapp.commands;

import java.util.List;

public abstract class Command {

	private final String description;

	public Command(final String description) {
		this.description = description;
	}
	
	public abstract void run(List<String> args);

	public String getDescription() {
		return description;
	}

}
