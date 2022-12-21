package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.Vector;

import Enums.Degree;
import Enums.Faculties;
import Enums.Gender;
import Enums.Genre;
import Enums.StudentDegree;
import Enums.Type;
import Enums.TypeOfCourse;
import Exceptions.CreditLimit;

public class Test {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException, CreditLimit {
		// TODO Auto-generated method stub
		
		
		Admin admin1 = new Admin("Nursultan","Yerkenov","1",new Date(),"87055527326","yerken1655@gmail.com",1);
		
		Teacher teacher1 = new Teacher("Alen","Bekenov","1TH",new Date(),"87777545423","bekenov.kbty.kz",4,Degree.LECTURER);
		Teacher teacher2 = new Teacher("Beket","Japar","2TH",new Date(),"87777545546","japar@kbtu.kz",31,Degree.PROFESSOR);
		Teacher teacher3 = new Teacher("Dinara","Baratova","3TH",new Date(),"87777546543","dinara@kbtu.kz",16,Degree.LECTURER);
		Teacher teacher4 = new Teacher("Yelena","Surova","4TH",new Date(),"877457545423","y_surova@kbtu.kz",15,Degree.LECTURER);
		Teacher teacher5 = new Teacher("Alireza","Yuldaz","5TH",new Date(),"87777545423","alireza@gmail.com",2,Degree.TUTOR);
		Teacher teacher6 = new Teacher("Temirlan","Esmoldin","6TH",new Date(),"87777545422","t_esmoldin@kbtu.kz",3,Degree.TUTOR);
		
		Student student1 = new Student("Marat","Saken","1ST","m_saken",Faculties.FIT,Gender.MALE,
				new Adress("Almaty","Kazakhstan","Street1"),StudentDegree.BACHELOR,1);
		
		Student student2 = new Student("Alima","Askarova","2ST","a_askarova",Faculties.FIT,Gender.FEMALE,
				new Adress("Astana","Kazakhstan","Street1"),StudentDegree.BACHELOR,2);
		
		Student student3 = new Student("Askar","Veronov","3ST","a_veronov",Faculties.KMA,Gender.MALE,
				new Adress("Aktay","Kazakhstan","Street2"),StudentDegree.BACHELOR,3);
		
		Student student4 = new Student("Yasmin","Sardar","4ST","y_sardar",Faculties.FIT,Gender.FEMALE,
				new Adress("Almaty","Kazakhstan","Street4"),StudentDegree.BACHELOR,2);
		
		Student student5 = new Student("Max","Durov","5ST","m_durov",Faculties.FIT,Gender.MALE,
				new Adress("Oral","Kazakhstan","Street1"),StudentDegree.BACHELOR,4);
		
		Student student6 = new Student("Madina","Kyzyr","6ST","m_kyzyr",Faculties.FIT,Gender.FEMALE,
				new Adress("Astana","Kazakhstan","Street5"),StudentDegree.BACHELOR,1);
		
		Librarian librarian1 = new Librarian("Gulnaz","Dairova","1LB",new Date(),"87775551221","g_dairova@kbtu.kz",6);
		
		Manager manager1 = new Manager("Sanya","Merey","1MN",new Date(),"87155551221","s_merey@kbtu.kz",4,Type.OR);
		
		News news1 = new News("This first news",manager1);
		
//		String name, int credits, String courseCode
		
