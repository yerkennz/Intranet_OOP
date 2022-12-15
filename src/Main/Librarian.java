package Main;

public class Librarian extends Employee{
	public Librarian() {
		super();
	}

	public Librarian(String name, String surname, int id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize, workExperience);
	}

	public int makingRecords() {
		
		
	}
	
	public int managingWithTheBooks() {
		
	}
	
	public int generateInformation() {
		
	}
	
	public String viewNews() {
		String listOfNews = "";
		for (News news: Database.news) {
			listOfNews += news;
		}
		return listOfNews;
	}
	
	public String viewPrivateInformation() {
		return "Name: " + this.getName() + " " + this.getSurname();
	}
}
