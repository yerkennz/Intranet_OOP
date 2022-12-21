package Main;

import java.util.Objects;
import java.util.Vector;

public class Event {
	
	private String title;
	private String description;
	private Vector<Student> participants;
	
	public Event(String title, String description) {
		this.title = title;
		this.description = description;
	}
	//----------------------------------------------------
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//----------------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return "Event [title=" + title + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(description, other.description) && Objects.equals(title, other.title);
	}
}
