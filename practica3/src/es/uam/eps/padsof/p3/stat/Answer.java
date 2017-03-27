package es.uam.eps.padsof.p3.stat;

import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;
import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.user.Student;

public class Answer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Exercise exercise;
	private List<SpecificAnswer> specificAnswer;
	private Student student;
	private double markOut10;
	

	public Answer(Exercise exercise, Student student, int nQues) {
		this.exercise = exercise;
		this.specificAnswer = new ArrayList<SpecificAnswer>(nQues);
		this.student = student;
	}


	/**
	 * @return the exercise
	 */
	public Exercise getExercise() {
		return exercise;
	}


	/**
	 * @param exercise the exercise to set
	 */
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}


	/**
	 * @return the specificAnswer
	 */
	public List<SpecificAnswer> getSpecificAnswer() {
		return specificAnswer;
	}


	/**
	 * @param specificAnswer the specificAnswer to set
	 */
	public void setSpecificAnswer(List<SpecificAnswer> specificAnswer) {
		this.specificAnswer = specificAnswer;
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
	 * @return the markOut10
	 */
	public double getMarkOut10() {
		return markOut10;
	}


	/**
	 * @param markOut10 the markOut10 to set
	 */
	public void setMarkOut10(double markOut10) {
		this.markOut10 = markOut10;
	}


	
	
	/* Methods */
	
	/**
	 * Method that informs if an answer is allowed to be shown
	 * @return true if it is false if not
	 */
	public boolean allowedToShow(){
		LocalDate now;
		
		now = LocalDate.now();
		
		return now.isAfter(this.getExercise().getExpDate());
	}
	
	/**
	 * Method that calculates the average mark of a student at an exercise
	 * @return true if it has been calculated false if not
	 */
	public boolean calculateMark(){
		int i = 0;
		double res = 0;
		
		if(this.specificAnswer.isEmpty()){
			return false;
		}else {
			for(SpecificAnswer aux: this.specificAnswer){
				res += aux.getMarkOut10();
				i++;
			}
			this.markOut10 = res/i;
			return true;
		}
	}

	
}
