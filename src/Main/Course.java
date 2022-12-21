package Main;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

import Enums.TypeOfCourse;

public class Course {
	
	private String courseName;
	private String prereq;
	private int credits;
	private String courseCode;
	private boolean isAvailable;
	private String description;
	private TypeOfCourse typeOfCourse;
	public Vector<CourseFiles> courseFile;
	public HashMap<String,Boolean> attendance;
//------------------------------------------------------
	public Course(String name, int credits, String courseCode) {
		this.courseName = name;
		this.credits = credits;
		this.courseCode = courseCode;
		this.typeOfCourse = TypeOfCourse.BASIC;
		this.isAvailable = true;
		courseFile = new Vector<CourseFiles>();
		attendance = new HashMap<String,Boolean>();
	}
	
	public Course(String courseName, String prereq, int credits, String courseCode, boolean isAvailable,
			String description, TypeOfCourse typeOfCourse, Vector<CourseFiles> courseFiles) {
		super();
		this.courseName = courseName;
		this.prereq = prereq;
		this.credits = credits;
		this.courseCode = courseCode;
		this.isAvailable = isAvailable;
		this.description = description;
		this.typeOfCourse = typeOfCourse;
		this.courseFile = courseFiles;
		courseFile = new Vector<CourseFiles>();
		attendance = new HashMap<String,Boolean>();
	}
//----------------------------------------------------------------------	
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeOfCourse getTypeOfCourse() {
		return typeOfCourse;
	}
	public void setTypeOfCourse(TypeOfCourse typeOfCourse) {
		this.typeOfCourse = typeOfCourse;
	}
//----------------------------------------------------------------
	public String showAttendance() {
		String str = "";
		for (Entry<String, Boolean> m : attendance.entrySet()) {
			str += m.getKey() + " " + m.getValue()+"\n";
		}
		return str;
	}
	public boolean addCourseFile(CourseFiles file) {
		if (!courseFile.contains(file)) {
			courseFile.add(file);
			return true;
		}
		return false;
	}
	public boolean removeCourseFile(CourseFiles file) {
		if (!courseFile.contains(file)) {
			courseFile.remove(file);
			return true;
		}
		return false;
	}
	public int compareTo(Object o) {
		Course cr = (Course) o;
		return this.courseCode.compareTo(cr.courseCode);
	}
	public String showInfo() {
		return "Course name: "+courseName+"\nPrereq: "+prereq+"\nCourse code:"
				+courseCode+"\nDescription: "+description+"\nCourse type: "+typeOfCourse;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", prereq=" + prereq + ", credits=" + credits + ", isAvailable="
				+ isAvailable + ", description=" + description + "]";
	}
}
