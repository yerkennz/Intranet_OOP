package Main;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import Enums.Type;
import Interfaces.AddRemoveStudent;
import Interfaces.viewInformation;

public class Manager extends Employee implements AddRemoveStudent,viewInformation{
	
	private Type managerType;
	
	
	public Manager(String name, String surname, String id, Date birthDay,String phoneNumber, String email,
			int workExperience,Type managerType) {
		super(name,surname,id,birthDay,phoneNumber,email,workExperience);
		this.managerType = managerType;
	}
	public Manager(String name, String surname, String id, Date birthDay, String phoneNumber, String email, Date hireDate,
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
	public String viewForCourse(String courseID) {
    	String str = "";
    	for (CourseFiles file: Database.courseFile) {
    		if (file.getCourse().getCourseCode().equals(courseID))
    			str += file.showFileInfo()+"\n";
    	}
    	return str;
    }
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
	public void createNews(String text) {
		News nw = new News(text,this);
		Database.news.add(nw);
	}
	public String viewPrivateInformation(String userID) {
		for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(userID)) {
    				return std.viewPrivateInformation();
    			}
    		}
    	}
		for (User usr: Database.users) {
    		if (usr instanceof Teacher) {
    			Teacher std = (Teacher)usr;
    			if (std.getId().equals(userID)) {
    				return std.showInfo();
    			}
    		}
    	}
        return "There is no information";
    }
	public boolean addStudentToCourse(String studentID, String courseCode) {
    	for (User usr: Database.users) {
    		if (usr instanceof Student) {
    			Student std = (Student)usr;
    			if (std.getId().equals(studentID)) {
    				for (Course crs: std.getCourses()) {
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
	 public String viewCourseFiles(String teacherID) {
	    	String str ="";
	    	for (User usr: Database.users) {
	    		if (usr instanceof Teacher) {
	    			Teacher th = (Teacher)usr;
	    			if (th.getId().equals(teacherID)) {
	    				str += th.viewCourseFiles();
	    				return str;
	    			}
	    		}
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
	 public String showStatistic() {
		 String numberofStudent = "";
		 String numberofTeacher = "";
		 String top3StudentbyGPA = "";
		 String top3TeacherbyRating = "";
		 String worst3StudentbyGPA = "";
		 
		 int cnt1 = 0;
		 for (User usr: Database.users) {
	    		if (usr instanceof Student) {
	    			cnt1++;	    			
	    		}
		 }
		 numberofStudent = Integer.toString(cnt1);
		 int cnt2 = 0;
		 for (User usr: Database.users) {
	    		if (usr instanceof Teacher) {
	    			cnt2++;	    			
	    		}
		 }
		 numberofStudent = Integer.toString(cnt2);
		 
		 int i = 0;
		 int j = 0;
		 int k = 0;
		 Vector<Student> st = new Vector<Student>();
		 for (User user: Database.users) {
	            if(user instanceof Student) {
	                st.add((Student) user);
	            }
	     }
	        st.sort(new SortGPA());
	        for (User usr : st) {
				Student stt = (Student)usr;
	            i++;
	            
	            top3StudentbyGPA +=
	                i + ")  Student Name: " + stt.getName()
	            + "\n    Student surname: " + stt.getSurname() 
	            + "\n    ID: " + stt.getId()
	            + "\n    GPA: " + stt.getGPA() 
	            + "\n\n";
	       }
	       
	       Collections.reverse(st);
	       for (User usr : st) {
				Student stt = (Student)usr;
	            j++;
	            
	            worst3StudentbyGPA +=
	                j + ")  Student Name: " + stt.getName()
	            + "\n    Student surname: " + stt.getSurname() 
	            + "\n    ID: " + stt.getId()
	            + "\n    GPA: " + stt.getGPA() 
	            + "\n\n";
	       }
	      
	       Vector<Teacher> th = new Vector<Teacher>();
			 for (User user: Database.users) {
		            if(user instanceof Teacher) {
		                th.add((Teacher) user);
		            }
		     }
		        th.sort(new SortRating());
		        for (User usr : th) {
					Teacher thh = (Teacher)usr;
		            k++;
		            
		            top3TeacherbyRating +=
		                k + ")  Teacher Name: " + thh.getName()
		            + "\n    Teacher surname: " + thh.getSurname() 
		            + "\n    ID: " + thh.getId()
		            + "\n    Rating: " + thh.getRating() 
		            + "\n\n";
		       }
		     return numberofStudent +"\n"+ numberofTeacher+"\n"+
		    		 top3StudentbyGPA+"\n"+top3TeacherbyRating+"\n"+worst3StudentbyGPA;
		 		 
	 }
	 
	 public String showInfo() {
		 return "Name: "+this.getName()+"Surname: "+this.getSurname()+
				 "Manager id: "+this.getId()+"Type: "+this.getManagerType();
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
