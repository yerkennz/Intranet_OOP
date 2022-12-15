package Main;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

import Enums.Faculties;
import Enums.Gender;
import Enums.Nationality;
import Enums.StudentDegree;
import Exceptions.CreditLimit;

public class Student extends User{
	
	private Date dateOfJoin;
	private double GPA;
	private boolean dormitoryNeed;
	private Faculties faculty;
	private boolean presentInOrganization;
	private Gender gender;
	private Nationality nationality;
	private Adress adress;
	private StudentDegree degree;
	private Transcript transcript;
	private Journal journal;
	private Vector<Course> courses;
	public static HashMap<Course,Mark> marks;
	private int yearOFStudy;
	private final int MaxCredit = 21;
	private int credits = 0;
	
	public Student(Date dateOfJoin, double gPA, boolean dormitoryNeed, Faculties faculty, boolean presentInOrganization,
			Gender gender, Nationality nationality, Adress adress, StudentDegree degree, Transcript transcript, Journal journal,
			Vector<Course> courses, int yearOFStudy) {
		super();
		this.dateOfJoin = dateOfJoin;
		GPA = gPA;
		this.dormitoryNeed = dormitoryNeed;
		this.faculty = faculty;
		this.presentInOrganization = presentInOrganization;
		this.gender = gender;
		this.nationality = nationality;
		this.adress = adress;
		this.degree = degree;
		this.transcript = transcript;
		this.journal = journal;
		this.courses = courses;
		this.yearOFStudy = yearOFStudy;
	}
//--------------------------------------------------------------------------------------------------------------------------------------	
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	public boolean isDormitoryNeed() {
		return dormitoryNeed;
	}
	public void setDormitoryNeed(boolean dormitoryNeed) {
		this.dormitoryNeed = dormitoryNeed;
	}
	public Faculties getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculties faculty) {
		this.faculty = faculty;
	}
	public boolean isPresentInOrganization() {
		return presentInOrganization;
	}
	public void setPresentInOrganization(boolean presentInOrganization) {
		this.presentInOrganization = presentInOrganization;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Nationality getNationality() {
		return nationality;
	}
	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}
	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	public StudentDegree getDegree() {
		return degree;
	}
	public void setDegree(StudentDegree degree) {
		this.degree = degree;
	}
	public String getTranscript() {
		return transcript.toString();
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	public int getYearOFStudy() {
		return yearOFStudy;
	}
	public void setYearOFStudy(int yearOFStudy) {
		this.yearOFStudy = yearOFStudy;
	}
	 public HashMap<Course, Mark> getMarks() {
        return this.marks;
    }
    
    public void setMark(Course c, Mark m) {
    	marks.put(c, m);
    }
//------------------------------------------------------------------------------------------------------------------------	
	public void makeQuestionaire() {
		/*
		 Бөлек бір анкета деген класс құрау керек
		 жұмыс ыстеу үшін
		 */
	}
	
	public boolean registrationForDiciplines(String courseCode) throws CreditLimit{
		Course registrationCourse = null;
		if (Database.courses.size() >= 1) {
			for (Course course: Database.courses) {
				if (course.getCourseCode().equals(courseCode)) {
					this.credits += course.getCredits();
					registrationCourse = course;
				}
			}
			if (registrationCourse.isAvailable() && this.credits <= this.MaxCredit) {
				courses.add(registrationCourse);
				marks.put(registrationCourse,null);
				return true;
			}else {
				throw new CreditLimit(registrationCourse,MaxCredit);
			}
		}
		return false;
	}
	
	public Journal viewJournal() {
		return this.journal;
	}
	
	public Transcript viewTranscript() {
    	return this.transcript; 
    }
	
	public String viewPrivateInformation() {
		return "Name: " + this.getName() + " " + this.getSurname()
		+ "\nID: " + this.getId() + "\nFaculty: " + this.faculty + "\nGPA: "+ this.GPA;
	}
	
	public String viewForCourses() {
		String listOfCourses = "";
		for (Course course : Database.courses) {
			listOfCourses += course.showInfo()+"\n";
		}
		return listOfCourses;
	}
	
	public void creatingOrganization(String NameOfOrg) {
		Organization org = new Organization(NameOfOrg,this);
		Database.organizations.add(org);
	}
	
	public boolean joiningOrganization(String orgName) {
		for (Organization org : Database.organizations) {
			if (org.getTitle().equals(orgName)) {
				org.addStudent(this);
				return true;
			}
		}
		return false;
	}
	
	public String viewCourseFiles(Course course) {
    	String courseFile = "";
        for (CourseFiles file: course.courseFile) {
        	courseFile += file.showFileInfo() + "\n";
        }
        return courseFile;
    }
	
	public int hashCode() {
		return Objects.hash(super.hashCode(),this.getId(),courses,GPA);
	}
	
}
