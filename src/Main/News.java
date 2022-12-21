package Main;

import java.util.Objects;

public class News extends Message{
	
	private String description;
	private Manager manager;
	
	public News() {
		
	}

	public News(String description, Manager manager) {
		super();
		this.description = description;
		this.manager = manager;
	}
//-----------------------------------------------------
	public String getDesription() {
		return description;
	}

	public void setDesription(String desription) {
		this.description = desription;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
//----------------------------------------------------------	
	/*
	 * this method shows information about news
	 */
	public String showNewsInfo() {
		return "Message Information: "+"\nTitle: "+this.getTitle()+"\nText: "+this.getText()+
				"\nSender: "+this.getSender()+"\nDescription: "+description+"\nManager: "+manager.getName();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(description);
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
		News other = (News) obj;
		return Objects.equals(description, other.description);
	}
	/*
	 * news is shown here
	 */
	public String showNews() {
		String str = "";
		for (News nws: Database.news) {
			str += nws+"\n";
		}
		return str;
	}
}
