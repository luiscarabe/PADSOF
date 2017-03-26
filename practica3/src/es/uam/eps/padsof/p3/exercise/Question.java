package es.uam.eps.padsof.p3.exercise;

public abstract class Question {
	private String title;
	private int weight;
	
	/**
	 * @param title
	 * @param weight
	 */
	public Question(String title, int weight) {
		this.title = title;
		this.weight = weight;
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
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

	
}
