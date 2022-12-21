package Main;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable{
	
	private String title;
	private String text;
	private Employee sender;
	
	public Message() {
		
	}
	
	public Message(String title, String text, Employee sender) {
		this.title = title;
		this.text = text;
		this.sender = sender;
	}
//---------------------------------------------------------------------
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Employee getSender() {
		return sender;
	}

	public void setSender(Employee sender) {
		this.sender = sender;
	}
//----------------------------------------------------------------------------	
	public String showMessage() {
		return "Message Information: "+"\nTitle: "+title+"\nText: "+text+
				"\nSender: "+sender.getName();
	}

	@Override
	public int hashCode() {
		return Objects.hash(sender, text, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(sender, other.sender) && Objects.equals(text, other.text)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Message [title=" + title + ", text=" + text + ", sender=" + sender + "]";
	}
	
}
