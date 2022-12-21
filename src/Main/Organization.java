package Main;

import java.util.Objects;
import java.util.Vector;

public class Organization {
	
	private String title;
	private int amountOfParticipant;
	private Student president;
	private Vector<Student> members;
	private Vector<Event> events;
	private Vector<String> announcements;
	
	public Organization(String title, Student president) {
		this.title = title;
		this.president = president;
	}
//-----------------------------------------------------------
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAmountOfParticipant() {
		return amountOfParticipant;
	}

	public void setAmountOfParticipant(int amountOfParticipant) {
		this.amountOfParticipant = amountOfParticipant;
	}

	public Student getPresident() {
		return president;
	}

	public void setPresident(Student president) {
		this.president = president;
	}
	//--------------------------------------------------
	/*
	 * this method declares upcoming events
	 */
	public boolean makeAnnoucement(String str, Student student) {
		if (this.president == student) {
			announcements.add(str);
			return true;
		}
		return false;
	}
	/*
	 * this method adds student to organization
	 */	
	public void addStudent(Student student) {
		if (!members.contains(student))
			members.add(student);
	}
	/*
	 * this method adds student from organization
	 */
	public void removeStudent(Student student) {
		if (members.contains(student))
			members.remove(student);
	}
	/*
	 * using this method you can create event 
	 */
	public boolean createEvent(Student creator, String nameOfEvent, String description) {
		if (creator == this.president) {
			Event event = new Event(nameOfEvent,description);
			events.add(event);
			return true;
		}
		return false;
	}
	/*
	 * this method displays information about event
	 */
	public String showInfo() {
		return "Name of organization: "+title+"\nPresident: "+president+"\nAmount of members: "+amountOfParticipant;
	}
	@Override
	public int hashCode() {
		return Objects.hash(president, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		return Objects.equals(president, other.president) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Organization [title=" + title + ", amountOfParticipant=" + amountOfParticipant + ", president="
				+ president + "]";
	}
	
	
}
