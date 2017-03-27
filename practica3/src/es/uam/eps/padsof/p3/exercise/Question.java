package es.uam.eps.padsof.p3.exercise;

import java.util.List;

public abstract class Question {
	private String title;
	private double weight;
	private Exercise exer;

	/**
	 * @param title
	 * @param weight
	 */
	public Question(String title, int weight, Exercise exe) {
		this.title = title;
		this.weight = weight;
		this.exer = exe;
	}

	/**
	 * @return the exer
	 */
	public Exercise getExer() {
		return exer;
	}

	/**
	 * @param exer the exer to set
	 */
	public void setExer(Exercise exer) {
		this.exer = exer;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract List<Option> getSolution();
	
}
