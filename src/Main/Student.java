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
import Interfaces.viewInformation;

public class Student extends User{
	
	private Date dateOfJoin;
	private Double GPA;
	private boolean dormitoryNeed;
	private Faculties faculty;
	private boolean presentInOrganization;
	private Gender gender;
	private Nationality nationality;
	private Adress adress;
	private StudentDegree degree;
	private Transcript transcript;
	private Vector<Course> courses;
	public static HashMap<Course,Mark> marks;
	private int yearOFStudy;
	private final int MaxCredit = 21;
	private int credits = 0;
	private Vector<Book> books;
	
	public Student(String name, String surname, String id, String password,Faculties faculty,Gender gender,Adress adress,
			StudentDegree degree, int yearOFStudy) {
		super(name,surname,id,password);
		this.faculty = faculty;
		this.gender = gender;
		this.adress = adress;
		this.degree = degree;
		this.yearOFStudy = yearOFStudy;
		courses = new Vector<Course>();
		marks = new HashMap<Course,Mark>();
	}
	
	public Student(Date dateOfJoin, double gPA, boolean dormitoryNeed, Faculties faculty, boolean presentInOrganization,
			Gender gender, Nationality nationality, Adress adress, StudentDegree degree, Transcript transcript,
			 int yearOFStudy) {
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
		this.yearOFStudy = yearOFStudy;
		courses = new Vector<Course>();
		marks = new HashMap<Course,Mark>();
	}
//--------------------------------------------------------------------------------------------------------------------------------------	
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	public Double getGPA() {
		return this.GPA;
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
		return transcript.showInfo();
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
	/*
     * here student can see ratings of teachers
     */
	public boolean makeQuestionaire(String name, String surname, double rating) {
		for (User usr: Database.users) {
			if (usr.getName().equals(name) && usr.getSurname().equals(surname)){
				Teacher th = (Teacher)usr;
				th.setRating(rating);
				return true;
			}
		}
		return false;
	}
	/*
	 * this method is made to register for discipline
	 */
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
	/*
	 * this method shows transcript of student 
	 */
	public String viewTranscript() {
    	return this.transcript.showInfo(); 
    }
	/*
	 * here student sees attendance
	 */
	public String viewAttendance() {
		return "";
	}
	/*
	 * this method displays own private information of student 
	 */
	public String viewPrivateInformation() {
		return "Name: " + this.getName() + " " + this.getSurname()
		+ "\nID: " + this.getId() + "\nFaculty: " + this.faculty + "\nGPA: "+ this.GPA;
	}
	/*
	 * student sees courses chosen by himself/herself
	 */
	public String viewForCourses() {
		String listOfCourses = "";
		for (Course course : Database.courses) {
			listOfCourses += course.showInfo()+"\n";
		}
		return listOfCourses;
	}
	/*
	 * using this method student creates organization
	 */
	public void creatingOrganization(String NameOfOrg) {
		Organization org = new Organization(NameOfOrg,this);
		Database.organizations.add(org);
	}
	/*
	 * in this method a student can join an existing organization
	 */
	public boolean joiningOrganization(String orgName) {
		for (Organization org : Database.organizations) {
			if (org.getTitle().equals(orgName)) {
				org.addStudent(this);
				return true;
			}
		}
		return false;
	}
	/*
	 * this method shows files for courses
	 */
	public String viewCourseFiles(String courseID) {
    	String courseFile = "";
        for (CourseFiles file: Database.courseFile) {
        	if (file.getCourse().getCourseCode().equals(courseID)) {
        		courseFile += file.showFileInfo() + "\n";
        	}
        }
        return courseFile;
    }
	/*
	 * using this method the student can borrow a book from the library
	 */
	public boolean orderBook(String bookID, String librarianID) {
		for (User usr : Database.users) {
			if (usr instanceof Librarian) {
				Librarian lb = (Librarian)usr;
				if (lb.getId().equals(librarianID)) {
					for (Book bk : lb.allBook) {
						if (bk.getId().equals(bookID)) {
							books.add(bk);
							lb.removeBook(bookID);
							return true;
						}
					}
//					this.books.add()
				}
			}
		}
		return false;
	}
	
	public int hashCode() {
		return Objects.hash(super.hashCode(),this.getId(),courses,GPA);
	}
	
}
