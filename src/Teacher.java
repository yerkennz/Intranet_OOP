import java.util.Date;
import java.util.Objects;

public class Teacher extends Employee {

	private Degree Degree;
	private List<Course> lessons;
	
	public Teacher() {
		super();
	}

	public Teacher(String name, String surname, int id, Date birthDay, String phoneNumber, String email, Date hireDate,
			int salary, String insuranceNumber, int prize, int workExperience) {
		super(name, surname, id, birthDay, phoneNumber, email, hireDate, salary, insuranceNumber, prize, workExperience);
	}
	
	 	public void putMark() {
	    }

	  
	    public void editingJournal() {
	    	
	    }

	  
	    public void editingAttendance() {
	    }

	 
	    public void editingTranscript() {
	    }

	   
	    public String viewCourseFiles() {
	        return null;
	    }

	   
	    public String viewAttendance() {
	        return null;
	    }

	 
	    public String viewJournal() {
	        return null;
	    }

	   
	    public String viewPrivateInformation() {
	        return null;
	    }

	   
	    public String viewTranscript() {
	        return null;
	    }

	    public String viewForCourse() {
	        return null;
	    }

	    public boolean addStudentToCourse() {
	        return false;
	    }

	   
	    public boolean removeStudentFromCourse() {
	        return false;
	    }

	    
	    public void viewCourseFiles() {
	    }

	 
	    public void viewAttendance() {
	    }

	   
	     
	    public void viewJournal() {
	    }

	   
	    public void viewTranscript() {
	    }

	   
	    public void viewForCourse() {
	    }

	    
	    public void editingJournal() {
	    }

	   
	    public void editingAttendance() {
	    }

	   
	    public void editingTranscript() {
	    }

		
		public String toString() {
			return "Teacher [Degree=" + Degree + "]";
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
			return Degree == other.Degree;
		}
		
	    
	   
	}
