package es.uam.eps.padsof.p3.educagram;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.user.Professor;
import es.uam.eps.padsof.p3.user.User;
import es.uam.eps.padsof.p3.user.Student;
import java.util.*;
import java.io.*;


public class Educagram implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Course> courses;
	private List<Student> students;
	private Professor professor;
	
	private static final Educagram Instance = new Educagram();
	
	/**
	 * Private constructor of Educagram, it creates an instance of the
	 * several ArrayLists
	 */
	
	private Educagram(){
		courses = new ArrayList<Course>();
		students = new ArrayList<Student>();
		professor = new Professor("Teacher", "teacher@teadu.com", "lovingPADSOF");
	}
    
	/**
	 * @return
	 */
	public static Educagram getInstance(){
		return Educagram.Instance;
	}
	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}
	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}
	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/**
	 * @return the professor
	 */
	public Professor getProfessor() {
		return professor;
	}
	/**
	 * @param professor the professor to set
	 */
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	/**
	 * 
	 * @param title
	 * @return Course c if the course exists or null if not
	 */
	
	public Course searchCourse(String title){
		for (Course c: courses){
			if(c.getTitle().equals(title)){
				return c;
			}
		}
		return null;
	}
	
	public Student searchStudent(String name){
		for (Student s: students){
			if (s.getName().equals(name)){
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Method that checks if a user is valid
	 * @param email
	 * @param psw
	 * @return The user if the email and psw match and null if not
	 */
	
	public User signIn(String email, String psw){
		if (professor.getEmail().equals(email)){
			if (psw == professor.getPassword()){
				return professor;
			}
		}
		
		for (Student s: students){
			if (s.getEmail().equals(email)){
				if (psw.equals(s.getPassword())){
					return s;
				}
			}	
		}
		return null;
	}	
	
	/**
	 * Method that reads the information of the students at the app from a file and saves it
	 * @return true if 
	 * @throws java.io.IOException
	 */
	public boolean readFile() throws java.io.IOException{
		String cadena;
		String[] str = new String[5];
		StringTokenizer tokens;
		int i;
		
		FileReader f = new FileReader("Educagram.txt");
	    BufferedReader b = new BufferedReader(f);
	    b.readLine();
	    

	    while((cadena = b.readLine())!=null) {
	        tokens = new StringTokenizer(cadena, ";");
	        i = 0;
	        while(tokens.hasMoreTokens() && i < 5){
	        	str[i] = tokens.nextToken();
	        	i++;
	        }
	        if(EmailSystem.isValidEmailAddr(str[2])){
	        	Student s = new Student(str[0] + " " + str[1], str[2], str[4]);
		        this.students.add(s);
	        }
	    }
	    b.close();
	    if(this.students.isEmpty()){
	    	return false;
	    }
	    return true;
	}
}
