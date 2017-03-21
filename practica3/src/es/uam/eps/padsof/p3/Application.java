package es.uam.eps.padsof.p3;

public class Application {
	private boolean accepted;
	private Course course;
	private Student student;
	
	public Application(boolean accepted, Course course, Student student) {
		this.accepted = accepted;
		this.course = course;
		this.student = student;
	}
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
