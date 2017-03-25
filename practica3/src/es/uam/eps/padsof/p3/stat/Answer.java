package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.user.Student;

public class Answer {
	private Exercise exercise;
	private SpecificAnswer specificAnswer[];
	private Student student;
	private double markOut10;
	private double num; // numerator
	

	public Answer(Exercise exercise, SpecificAnswer[] specificAnswer, Student student, double markOut10, double num) {
		this.exercise = exercise;
		this.specificAnswer = specificAnswer;
		this.student = student;
		this.markOut10 = markOut10;
		this.num = num;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	public SpecificAnswer[] getSpecificAnswer() {
		return specificAnswer;
	}
	public void setSpecificAnswer(SpecificAnswer[] specificAnswer) {
		this.specificAnswer = specificAnswer;
	}
	public double getMarkOut10() {
		return markOut10;
	}
	public void setMarkOut10(double markOut10) {
		this.markOut10 = markOut10;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	
	
}
