package es.uam.eps.padsof.p3.course;

import es.uam.eps.padsof.p3.user.*;

import java.util.*;

import es.uam.eps.padsof.p3.stat.CourseStat;
import es.uam.eps.padsof.p3.exercise.*;

public class Course {
	private int id;
	private String title;
	private String desc;
	private CourseStat courseStat;
	private List<Student> enrolledStudents;
	private List<Student> expelledStudents;
	private static int lastId = 0;
	private List<Application> applications;
	private List<CourseElement> courseElements;
	
	



	/**
	 * Constructor of Course
	 * @param id
	 * @param title
	 * @param desc
	 */
	
	public Course(String title, String desc) {
		lastId = lastId + 1;
		this.id = lastId;
		this.title = title;
		this.desc = desc;
		this.enrolledStudents = new ArrayList<Student>();
		this.expelledStudents = new ArrayList<Student>();
		this.courseElements = new ArrayList<CourseElement>();
		this.applications = new ArrayList<Application>();
	}
	
	/**
	 * @return the courseElements
	 */
	public List<CourseElement> getCourseElements() {
		return courseElements;
	}



	/**
	 * @param courseElements the courseElements to set
	 */
	public void setCourseElements(List<CourseElement> courseElements) {
		this.courseElements = courseElements;
	}

	

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the courseStat
	 */
	public CourseStat getCourseStat() {
		return courseStat;
	}

	/**
	 * @param courseStat the courseStat to set
	 */
	public void setCourseStat(CourseStat courseStat) {
		this.courseStat = courseStat;
	}

	/**
	 * @return the enrolledStudents
	 */
	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}

	/**
	 * @param enrolledStudents the enrolledStudents to set
	 */
	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	/**
	 * @return the expelledStudents
	 */
	public List<Student> getExpelledStudents() {
		return expelledStudents;
	}

	/**
	 * @param expelledStudents the expelledStudents to set
	 */
	public void setExpelledStudents(List<Student> expelledStudents) {
		this.expelledStudents = expelledStudents;
	}

	/**
	 * @return the lastId
	 */
	public static int getLastId() {
		return lastId;
	}
	
	/**
	 * @return the applications
	 */
	public List<Application> getApplications() {
		return applications;
	}

	/**
	 * @param applications the applications to set
	 */
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	/* Methods */
	
	/**
	 * Method that creates a unit associated to a course
	 * @param title
	 * @param desc
	 * @param hidden
	 * @return
	 */
	public boolean createUnit(String title, String desc, boolean hidden){
		CourseElement ce;
		
		
		ce = new Unit(title, desc, hidden, this);
		
		for(CourseElement aux: this.courseElements){
			if(ce.equals(aux)){
				return false;
			}
		}
		this.courseElements.add(ce);
		return true;
	}
	/**
	 * 
	 * @param u unit to delete
	 * @return true if the unit has been deleted false if not
	 */
	public boolean deleteUnit(Unit u){
		if(this.courseElements.contains(u)){
			for(CourseElement aux: u.getCourseElements()){
				if(aux instanceof Unit){
					Unit other = (Unit) aux;
					u.deleteSubUnit(other);
				}
				if(aux instanceof Note){
					Note other = (Note) aux;
					u.deleteNote(other);
				}
				if(aux instanceof Exercise){
					Exercise other = (Exercise) aux;
					u.deleteExercise(other);
				}
			}
			this.courseElements.remove(u);
			return true;
		}
		return false;
	}
	
	/**
	 * Method that informs if a student is enrolled in a course
	 * @param student
	 * @return
	 */
	public boolean acceptedStudent(Student student){
		if(enrolledStudents.contains(student)){
			return true;
		}
		return false;
	}
	/**
	 * Method that returns the average mark associated to a course
	 * @return double mark out of 10
	 */
	
	public double getTotalAverage(){
		return this.getCourseStat().getAverageMark();
	}
	
	/**
	 * Method that expels a student from a course
	 * @param s Student
	 * @return true if the student has been expelled false if not
	 */
	public boolean expellStudent(Student s){
		if(this.acceptedStudent(s)){
			this.enrolledStudents.remove(s);
			this.expelledStudents.add(s);
			s.getEnrolledCourses().remove(this);
			s.getExpelledCourses().add(this);
			return true;
		}
		return false;
	}
	
	/**
	 * Method that re-admits a student in a course
	 * @param s Student to re-admit
	 * @return true if the student has been re-admitted false if not
	 */
	public boolean readmitStudent(Student s){
		if(this.expelledStudents.contains(s)){
			this.expelledStudents.remove(s);
			this.enrolledStudents.add(s);
			s.getExpelledCourses().remove(this);
			s.getEnrolledCourses().add(this);
			return true;
		}
		return false;
	}
	
	/**
	 * Method that search an application of a student passed by argument
	 * @param s student of the application to search
	 * @return Application if the student has applied for the course null if not
	 */
	public Application searchApplication(Student s){
		for(Application aux: this.getApplications()){
			if(aux.getAppliedStudent().equals(s)){
				return aux;
			}
		}
		return null;
	}
	

	/**
	 *  Function equals that compares the id of two courses
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (id != other.id || title != other.title)
			return false;
		return true;
	}
	
	
	
	
}
