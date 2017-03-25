package es.uam.eps.padsof.p3.user;

import es.uam.eps.padsof.p3.course.Course;

public class Application {
	private Course course;
	private Student appliedStudent;
	
	/**
	 * Constructor of Application
	 * @param course
	 * @param student
	 */
	
	public Application(Course course, Student student) {
		this.course = course;
		this.appliedStudent = student;
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
	 * @return the appliedStudent
	 */
	public Student getAppliedStudent() {
		return appliedStudent;
	}

	/**
	 * @param appliedStudent the appliedStudent to set
	 */
	public void setAppliedStudent(Student appliedStudent) {
		this.appliedStudent = appliedStudent;
	}
	
	/* Methods */
	/**
	 * Method that deletes an application
	 */
	public void deleteApplication(){
		this.getCourse().getApplications().remove(this);
		this.getAppliedStudent().getAppliedCourses().remove(this);
	}
	
	/**
	 * Method that accepts a student in a course
	 */
	public void acceptApplication(){
		this.getCourse().getEnrolledStudents().add(this.getAppliedStudent());
		this.getAppliedStudent().getEnrolledCourses().add(this.getCourse());
		
		this.deleteApplication();
	}
	
	/**
	 * Method that denies the application for a course
	 */
	public void declineApplication(){
		this.deleteApplication();
	}
}
