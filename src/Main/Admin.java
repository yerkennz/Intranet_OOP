package Main;
import java.util.Date;

public class Admin extends Employee implements Comparable{

	public Admin() {
		super();
	}

	public Admin(String name, String surname, int id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize, workExperience);
	}
	public void addUser(String text) {
		if (text.equals("Admin")) {
			
		}
		else if (text.equals("Student")) {
			
		}
	}
	public boolean removeUser(User user) {
		for (User usr: Database.users) {
			if (user.equals(usr)) {
				Database.users.remove(user);
				return true;
			}
		}
		return false;
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
