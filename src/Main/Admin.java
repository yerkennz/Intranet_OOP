package Main;
import java.util.Date;

import Enums.Degree;
import Enums.Faculties;
import Enums.Gender;
import Enums.StudentDegree;
import Enums.Type;

public class Admin extends Employee implements Comparable{

	public Admin(String name, String surname, String id, Date birthDay,String phoneNumber, String email,int workExperience) {
		super(name,surname,id,birthDay,phoneNumber,email,workExperience);
	}

	public Admin(String name, String surname, String id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize, workExperience);
	}
//---------------------------------------------------------------------------------------------------------------
	public void addStudent(String name, String surname, String id, String password,Faculties faculty,Gender gender,Adress adress,
			StudentDegree degree, int yearOFStudy) {
		Student st = new Student(name,surname,id,password,faculty,gender,adress,degree,yearOFStudy);
		Database.users.add(st);
	}
	public void addTeacher(String name, String surname, String id, Date birthDay,String phoneNumber, String email,
			int workExperience,Degree degree) {
		Teacher th = new Teacher(name,surname,id,birthDay,phoneNumber,email,workExperience,degree);
		Database.users.add(th);
	}
	public void addManager(String name, String surname, String id, Date birthDay,String phoneNumber, String email,
			int workExperience,Type managerType) {
		Manager mg = new Manager(name,surname,id,birthDay,phoneNumber,email,workExperience,managerType);
		Database.users.add(mg);
	}
	public boolean removeUser(String userID) {
		for (User usr: Database.users) {
			if (usr.getId().equals(userID)) {
				Database.users.remove(usr);
				return true;
			}
		}
		return false;
	}
	
	public String showInfo() {
		return "Name: "+this.getName()+"\nSurname: "+this.getSurname()+"\nID: "+this.getId();
	}

	@Override
	public String toString() {
		return "Admin [getSalary()=" + getSalary() + ", toString()=" + super.toString() + ", hashCode()=" + hashCode()
				+ ", getInsuranceNumber()=" + getInsuranceNumber() + ", getPrize()=" + getPrize()
				+ ", getWorkExperience()=" + getWorkExperience() + ", getName()=" + getName() + ", getSurname()="
				+ getSurname() + ", getPassword()=" + getPassword() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getEmail()=" + getEmail() + ", viewNews()=" + viewNews() + ", getClass()=" + getClass() + "]";
	}
	public int compareTo(Object o) {
		Admin ad = (Admin)o;
		if (ad.getWorkExperience() > this.getWorkExperience() ) return -1;
		if (ad.getWorkExperience()  < this.getWorkExperience() ) return 1;
		return 0;	}
	
}
