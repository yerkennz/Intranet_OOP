package Main;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import Enums.Degree;

public class Teacher extends Employee{

	private Degree degree;
	private List<Course> lessons;
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String surname, int id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize, workExperience);
		
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
//--------------------------------------------------------------
	public boolean putMark(Course course, Student student, double score) {
		for (User usr: Database.users) {
			if (usr instanceof Student) {
				Student std = (Student)usr;
				if (std.equals(student)) {
					if (std.getCourses().contains(course)) {
						for (Entry<Course, Mark> m : student.getMarks().entrySet()) {
							Mark mark1 = m.getValue();
							student.setMark(course, mark1);
							return true;
						}
					}
				}
			}
		}
		return false;
    }

  
    public void editingJournal() {
    	
    }

  
    public void editingAttendance() {
    }
   
    public String viewAttendance() {
        return null;
    }

 
    public String viewJournal() {
        return null;
    }

   
    public String viewPrivateInformation(Student student) {
        return student.viewPrivateInformation();
    }

   
    public String viewTranscript(Student student) {
        return student.getTranscript();
    }
    
    public boolean addStudentToCourse(Course course, Student student) {
        return false;
    }

   
    public boolean removeStudentFromCourse() {
        return false;
    }

    
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

 
    public void viewAttendance() {
    }

   
     
    public void viewJournal() {
    }

   
    public void viewTranscript() {
    }

   
    public String viewForCourse(Course course) {
    	String str = "";
    	for (CourseFiles file: course.courseFile) {
    		str += file.showFileInfo()+"\n";
    	}
    	return str;
    }

    
    public void editingJournal() {
    }

   
    public void editingAttendance() {
    }

   
    public void editingTranscript() {
    }

	
	public String toString() {
		return "Teacher [Degree=" + degree + "]";
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
