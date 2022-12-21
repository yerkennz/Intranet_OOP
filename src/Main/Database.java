package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Database implements Serializable{
	
	private static Database single_instance = null;
	private static Database singleInstance;
	public static Vector<User> users = new Vector<User>();
	public static Vector<CourseFiles> courseFile = new Vector<CourseFiles>();
	public static Vector<Course> courses = new Vector<Course>();
	public static Vector<News> news = new Vector<News>();
	public static Vector<Request> requests = new Vector<Request>();
	public static Vector<Organization> organizations = new Vector<Organization>();
	public static Vector<Message> messages = new Vector<Message>();
	
	private Database() {
		
	}
//	static {
//		if(new File("C:\\Users\\Nursultan\\eclipse-workspace\\FINAL\\data").exists()) {
//			try {
//				singleInstance = save();
//			}
//			catch(Exception e) {
//			    e.printStackTrace();
//			}
//		}
//	}
//	public static Database getInstance() {
//		if(singleInstance==null) {
//			singleInstance = new Database();
//		}
//		return singleInstance;
//	}
//	public static void read() throws ClassNotFoundException,FileNotFoundException, IOException {
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\Nursultan\\eclipse-workspace\\FINAL\\data");
//	    ObjectOutputStream oos = new ObjectOutputStream(fos);
//	    oos.writeObject(Database.getInstance());
//	    oos.flush();
//	    oos.close();
//	}
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static ObjectOutputStream oos;
	public static ObjectInputStream oin;
//	public static Database save() throws ClassNotFoundException, IOException {
//		FileInputStream fis = new FileInputStream("C:\\Users\\Nursultan\\eclipse-workspace\\FINAL\\data");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		Database data = Database.getInstance();
//		data = (Database) ois.readObject();
//		Database.singleInstance = data;
//		fis.close();
//		ois.close();
//		return data;
//	}
	public static void save() {
		saveCourses();
		saveCourseFiles();
		saveMessages();
		saveNews();
		saveUsers();
		saveOrganization();
        
	}
	
	public static void read() {
		readCourses();
		readCourseFiles();
		readMessages();
		readNews();
		readUsers();
		readOrganization();
	}
	
	private static void saveUsers() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("users.txt"))) {
            oot.writeObject(users);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("users.txt: IOException");
        }
    }
	private static void readUsers() {
    	try {
        	fis = new FileInputStream("users.txt");
        	oin = new ObjectInputStream(fis); 
            users = (Vector<User>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            users = new Vector<>();
            System.err.println("users.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            users = new Vector<>();
            System.err.println("users.txt: ClassNotFoundException");
        }   
    }
	
	private static void saveCourses() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("courses.txt"))) {
            oot.writeObject(courses);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("courses.txt: IOException");
        }
    }

    private static void saveNews() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("news.txt"))) {
            oot.writeObject(news);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("news.txt: IOException");
        }
    }
    
    private static void saveMessages() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("messages.txt"))) {
            oot.writeObject(messages);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("messages.txt: IOException");
        }
    }
    
    private static void readCourses(){
    	try {
        	fis = new FileInputStream("courses.txt");
        	oin = new ObjectInputStream(fis); 
            courses = (Vector<Course>) oin.readObject();
            oin.close();
            fis.close();
        }
        catch (ClassNotFoundException e) {
            courses = new Vector<>();
            System.err.println("courses.txt: ClassNotFoundException");
        }
        catch (IOException e) {
            courses = new Vector<>();
            System.err.println("courses.txt: IOException");
        }
    }
    
    private static void readNews() {
        try {
        	fis = new FileInputStream("news.txt");
        	oin = new ObjectInputStream(fis); 
            news = (Vector<News>) oin.readObject();
            oin.close();
            fis.close();
        }
        catch (ClassNotFoundException e) {
            news = new Vector<>();
            System.err.println("news.txt: ClassNotFoundException");
        }
        catch (IOException e) {
            news = new Vector<>();
            System.err.println("news.txt: IOException");
        }
    }
    
    private static void readMessages() {
    	try {
        	fis = new FileInputStream("messages.txt");
        	oin = new ObjectInputStream(fis); 
            messages = (Vector<Message>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            messages = new Vector<>();
            System.err.println("messages.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            messages = new Vector<>();
            System.err.println("messages.txt: ClassNotFoundException");
        }
    }
    
    
    private static void saveOrganization() {
        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("organizations.txt"))) {
            oot.writeObject(organizations);
            oot.flush();
        }
        catch (IOException e) {
            System.err.println("organizations.txt: IOException");
        }
    }
	private static void readOrganization() {
    	try {
        	fis = new FileInputStream("users.txt");
        	oin = new ObjectInputStream(fis); 
            organizations = (Vector<Organization>) oin.readObject();
            oin.close();
            fis.close();
    	}
        catch (IOException e) {
            organizations = new Vector<>();
            System.err.println("organizations.txt: IOException");
        }
        catch (ClassNotFoundException e) {
            organizations = new Vector<>();
            System.err.println("organizations.txt: ClassNotFoundException");
        }   
    }
	 private static void saveCourseFiles() {
	        try (ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream("coureFiles.txt"))) {
	            oot.writeObject(courseFile);
	            oot.flush();
	        }
	        catch (IOException e) {
	            System.err.println("courseFiles.txt: IOException");
	        }
	    }
		private static void readCourseFiles() {
	    	try {
	        	fis = new FileInputStream("courseFiles.txt");
	        	oin = new ObjectInputStream(fis); 
	            courseFile = (Vector<CourseFiles>) oin.readObject();
	            oin.close();
	            fis.close();
	    	}
	        catch (IOException e) {
	        	courseFile = new Vector<>();
	            System.err.println("courseFiles.txt: IOException");
	        }
	        catch (ClassNotFoundException e) {
	        	courseFile = new Vector<>();
	            System.err.println("courseFiles.txt: ClassNotFoundException");
	        }   
	    }
}
	
	

