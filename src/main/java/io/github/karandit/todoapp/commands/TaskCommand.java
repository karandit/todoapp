package io.github.karandit.todoapp.commands;

import io.github.karandit.todoapp.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public abstract class TaskCommand implements Command {

	private static final String PATH_TODO_MD = "todo.md";

	protected abstract List<Task> processTasks(List<String> args, List<Task> tasks);

	@Override
	public void run(List<String> args) {
		try {
			Path path = Paths.get(PATH_TODO_MD);
			List<String> lines = Files.readAllLines(path);
			List<Task> tasks = fromLinesToTasks(lines);
			processTasks(args, tasks);
			List<String> updatedLines = fromTasksToLines(tasks);
			Files.write(path, updatedLines);
		} catch (IOException e) {
			System.out.println("Something is wrong with " + PATH_TODO_MD + " file");
		}
	}

	private List<Task> fromLinesToTasks(List<String> lines) {
		//TODO: use lambda exp later
		List<Task> tasks = new LinkedList<>();
		for (String line : lines) {
			tasks.add(fromLineToTask(line));
		}
		return tasks;
	}

	private List<String> fromTasksToLines(List<Task> tasks) {
		//TODO: use lambda exp later
		List<String> lines = new LinkedList<>();
		for (Task task : tasks) {
			lines.add(task.toString());
		}
		return lines;
	}

	private Task fromLineToTask(String line) {
		if (line.startsWith("- [ ] ") || line.startsWith("- [x] ")) {
			String description = line.substring(6);
			boolean checked = line.startsWith("- [x] ");
			return new Task(description, checked);
		} else {
			return new Task(line, false);
		}
	}

}
