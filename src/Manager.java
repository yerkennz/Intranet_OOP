import java.util.Objects;

public class Manager extends Employee implements viewInformation,requestOfWorker,Editing{
	private Type type;
	
	public int viewForCourses() {
	    return 0;
	}
	
	public int manageNews() {
	    return 0;
	}
	
	public int approveStudentRegistration() {
	    return 0;
	}
	
	public int coursesForTeachers() {
	    return 0;
	}
	
	public int createStatistic() {
	    return 0;
	}
	
	public void editingJournal() {
	    
	}

	public void editingAttendance() {
	}

	public void editingTranscript() {
	
	}

	public String viewPrivateInformation() {
	    
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return type == other.type;
	}

	@Override
	public String toString() {
		return "Manager [type=" + type + "]";
	}
	
	
	
	
	
}

