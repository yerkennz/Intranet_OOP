package Main;

import java.util.Date;
import java.util.Objects;

import Interfaces.SendMessage;

public class Employee extends User implements SendMessage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5490875041299678924L;
	/**
	 * 
	 */

	private Date hireDate;
	private int salary;
	private String insuranceNumber;
	private int prize;
	private int workExperience;
	
	public Employee() {
		super();
	}
	public Employee(String name, String surname, String id, Date birthDay,String phoneNumber, String email,int workExperience) {
		super(name,surname,id,birthDay,phoneNumber,email);
		this.workExperience = workExperience;
	}
	public Employee(String name, String surname, String id, Date birthDay, String phoneNumber, String email,
			Date hireDate, int salary, String insuranceNumber, int prize, int workExperience) {
		
		super(name, surname, id, birthDay, phoneNumber, email);
		this.hireDate = hireDate;
		this.salary = salary;
		this.insuranceNumber = insuranceNumber;
		this.prize = prize;
		this.workExperience = workExperience;
	}
	public int getSalary() {
		return salary;
	}
	
	public void sendMessage(String title, String text) {
		Message ms = new Message(title,text,this);
		Database.messages.add(ms);
	}
	public String getMessage() {
		String str = "";
		for (Message ms : Database.messages) {
			if (ms.getSender().getId().equals(this.getId())) {
				str += ms.showMessage()+"\n";
			}
		}
		return str;
		
	}
	@Override
	public String toString() {
		return "Employee [hireDate=" + hireDate + ", salary=" + salary + ", insuranceNumber=" + insuranceNumber
				+ ", prize=" + prize + ", workExperience=" + workExperience + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hireDate, insuranceNumber, prize, salary, workExperience);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(hireDate, other.hireDate) && Objects.equals(insuranceNumber, other.insuranceNumber)
				&& prize == other.prize && salary == other.salary && workExperience == other.workExperience;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	public int getWorkExperience() {
		return workExperience;
	}
	public void setWorkExperience(int workExperience) {
		this.workExperience = workExperience;
	}
}
