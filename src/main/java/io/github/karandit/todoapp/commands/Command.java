package io.github.karandit.todoapp.commands;

import java.util.List;

public interface Command {

	void run(List<String> args);

}
