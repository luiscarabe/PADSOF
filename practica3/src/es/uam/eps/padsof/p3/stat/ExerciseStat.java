package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.exercise.Exercise;
import es.uam.eps.padsof.p3.exercise.Question;
import es.uam.eps.padsof.p3.stat.SpecificAnswer;

public class ExerciseStat {
	private int[] qAnswered;
	private int[] wrongAns;
	private int[] rightAns;
	private int[] qNotAnswered;
	private Exercise exercise;
	
	/**
	 * @param exercise
	 */
	public ExerciseStat(Exercise exercise) {
		this.exercise = exercise;
		this.qAnswered = null;
		this.wrongAns = null;
		this.rightAns = null;
		this.qNotAnswered = null;
	}

	/**
	 * @return the qAnswered
	 */
	public int[] getqAnswered() {
		return qAnswered;
	}

	/**
	 * @param qAnswered the qAnswered to set
	 */
	public void setqAnswered(int[] qAnswered) {
		this.qAnswered = qAnswered;
	}

	/**
	 * @return the wrongAns
	 */
	public int[] getWrongAns() {
		return wrongAns;
	}

	/**
	 * @param wrongAns the wrongAns to set
	 */
	public void setWrongAns(int[] wrongAns) {
		this.wrongAns = wrongAns;
	}

	/**
	 * @return the rightAns
	 */
	public int[] getRightAns() {
		return rightAns;
	}

	/**
	 * @param rightAns the rightAns to set
	 */
	public void setRightAns(int[] rightAns) {
		this.rightAns = rightAns;
	}

	/**
	 * @return the qNotAnswered
	 */
	public int[] getqNotAnswered() {
		return qNotAnswered;
	}

	/**
	 * @param qNotAnswered the qNotAnswered to set
	 */
	public void setqNotAnswered(int[] qNotAnswered) {
		this.qNotAnswered = qNotAnswered;
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

	public void setAll(){
		int i = 0;
		for (Question q: this.exercise.getQuestions()){
			for (SpecificAnswer s: this.exercise.getAnswers().get)
		}
	}
	
}
