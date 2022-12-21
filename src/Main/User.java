package Main;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable, Comparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private String id;
	private Date birthDay;
	private String login;
	private String password;
	private String phoneNumber;
	private String email;
	
	public User() {
		
	}
	
	public User(String name, String surname, String id, String password) {
		this.name = name;
		this.surname = surname;
		this.login = this.name.substring(0, 1).toLowerCase() + "_" + this.surname.toLowerCase();
		this.id = id;
		this.password = password;
	}
	
	public User(String name, String surname, String id, Date birthDay, String phoneNumber, String email) {
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.birthDay = birthDay;
		this.login = this.name.substring(0, 1).toLowerCase() + "_" + this.surname.toLowerCase();
		this.password = this.login;
		this.phoneNumber = phoneNumber;
		this.email = email;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean changePassword(String password, String newPassword) {
		if (password.equals(this.password)) {
			this.password = newPassword;
			return true;
		}
		return false;
	}
	public String viewNews() {
		String listOfNews = "";
		for (News news: Database.news) {
			listOfNews += news;
		}
		return listOfNews;
	}
	@Override
	public int hashCode() {
		return Objects.hash(birthDay, email, id, login, name, password, phoneNumber, surname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(birthDay, other.birthDay) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(login, other.login) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(surname, other.surname);
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", id=" + id + ", birthDay=" + birthDay + ", login="
				+ login + ", password=" + password + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	@Override
	public int compareTo(Object o) {
		User u = (User)o;
		return this.login.compareTo(u.login);
	}
}