		Course course1 = new Course("OOP",4,"CS1");
		Course course2 = new Course("Algo",4,"CS2");
		Course course3 = new Course("DataBase",3,"CS3");
		Course course4 = new Course("Calculus",4,"MATH1");
		Course course5 = new Course("English",4,"FUN1");
		
		
		Database.users.add(admin1);
		Database.users.add(teacher1);
		Database.users.add(teacher2);
		Database.users.add(teacher3);
		Database.users.add(teacher4);
		Database.users.add(teacher5);
		Database.users.add(teacher6);
		Database.users.add(student1);
		Database.users.add(student2);
		Database.users.add(student3);
		Database.users.add(student4);
		Database.users.add(student5);
		Database.users.add(student6);
		Database.courses.add(course1);
		Database.courses.add(course2);
		Database.courses.add(course3);
		Database.courses.add(course4);
		Database.courses.add(course5);
		Database.users.add(librarian1);
		Database.users.add(manager1);
		
		
		System.out.println("Welcome to university system");
		System.out.println("Enter your login:");
		System.out.println("Enter Q to quit from system.");
		String str = reader.readLine();
		if (str.equals("Q")) {
			System.exit(0);
		}
		for (User u : Database.users) {
			if (u.getLogin().equals(str)) {
				System.out.println("Enter password: ");
				String psw = reader.readLine();
				if (u.getPassword().equals(psw)) {
					System.out.println("Welcome "+u.getName()+" "+u.getSurname()+".");
					if (u instanceof Student) {
						boolean flag = true;
						while(flag) {
							Student st = (Student)u;
							System.out.println("##################[ "+st.getName()+" "+st.getSurname()+"(Student)"+" ]##################");
							System.out.println(
									"     	[1]   	Student information\n"+
									"     	[2]   	Make Questionaire\n"+
									"     	[3]   	Register to Course\n"+
									"     	[4]   	View course\n"+
									"     	[5]   	View Transcript\n"+
									"     	[6]  	View Attendance\n"+
									"     	[7]   	View student course file\n"+
									"     	[8]   	View News\n"+
									"     	[9] 	Create Organization\n"+
									"     	[10]  	Join to Organization\n"+
									"     	[11]  	Change password\n"+
									"     	[0]   	Quit\n"
									);
							
							int number = Integer.parseInt(reader.readLine());
							
							switch(number) {
								case 1:
									System.out.println(st.viewPrivateInformation());
									break;
								case 2:
									System.out.println("Enter teacher name and surname: ");
									String name = reader.readLine();
									String surname = reader.readLine();
									System.out.println("Rate from 0 to 5");
									double rate = Double.parseDouble(reader.readLine());
									st.makeQuestionaire(name, surname,rate);
									//Database.save();
									break;
								case 3:
									System.out.println("Enter courseId: ");
									String courseId = reader.readLine();
									if (st.registrationForDiciplines(courseId)) {
										System.out.println("You registered");
									}else {
										System.out.println("Error!!!");
									}
									//Database.save();
									break;
								case 4:
									System.out.println(st.viewForCourses());
									break;
								case 5:
									System.out.println(st.viewTranscript());
									break;
								case 6:
									System.out.println(st.viewAttendance());
									break;
								case 7:
									System.out.println("Enter course code: ");
									String courseCode = reader.readLine();
									System.out.println(st.viewCourseFiles(courseCode));
									break;
								case 8:
									System.out.println(st.viewNews());
									break;
								case 9 :
									System.out.println("Enter organization name: ");
									String orgName = reader.readLine();
									st.creatingOrganization(orgName);
									//Database.save();
									break;
								case 10:
									System.out.println("Enter organization name: ");
									String orgName2 = reader.readLine();
									st.joiningOrganization(orgName2);
									//Database.save();
									break;
								case 11:
									System.out.println("Enter you password: ");
									String oldpws = reader.readLine();
									System.out.println("Enter you  new password: ");
									String newpws = reader.readLine();
									if (st.changePassword(oldpws, newpws)) {
										System.out.println("Your password has changed");
									}else {
										System.out.println("Error!!!");
									}
									//Database.save();
									break;
								case 0:
									System.exit(0);
							}
						}
					}else if (u instanceof Teacher) {
						boolean flag = true;
						while(flag) {
							Teacher th = (Teacher) u;
							System.out.println("##################[ "+th.getName()+" "+th.getSurname()+"(Teacher)"+" ]##################");
							System.out.println(
									"     	[1]   	Teacher information\n"+
									"     	[2]   	Put Mark to Students\n"+
									"     	[3]   	Put Attendance\n"+
									"     	[4]   	View Attendance\n"+
									"     	[5]   	View students information\n"+
									"     	[6]  	View Transcript\n"+
									"     	[7]   	Add Students to course\n"+
									"     	[8]   	Remove Students from course\n"+
									"     	[9] 	View Course file\n"+
									"     	[10]  	View Course information\n"+
									"     	[11]  	Change password\n"+
									"     	[12]  	View News\n"+
									"     	[13]  	Send Message\n"+
									"     	[14]  	Get Message\n"+
									"     	[0]   	Quit\n"
									);
							
							int number = Integer.parseInt(reader.readLine());
							
							switch(number) {
							case 1:
								System.out.println(th.showInfo());
								break;
							case 2:
								System.out.println("Enter course name, credits, course code: ");
								String courseName = reader.readLine();
								int courseCredit = Integer.parseInt(reader.readLine());
								String courseCode = reader.readLine();
								System.out.println("Enter student id:");
								String studentID = reader.readLine();
								System.out.println("Enter point");
								Double score = Double.parseDouble(reader.readLine());
								System.out.println("Enter type of score (att1/att2/final): ");
								String type = reader.readLine();
								th.putMark(new Course(courseName,courseCredit,courseCode), studentID, score, type);
								//Database.save();
								break;
							case 3:
								System.out.println("Enter student ID, Course Code, Data(dd/mm/yyyy): ");
								String studentID1 = reader.readLine();
								String courseCode1 = reader.readLine();
								String date = reader.readLine();
								th.markAttendance(studentID1, courseCode1, date);
								//Database.save();
								break;
							case 4:
								System.out.println("Enter student ID, Course Code: ");
								String studentID2 = reader.readLine();
								String courseCode2 = reader.readLine();
								System.out.println(th.viewAttendance(studentID2, courseCode2));
								break;
							case 5:
								System.out.println("Enter student id: ");
								String studentID3 = reader.readLine();
								System.out.println(th.viewPrivateInformation(studentID3));
								break;
							case 6:
								System.out.println("Enter student id: ");
								String studentID4 = reader.readLine();
								System.out.println(th.viewTranscript(studentID4));
								break;
							case 7:
								System.out.println("Enter student ID, Course Code: ");
								String studentID5 = reader.readLine();
								String courseCode5 = reader.readLine();
								if (th.addStudentToCourse(studentID5, courseCode5)) {
									System.out.println("Student successfully added");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save()
								break;
							case 8:
								System.out.println("Enter student ID, Course Code: ");
								String studentID6 = reader.readLine();
								String courseCode6 = reader.readLine();
								if (th.removeStudentFromCourse(studentID6, courseCode6)) {
									System.out.println("Student successfully deleted from course");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save()
								break;
							case 9:
								System.out.println(th.viewCourseFiles());
								break;
							case 10:
								System.out.println("Enter course code: ");
								String courseCode7 = reader.readLine();
								System.out.println(th.viewForCourse(courseCode7));
								break;
							case 11:
								System.out.println("Enter you password: ");
								String oldpws = reader.readLine();
								System.out.println("Enter you  new password: ");
								String newpws = reader.readLine();
								if (th.changePassword(oldpws, newpws)) {
									System.out.println("Your password has changed");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save();
								break;
							case 12:
								System.out.println(th.viewNews());
								break;
							case 13:
								System.out.println("Enter message title: ");
								String title1 = reader.readLine();
								System.out.println("Enter text: ");
								String text1 = reader.readLine();
								th.sendMessage(title1, text1);
								//Database.save();
								break;
							case 14:
								System.out.println(th.getMessage());
								break;
							case 0:
								System.exit(0);
							}
								
							
						}
					} else if (u instanceof Manager) {
						boolean flag = true;
						while(flag) {
							Manager m = (Manager) u;
							
							System.out.println("##################[ "+m.getName()+" "+m.getSurname()+"(Manager)"+" ]##################");
							System.out.println(
									"     	[1]   		Manager information\n"+
									"     	[2]  		View Student courses\n"+
									"     	[3]   		View Student Transcript\n"+
									"     	[4]   		View Attendance\n"+
									"     	[5]   		Create News\n"+
									"     	[6]  		View private information\n"+
									"     	[7]   		Add Students to course\n"+
									"     	[8]   		Remove Students from course\n"+
									"     	[9] 		View Course file\n"+
									"     	[10]  	    Create Course\n"+
									"     	[11]  		Show Statistics\n"+
									"     	[12]  		View News\n"+
									"     	[13]  		Send Message\n"+
									"     	[14]  		Get Message\n"+
									"     	[0]   		Quit\n"
									);
							
							int number = Integer.parseInt(reader.readLine());
							switch(number) {
							case 1: 
								System.out.println(m.showInfo());
								break;
							case 2:
								System.out.println("Enter course code: ");
								String courseCode = reader.readLine();
								System.out.println(m.viewForCourse(courseCode));
								break;
							case 3:
								System.out.println("Enter student id: ");
								String studentID = reader.readLine();
								System.out.println(m.viewTranscript(studentID));
								break;
							case 4:
								System.out.println("Enter student ID, Course Code: ");
								String studentID2 = reader.readLine();
								String courseCode2 = reader.readLine();
								System.out.println(m.viewAttendance(studentID2, courseCode2));
								break;
							case 5:
								System.out.println("Enter your news text");
								String newsText = reader.readLine();
								m.createNews(newsText);
								//Database.save();
								break;
							case 6:
								System.out.println("Enter user id: ");
								String userID = reader.readLine();
								System.out.println(m.viewPrivateInformation(userID));
								break;
							case 7:
								System.out.println("Enter student ID, Course Code: ");
								String studentID5 = reader.readLine();
								String courseCode5 = reader.readLine();
								if (m.addStudentToCourse(studentID5, courseCode5)) {
									System.out.println("Student successfully added");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save()
								break;
							case 8:
								System.out.println("Enter student ID, Course Code: ");
								String studentID6 = reader.readLine();
								String courseCode6 = reader.readLine();
								if (m.removeStudentFromCourse(studentID6, courseCode6)) {
									System.out.println("Student successfully deleted from course");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save()
								break;
							case 9:
								System.out.println("Enter teahcer id: ");
								String teacherID = reader.readLine();
								System.out.println(m.viewCourseFiles(teacherID));
								break;
							case 10:
								System.out.println("Enter course name, credits, course Code: ");
								String courseName = reader.readLine();
								int credits = Integer.parseInt(reader.readLine());
								String courseCode4 = reader.readLine();
								System.out.println(m.createCourse(courseName, credits, courseCode4));
								//Database.save();
								break;
							case 11:
								System.out.println(m.showStatistic());
								break;
							case 12:
								System.out.println(m.viewNews());
								break;
							case 13:
								System.out.println("Enter message title: ");
								String title1 = reader.readLine();
								System.out.println("Enter text: ");
								String text1 = reader.readLine();
								m.sendMessage(title1, text1);
								//Database.save();
								break;
							case 14:
								System.out.println(m.getMessage());
								break;
							case 0:
								System.exit(0);
								
							}
						}
					}else if (u instanceof Admin) {
						boolean flag = true;
						while(flag) {
							Admin ad = (Admin)u;
							System.out.println("##################[ "+ad.getName()+" "+ad.getSurname()+"(Admin)"+" ]##################");
							System.out.println(
									"     [1]   	Admin information\n"+
									"     [2]  		Add Student\n"+
									"     [3]   	Add Teacher\n"+
									"     [4]   	Add Manager\n"+
									"     [5]   	Remove user\n"+
									"     [6]  		Change password\n"+
									"     [7]  		View News\n"+
									"     [8]   	Send Message\n"+
									"     [9]   	Get Message\n"+
									"     [0]   	Quit\n"
									);
							int number = Integer.parseInt(reader.readLine());
							switch(number) {
							//String name, String surname, String id, String password,Faculties faculty,Gender gender,Adress adress,
							//StudentDegree degree, int yearOFStudy
							case 1:
								System.out.println(ad.showInfo());
								break;
							case 2:
								System.out.println("Enter: ["
										+ "Name, Surname, ID, password, faculty[FIT, KMA, FNGE], gender, adress, degree, year of study]");
								String StudentName = reader.readLine();
								String StudentSurname = reader.readLine();
								int studentID = Integer.parseInt(reader.readLine());
								String pws = reader.readLine();
								String facul = reader.readLine();
								String gen = reader.readLine();
								System.out.println("Enter adress: [city,country,street adress]");
								String city = reader.readLine();
								String country = reader.readLine();
								String street = reader.readLine();
								String deg = reader.readLine();
								int year = Integer.parseInt(reader.readLine());
								Faculties f = null;
								switch(facul) {
								case "FIT": f = Faculties.FIT; break;
								case "KMA": f = Faculties.KMA; break;
								case "FNGE": f = Faculties.FNGE; break;
								default: f = Faculties.FIT; break;
								}
								Gender g = null;
								switch(gen) {
								case "MALE": g = Gender.MALE; break;
								case "FEMALE": g = Gender.FEMALE; break;
								case "OTHER": g = Gender.OTHER; break;
								default: g = Gender.MALE; break;
								}
								StudentDegree dg = null;
								switch(deg) {
								case "BACHELOR" : dg = StudentDegree.BACHELOR; break;
								case "MASTER" : dg = StudentDegree.MASTER; break;
								case "PHD" : dg = StudentDegree.PHD; break;
								default: dg = StudentDegree.BACHELOR;break;
								}
								ad.addStudent(StudentName, StudentSurname, str, psw, f, g,new Adress(city,country,street), dg, year);
								System.out.println("Student added");
								//Database.save();
								break;
							case 3:
								System.out.println("Enter: ["
								+ "Name, Surname, ID, birthDay, phone number, email, work Experience, degree]");
								String ThName = reader.readLine();
								String ThSurname = reader.readLine();
								String ThID = reader.readLine();
								String bd = reader.readLine();
								String phone = reader.readLine();
								String em = reader.readLine();
								int we = Integer.parseInt(reader.readLine());
								String deg1 = reader.readLine();
								Degree dg1 = null;
								switch(deg1) {
								case "PROFESSOR" : dg1 = Degree.PROFESSOR;break;
								case "LECTURER" : dg1 = Degree.LECTURER;break;
								case "TUTOR" : dg1 = Degree.TUTOR;break;
								default: dg1 = Degree.TUTOR;break;
								}
								ad.addTeacher(ThName, ThSurname, ThID,new Date(), phone, em, we, dg1);
								System.out.println("Teacher added");
								//Database.save();
								break;
							case 4:
								System.out.println("Enter: ["
								+ "Name, Surname, ID, birthDay, phone number, email, work Experience, type]");
								String MName = reader.readLine();
								String MSurname = reader.readLine();
								String MID = reader.readLine();
								String bd1 = reader.readLine();
								String Mphone = reader.readLine();
								String Mem = reader.readLine();
								int Mwe = Integer.parseInt(reader.readLine());
								String Mdeg1 = reader.readLine();
								Type Mdg1 = null;
								switch(Mdeg1) {
								case "DEPARTMENT" : Mdg1 = Type.DEPARTMENT;break;
								case "OR" : Mdg1 = Type.OR;break;
								default: Mdg1 = Type.OR;break;
								}
								ad.addManager(MName, MSurname, MID, new Date(), Mphone, Mem, Mwe, Mdg1);
								System.out.println("Teacher added");
								//Database.save();
							case 5:
								System.out.println("Enter user id: ");
								String studentID2 = reader.readLine();
								ad.removeUser(studentID2);
								//Database.save();
								break;
							case 6:
								System.out.println("Enter you password: ");
								String oldpws = reader.readLine();
								System.out.println("Enter you  new password: ");
								String newpws = reader.readLine();
								if (ad.changePassword(oldpws, newpws)) {
									System.out.println("Your password has changed");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save();
								break;
							case 7:
								System.out.println(ad.viewNews());
								break;
							case 8:
								System.out.println("Enter message title: ");
								String title1 = reader.readLine();
								System.out.println("Enter text: ");
								String text1 = reader.readLine();
								ad.sendMessage(title1, text1);
								//Database.save();
								break;
							case 9:
								System.out.println(ad.getMessage());
								break;
							case 0:
								System.exit(0);
							
							}
						}
					}else if (u instanceof Librarian) {
						boolean flag = true;
						while(flag) {
							Librarian lb = (Librarian)u;
							System.out.println("##################"+lb.getName()+lb.getSurname()+"##################");
							System.out.println(
									"     [1]   Librarian information\n"+
									"     [2]  	Add Book\n"+
									"     [3]   Remove Book\n"+
									"     [4]   Send Message\n"+
									"     [5]   Get Message\n"+
									"     [6]  	Change password\n"+
									"     [7]  	View News\n"+
									"     [0]   Quit\n"
									);
							int number = Integer.parseInt(reader.readLine());
							
							switch(number) {
							case 1:
								System.out.println(lb.showInfo());
								break;
							case 2:
								System.out.println("Enter book genre, title, author, id, year");
								String gn = reader.readLine();
								String title = reader.readLine();
								String ath = reader.readLine();
								String bkID = reader.readLine();
								int year = Integer.parseInt(reader.readLine());
								Genre gen = null;
								switch(gn) {
								case "FICTION" : gen = Genre.FICTION;break;
								case "NONFINCTION" : gen = Genre.NONFINCTION;break;
								case "DRAMA" : gen = Genre.DRAMA;break;
								case "SCIENCE" : gen = Genre.SCIENCE;break;
								case "DETECTIVE" : gen = Genre.DETECTIVE;break;
								default: gen = Genre.DETECTIVE;break;
								}
								lb.addBook(gen, title, ath, bkID, year);
								System.out.println("Book is added");
								//Database.save();
								break;
							case 3:
								System.out.println("Enter book id: ");
								String bookID1 = reader.readLine();
								lb.removeBook(bookID1);
								//Database.save();
								break;
							case 4:
								System.out.println("Enter message title: ");
								String title1 = reader.readLine();
								System.out.println("Enter text: ");
								String text1 = reader.readLine();
								lb.sendMessage(title1, text1);
								//Database.save();
								break;
							case 5:
								System.out.println(lb.getMessage());
								break;
							case 6:
								System.out.println("Enter you password: ");
								String oldpws = reader.readLine();
								System.out.println("Enter you  new password: ");
								String newpws = reader.readLine();
								if (lb.changePassword(oldpws, newpws)) {
									System.out.println("Your password has changed");
								}else {
									System.out.println("Error!!!");
								}
								//Database.save();
								break;
							case 7:
								System.out.println(lb.viewNews());
								break;
							case 0:
								System.exit(0);
								
							}
						}
					}else {
						System.out.println("Incorrect password");
					}
				}
			}
		}
	}


}
