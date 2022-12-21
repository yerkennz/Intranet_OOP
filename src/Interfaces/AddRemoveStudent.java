package Interfaces;


public interface AddRemoveStudent {
	
	boolean addStudentToCourse(String studentID, String courseCode);
	
	boolean removeStudentFromCourse(String studentID, String courseCode);
}
