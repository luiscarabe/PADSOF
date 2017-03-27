package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.course.Course;
import es.uam.eps.padsof.p3.user.Student;

public class CMark {
	private double courseMark;
	private Course course;
	private Student student;
	
	/**
	 * @param courseMark
	 * @param course
	 * @param student
	 */
	public CMark(Course course, Student student) {
		this.course = course;
		this.student = student;
		this.courseMark = -1;
	}

	/**
	 * @return the courseMark
	 */
	public double getCourseMark() {
		return courseMark;
	}

	/**
	 * @param courseMark the courseMark to set
	 */
	public void setCourseMark(double courseMark) {
		this.courseMark = courseMark;
	}

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
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
	/**
	 * Method to calculate the course mark of a student
	 */
	
	public void calculateCMark(){
		double aux = 0;
		int i = 0;
		for (Answer a: this.getStudent().getAnswers()){
			if (a.getExercise().getCourse().equals(this.course)){
				if(a.allowedToShow()){
					aux += a.getMarkOut10();
					i++;
				}
			}
		}
		aux /= i;
		this.courseMark = aux;
	}
		
}
