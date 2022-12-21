package Main;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import Enums.Status;

public class Request implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private User sender;
	private Status status;
	//----------------------------------------------------------------------------------
	public Request(String text, Date date, User sender) {
		super();
		this.text = text;
		this.date = date;
		this.sender = sender;
	}
	public Request(String text, Date date, User sender, Status status) {
		super();
		this.text = text;
		this.date = date;
		this.sender = sender;
		this.status = status;
	}
	//------------------------------------------------------------------------------
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	//-----------------------------------------------------------------------------
	@Override
	public int hashCode() {
		return Objects.hash(date, sender, status, text);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(date, other.date) && Objects.equals(sender, other.sender) && status == other.status
				&& Objects.equals(text, other.text);
	}
	@Override
	public String toString() {
		return "Request [text=" + text + ", date=" + date + ", sender=" + sender + ", status=" + status + "]";
	}
	
	
}
