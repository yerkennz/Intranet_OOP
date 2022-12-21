package Main;

import java.util.HashMap;
import java.util.Map.Entry;

public class Transcript {
	
	private double averageGPA;
	private int numberOfCredit;
	private HashMap<Integer,HashMap<Course,Mark> > semesters = new HashMap<Integer,HashMap<Course,Mark> >();
	
	public double getAverageGPA() {
		return averageGPA;
	}
	public void setAverageGPA(double averageGPA) {
		this.averageGPA = averageGPA;
	}
	public void calculateGPA() {
		double cnt = 0;
		int numCourse = 0;
		for (int i = 0; i < semesters.size(); i++){
			for (Entry<Course, Mark> m: semesters.get(i).entrySet()) {
				numCourse += 1;
				cnt += m.getValue().getGPAforCourse();
			}
		}
		averageGPA = cnt/numCourse;
	}
	public void putMark(int semester, Course course, Mark mark) {
		semesters.get(semester).put(course,mark);
		numberOfCredit += course.getCredits();
		calculateGPA();
	}
	public String showInfo() {
		String str = "";
		str += "Average GPA: "+this.averageGPA;
		for (int i = 1; i <= semesters.size();i++) {
			str += "\nMark for "+i+"semester\n";
			for (HashMap.Entry<Course,Mark> crs: semesters.get(i).entrySet()) {
				str += (crs.getKey()+ ": "+crs.getValue())+"\n";
			}
		}
		return str;
	}
//	public String toString() {
//		String str = "";
//		for(int i = 1; i <= semesters.size(); i++) {
//			str = str + "Marks of semester " + (i + 1) + "\n";
//			for (HashMap.Entry<Course,Mark> entry : semesters.get(i).entrySet()) {
//			    str = str + (entry.getKey() + "-" + entry.getValue().getGPAforCourse()) + "\n";
//			}
//		}
//		return str;
//	}
}
