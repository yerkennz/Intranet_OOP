package Main;
import java.util.Objects;

public class Adress {
	private String city;
	private String counrty;
	private String streetAdress;
	
	@Override
	public String toString() {
		return "Adress [city=" + city + ", counrty=" + counrty + ", streetAdress=" + streetAdress + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, counrty, streetAdress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adress other = (Adress) obj;
		return Objects.equals(city, other.city) && Objects.equals(counrty, other.counrty)
				&& Objects.equals(streetAdress, other.streetAdress);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounrty() {
		return counrty;
	}

	public void setCounrty(String counrty) {
		this.counrty = counrty;
	}

	public String getStreetAdress() {
		return streetAdress;
	}

	public void setStreetAdress(String streetAdress) {
		this.streetAdress = streetAdress;
	}

	public Adress(String city, String counrty, String streetAdress) {
		this.city = city;
		this.counrty = counrty;
		this.streetAdress = streetAdress;
	}
	
	
}
