
public enum State {
	BACKLOG("Backlog"), DO_TO("To do"), IN_PROGRESS("In progress"), DONE("Done");
	private String description;

	State(String description) {
		this.description = description;
	}

	public String toString() {
		return description;
	}
}