package es.uam.eps.padsof.p3.course;

import java.util.*;
import java.time.*;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.exercise.Question;
import es.uam.eps.padsof.p3.stat.ExerciseStat;

public class Unit extends CourseElement {
	private Course course;
	private List<CourseElement> courseElements;

	/**
	 * Constructor of Unit
	 * @param title
	 * @param desc
	 * @param hidden
	 */
	public Unit(String title, String desc, boolean hidden, Course course) {
		super(title, desc, hidden);
		this.course = course;
		this.courseElements = new ArrayList<CourseElement>();
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
	
	
	
	/* Method */

	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Method that creates a unit associated to a course
	 * @param title
	 * @param desc
	 * @param hidden
	 * @return
	 */
	public boolean createSubUnit(String title, String desc, boolean hidden){
		CourseElement ce;
		
		
		ce = new Unit(title, desc, hidden, this.course);
		
		for(CourseElement aux: this.courseElements){
			if(ce.equals(aux)){
				return false;
			}
		}
		this.courseElements.add(ce);
		this.getCourse().getCourseElements().add(ce);
		return true;
	}
	
	public boolean deleteSubUnit()
	
	/**
	 * Method that creates a note associated to a unit and its course
	 * @param title
	 * @param desc
	 * @param hidden
	 * @return
	 */
	public boolean createNote(String title, String desc, boolean hidden, String text){
		CourseElement ce;
		
		
		ce = new Note(title, desc, hidden, text);
		
		for(CourseElement aux: this.courseElements){
			if(ce.equals(aux)){
				return false;
			}
		}
		this.courseElements.add(ce);
		this.getCourse().getCourseElements().add(ce);
		return true;
	}
	
	/**
	 * Method that deletes a note from a unit and its course
	 * @param n
	 * @return
	 */
	public boolean deleteNote(Note n){
		if(this.courseElements.contains(n)){
			this.courseElements.remove(n);
			this.course.getCourseElements().remove(n);
			return true;
		}
		return false;
	}
	/**
	 * Method that creates a note associated to a unit and its course
	 * @param title
	 * @param desc
	 * @param hidden
	 * @return
	 */
	public boolean createExercise(String title, String desc, boolean hidden, int weight, int penalty, int numQues, boolean randomness,
			ExerciseStat stats, ArrayList<Question> questions, LocalDate startDate, LocalDate expDate){
		CourseElement ce;
		
		
		ce = new Exercise(title, desc, hidden, weight, penalty, numQues, randomness, stats, questions, startDate, expDate);
		
		for(CourseElement aux: this.courseElements){
			if(ce.equals(aux)){
				return false;
			}
		}
		this.courseElements.add(ce);
		this.getCourse().getCourseElements().add(ce);
		return true;
	}
	

	
}
