

import java.util.Date;

public class Organization {
	private String title;
	private int amountOfParticipants;
	private String president;
	private Date openingDate;
	
	public Organization() {}

	public Organization(String title, int amountOfParticipants, String president, Date openingDate) {
		super();
		this.title = title;
		this.amountOfParticipants = amountOfParticipants;
		this.president = president;
		this.openingDate = openingDate;
	}
	
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public String getPresident() {
		return president;
	}
	public void setPresident(String president) {
		this.president = president;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAmountOfParticipants() {
		return amountOfParticipants;
	}
	public void setAmountOfParticipants(int amountOfParticipants) {
		this.amountOfParticipants = amountOfParticipants;
	}
	public String toString() {
		return "Organization [title=" + title + ", amountOfParticipants=" + amountOfParticipants + ", president="
				+ president + ", openingDate=" + openingDate + "]";
	}
	
}
