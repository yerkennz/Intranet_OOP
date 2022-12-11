import java.util.Date;
import java.util.Objects;
import java.util.Vector;

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
	private int yearOFStudy;
	public Student(Date dateOfJoin, double gPA, boolean dormitoryNeed, Faculties faculty, boolean presentInOrganization,
			Gender gender, Nationality nationality, Adress adress, Degree degree, Transcript transcript, Journal journal,
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
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	public Transcript getTranscript() {
		return transcript;
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
	
	public void makeQuestionaire() {
		/*
		 Бөлек бір анкета деген класс құрау керек
		 жұмыс ыстеу үшін
		 */
	}
	public boolean registrationForDiciplines() {
		
	}
	
	public Journal viewJournal() {
		return this.journal;
	}
	public Transcript viewTranscript() {
    	return this.transcript; 
    }
	public String viewPrivateInformation() {
		return "Name: " + this.getName() + " " + this.getSurname()
		+ "\nID: " + this.getid() + "\nFaculty: " + this.faculty + "\nGPA: "+ this.GPA;
	}
	public String viewForCourses() {
		String listOfCourses = "";
		for (Course course : Database.courses) {
			listOfCourses += course.showInfo()+"\n";
		}
		return listOfCourses;
	}
	public void creatingOrganization() {
		Organization org = new Organization();
		Database.organizations.add(org);
	}
	public boolean joiningOrganization(String orgName) {
		for (Organization org : Database.organizations) {
			if (org.name.equals(orgName)) {
				Organization.add(this);
				return true;
			}
		}
		return false;
	}
	public String viewCourseFiles(Course course) {
    	String courseFile = "";
        for (CourseFiles file: course.courseFiles) {
        	courseFile += file.showFileInfo() + "\n";
        }
        return courseFile;
    }
	public int hashCode() {
		return Objects.hash(super.hashCode(),id,courses,GPA);
	}
	
}
