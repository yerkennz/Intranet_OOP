package Main;

import java.io.Serializable;
import java.util.Vector;

public class Database implements Serializable{
	
	private static Database single_instance = null;

	public static Vector<User> users = new Vector<User>();
	public static Vector<CourseFiles> courseFile = new Vector<CourseFiles>();
	public static Vector<Course> courses = new Vector<Course>();
	public static Vector<News> news = new Vector<News>();
	public static Vector<Request> requests = new Vector<Request>();
	public static Vector<Organization> organizations = new Vector<Organization>();
	public static Vector<Message> messages = new Vector<Message>();
	
	private Database() {
		
	}
	
	public static Database getInstance() {
      if(single_instance == null) {
    	  single_instance = new Database();
      }
       return single_instance;
   }
	

}
