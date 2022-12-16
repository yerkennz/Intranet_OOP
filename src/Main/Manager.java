package Main;

import java.util.Date;
import java.util.Objects;

import Enums.Type;

public class Manager extends Employee{
	
	private Type managerType;

	public Manager(String name, String surname, int id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience, Type managerType) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize,
				workExperience);
		this.managerType = managerType;
	}
//----------------------------------------------------------------------------------------------------
	public Type getManagerType() {
		return managerType;
	}

	public void setManagerType(Type managerType) {
		this.managerType = managerType;
	}
//---------------------------------------------------------------------------------------------------------
	public String viewForCourse(Course course) {
    	String str = "";
    	for (CourseFiles file: course.courseFile) {
    		str += file.showFileInfo()+"\n";
    	}
    	return str;
    }
	public void createNews(String text) {
		News nw = new News(text,this);
		Database.news.add(nw);
	}
	public String viewPrivateInformation(User user) {
        if (user instanceof Student) {
        	Student st = (Student)user;
        	return st.viewPrivateInformation();
        }
        if (user instanceof Teacher) {
        	Teacher th = (Teacher)user;
        	return th.showInfo();
        }
        return "You cannot see this information";
    }
	public boolean addStudentToCourse(Course course, Student student) {
        if (!student.getCourses().contains(course)) {
        	student.getCourses().add(course);
        	return true;
        }
        return false;
    }
	 public boolean removeStudentFromCourse(Course course, Student student) {
	    	if (student.getCourses().contains(course)) {
	        	student.getCourses().remove(course);
	        	return true;
	        }
	        return false;
	}
	 public String viewCourseFiles(Teacher the) {
	    	String str ="";
	    	if (!the.getLessons().isEmpty()) {
	    		for (Course crs: the.getLessons()) {
	    			str += crs+"\n";
	    		}
	    		return str;
	    	}
	    	return "File is emtpy";
	}
	
	 public boolean createCourse(String courseName, int credits, String courseCode) {
		 Course crs = new Course(courseName, credits, courseCode);
	    	for (Course course: Database.courses) {
	        	if (!course.getCourseCode().equals(courseCode)) {
	        		Database.courses.add(crs);
	        		return true;
	        	}
	    	}
	    	return false;
	 }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(managerType);
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
		Manager other = (Manager) obj;
		return managerType == other.managerType;
	}
	@Override
	public String toString() {
		return "Manager [managerType=" + managerType + "]";
	}
	

	
	
}
