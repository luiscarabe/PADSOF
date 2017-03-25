package es.uam.eps.padsof.p3.user;

import es.uam.eps.padsof.p3.course.*;
import es.uam.eps.padsof.p3.educagram.Educagram;
import java.util.*;

public class Professor extends User {
	
	private List<Course> allCourses;
	
	/**
	 * Constructor of Professor
	 * @param name
	 * @param email
	 * @param password
	 */
	public Professor(String name, String email, String password) {
		super(name, email, password);
		allCourses = new ArrayList<Course>();
		
	}
	
	/**
	 * @return the allCourses
	 */
	public List<Course> getAllCourses() {
		return allCourses;
	}
	
	/* Methods */
	
	/**
	 * Create a new Course
	 * @param title
	 * @param desc
	 * @return Course if the creation of the course success null if not
	 */
	public Course createCourse(String title, String desc){
		Course c;
		
		c = new Course(title, desc);
		
		for(Course aux: this.allCourses){
			if(aux.equals(c)){
				return null;
			}
		}
		this.getAllCourses().add(c);
		
		Educagram.getInstance().setCourses(this.allCourses);
		return c;
		
	}
	
	/**
	 * Method that allows the professor to accept or decline an application
	 * @param a
	 * @param bool
	 */
	public void acceptApplication(Application a, boolean bool){
		if(bool == true){
			a.acceptApplication();
		}else {
			a.declineApplication();
		}
	}
	
	/**
	 * Method that allows the professor to expel a student from a course
	 * @param s Student to expel
	 * @param c Course
	 * @return
	 */
	public boolean expellStudent(Student s, Course c){
		return c.expellStudent(s);
	}
	
	/**
	 * Method that allows the professor to readmit a student in a course
	 * @param s Student to readmit
	 * @param c Course
	 * @return
	 */
	public boolean readmitStudent(Student s, Course c){
		return c.readmitStudent(s);
	}
	
	
}
