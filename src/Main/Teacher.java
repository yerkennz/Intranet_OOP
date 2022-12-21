package Main;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Vector;

import Enums.Degree;
import Interfaces.AddRemoveStudent;
import Interfaces.viewInformation;

public class Teacher extends Employee implements AddRemoveStudent,viewInformation{

	private Degree degree;
	private List<Course> lessons;
	private Double rating = 0.0;
	
	public Teacher() {
		super();
		lessons = new Vector<Course>();
	}
	public Teacher(String name, String surname, String id, Date birthDay,String phoneNumber, String email,
			int workExperience,Degree degree) {
		super(name,surname,id,birthDay,phoneNumber,email,workExperience);
		this.degree = degree;
		lessons = new Vector<Course>();
	}
	public Teacher(String name, String surname, String id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize, workExperience);
		lessons = new Vector<Course>();
	}
	//--------------------------------------------------------
 	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public List<Course> getLessons() {
		return lessons;
	}

	public void setLessons(List<Course> lessons) {
		this.lessons = lessons;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(double num) {
		this.rating = (this.rating+num)/2;
	}
//--------------------------------------------------------------
	/*
	 * using this method teacher puts mark
	 */
	public boolean putMark(Course course, String studentID, double score, String att) {
		for (User usr: Database.users) {
			if (usr instanceof Student) {
				Student std = (Student)usr;
				if (std.getId().equals(studentID)) {
					if (std.getCourses().contains(course)) {
						for (Entry<Course, Mark> m : std.getMarks().entrySet()) {
							Mark mark1 = m.getValue();
							Student.marks.put(course, mark1);
							std.setMark(course, new Mark(score,att));
							return true;
						}
					}
				}
			}
		}
		return false;
    }

    public void markAttendance(String studentID, String courseCode, String date) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				for (Course crs: std.getCourses()) {
    					if (crs.getCourseCode().equals(courseCode)) {
    						crs.attendance.put(date, true);
    					}
    				}
    			}
    		}
    	}
    }
   /*
	 * here teacher will open attendance so that students can check in
	 */
    public String viewAttendance(String studentID, String courseCode) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				for (Course crs: std.getCourses()) {
    					if (crs.getCourseCode().equals(courseCode)) {
    						return crs.showAttendance();
    					}
    				}
    			}
    		}
    	} 
    	return "Empty attendance list";
    }
     /*
    * here teacher sees private information of students
    */
    public String viewPrivateInformation(String studentID) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				return std.viewPrivateInformation();
    			}
    		}
    	}
        return "There is no information";
    }
 /*
    * using this method teachers sees transcript of student
    */
    public String viewTranscript(String studentID) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				return std.getTranscript();
    			}
    		}
    	}
        return "There is no information";
    }
     /*
     * using this method teachers adds students to course
     */
    public boolean addStudentToCourse(String studentID, String courseCode) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				for (Course crs: Database.courses) {
    					if (crs.getCourseCode().equals(courseCode)) {
    						std.getCourses().add(crs);
    						return true;
    					}
    				}
    			}
    		}
    	}
        return false;
    }

    /*
     * using this method teachers removes students from course
     */
    public boolean removeStudentFromCourse(String studentID, String courseCode) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				for (Course crs: std.getCourses()) {
    					if (crs.getCourseCode().equals(courseCode)) {
    						std.getCourses().remove(crs);
    						return true;
    					}
    				}
    			}
    		}
    	}
        return false;
    }
 
	/*
     * this method displays files for courses
     */
    public String viewCourseFiles() {
    	String str ="";
    	if (!this.lessons.isEmpty()) {
    		for (Course crs: lessons) {
    			str += crs+"\n";
    		}
    		return str;
    	}
    	return "File is emtpy";
    }

 

    /*
    * using this method teacher sees courses
    */
    public String viewForCourse(String courseID) {
    	String str = "";
    	for (CourseFiles file: Database.courseFile) {
    		if (file.getCourse().getCourseCode().equals(courseID))
    			str += file.showFileInfo()+"\n";
    	}
    	return str;
    }
   
	
	public String toString() {
		return "Teacher [Degree=" + degree + "]";
	}
	/*
	 * this method shows information about teacher
	 */
	public String showInfo() {
		return "Name: "+this.getName()+"\nDegree: "+this.degree+"\nRating: "+this.rating;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		return degree == other.degree;
	}
	
	    
	   
}
