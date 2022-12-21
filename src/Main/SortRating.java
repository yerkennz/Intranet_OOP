package Main;

import java.util.Comparator;

public class SortRating implements Comparator<Teacher>{
	
	public int compare(Teacher th1, Teacher th2) {
		return th2.getRating().compareTo(th1.getRating());
	}
}
