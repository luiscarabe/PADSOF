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
		int i = 0;
		this.exercise = exercise;
		for (@SuppressWarnings("unused") Question q: exercise.getQuestions()){
			this.qAnswered[i] = 0;
			this.qNotAnswered[i] = 0;
			this.wrongAns[i] = 0;
			this.rightAns[i] = 0;
			i++;
		}
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
	
	/**
	 * Method to fill all the questions stats of the exercise
	 */

	public void setAll(){
		int i = 0;
		for (Question q: this.exercise.getQuestions()){
			for (Answer a: this.exercise.getAnswers()){
				for (SpecificAnswer s: a.getSpecificAnswer()){
					if (q.equals(s.getQuestion())){
						/*We are in a student answer of the question*/
						if(s.getMarkOut10() > 0){
							/*The student has answered correctly*/
							this.rightAns[i] ++;
							this.qAnswered[i] ++;
						}
						else if((s.getMarkOut10() <= 0) && (s.getAnswers() == null)){
							/*The student has answered wrongly*/
							this.wrongAns[i]++;
							this.qAnswered[i] ++;
						}
						else{
							/*The student has not answered*/
							this.qNotAnswered[i] ++;
						}
					}
				}
			}
			i++;
		}
	}
	
}
