package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.course.Course;
public class CMark {
	private double courseMark;
	private Course course;

	public CMark(double courseMark) {
		this.courseMark = courseMark;
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

	
	
	
}
