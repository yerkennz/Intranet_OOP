
public class Transcript {
	private double averageGPA;
	private int numberOfCredit;
	HashMap<int,HashMap<Course,Mark> > semesters = new HashMap< int,HashMap<Course,Mark> >();
	
	public void calculateGPA() {
		double cnt = 0;
		int numcourse = 0;
		for (int i = 0; i < semesters.size; i++)) {
			/*
			 * some code here ???
			 */
		}
	}
	public void putMark(int semester, Course course, Mark, mark) {
		semesters.get(semester).put(course,mark);
		numberOfCredit += course.getCredit();
		calculateGPA();
	}
	
	public String toString() {
		/*
		 * organized toString жфзу керек
		 */
	}
}
