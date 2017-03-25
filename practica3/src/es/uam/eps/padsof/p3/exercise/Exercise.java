package es.uam.eps.padsof.p3.exercise;

import java.util.*;
import es.uam.eps.padsof.p3.course.CourseElement;
import es.uam.eps.padsof.p3.stat.ExerciseStat;
import java.time.*;

public class Exercise extends CourseElement {
	private int weight;
	private int penalty;
	private int numQues;
	private boolean randomness;
	private ExerciseStat stats;
	private List<Question> questions;
	private LocalDate expDate;
	private LocalDate startDate;
	
	/**
	 * Constructor of Exercise
	 * @param title
	 * @param desc
	 * @param hidden
	 * @param weight
	 * @param penalty
	 * @param numQues
	 * @param randomness
	 * @param stats
	 * @param questions
	 * @param startDate
	 * @param expDate
	 */
	public Exercise(String title, String desc, boolean hidden, int weight, int penalty, int numQues, boolean randomness,
			ExerciseStat stats, ArrayList<Question> questions, LocalDate startDate, LocalDate expDate) {
		super(title, desc, hidden);
		this.weight = weight;
		this.penalty = penalty;
		this.randomness = randomness;
		this.numQues = numQues;
		this.stats = stats;
		this.questions = questions;
		this.startDate = startDate;
		this.expDate = expDate;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the penalty
	 */
	public int getPenalty() {
		return penalty;
	}

	/**
	 * @param penalty the penalty to set
	 */
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	/**
	 * @return the numQues
	 */
	public int getNumQues() {
		return numQues;
	}

	/**
	 * @param numQues the numQues to set
	 */
	public void setNumQues(int numQues) {
		this.numQues = numQues;
	}

	/**
	 * @return the randomness
	 */
	public boolean isRandomness() {
		return randomness;
	}

	/**
	 * @param randomness the randomness to set
	 */
	public void setRandomness(boolean randomness) {
		this.randomness = randomness;
	}

	/**
	 * @return the stats
	 */
	public ExerciseStat getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(ExerciseStat stats) {
		this.stats = stats;
	}

	/**
	 * @return the questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	/**
	 * @return the expDate
	 */
	public LocalDate getExpDate() {
		return expDate;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	
	
	
	
}
