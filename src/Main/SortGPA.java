package Main;

import java.util.Comparator;

public class SortGPA implements Comparator<Student>{
	
	public int compare(Student st1, Student st2) {
		return st2.getGPA().compareTo(st1.getGPA());
	}
}
