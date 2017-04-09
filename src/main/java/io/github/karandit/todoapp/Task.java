package io.github.karandit.todoapp;

public class Task {

	private final String description;
	private boolean checked;

	public Task(String description, boolean checked) {
		this.description = description;
		this.checked = checked;
	}

	public String getDescription() {
		return description;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("- [")
				.append(checked ? "x" : " ")
				.append("] ")
				.append(description)
				.toString();
	}
	
}
