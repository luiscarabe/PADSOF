package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.exercise.Exercise;

public class ExerciseStat {
	private int averageMark;
	private int qAnswered;
	private int wrongAns;
	private int rightAns;
	private int qNotAnswered;
	private Exercise exercise;
	
	
	
	public ExerciseStat(int averageMark, int qAnswered, int wrongAns, int rightAns, int qNotAnswered,
			Exercise exercise) {
		this.averageMark = averageMark;
		this.qAnswered = qAnswered;
		this.wrongAns = wrongAns;
		this.rightAns = rightAns;
		this.qNotAnswered = qNotAnswered;
		this.exercise = exercise;
	}
	public int getAverageMark() {
		return averageMark;
	}
	public void setAverageMark(int averageMark) {
		this.averageMark = averageMark;
	}
	public int getqAnswered() {
		return qAnswered;
	}
	public void setqAnswered(int qAnswered) {
		this.qAnswered = qAnswered;
	}
	public int getWrongAns() {
		return wrongAns;
	}
	public void setWrongAns(int wrongAns) {
		this.wrongAns = wrongAns;
	}
	public int getRightAns() {
		return rightAns;
	}
	public void setRightAns(int rightAns) {
		this.rightAns = rightAns;
	}
	public int getqNotAnswered() {
		return qNotAnswered;
	}
	public void setqNotAnswered(int qNotAnswered) {
		this.qNotAnswered = qNotAnswered;
	}
	public Exercise getExercise() {
		return exercise;
	}
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
	
}
