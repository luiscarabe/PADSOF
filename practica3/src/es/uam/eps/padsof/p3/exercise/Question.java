package es.uam.eps.padsof.p3.exercise;

public abstract class Question {
	private String title;
	private int weight;
	
	public Question(String title, int weight) {
		this.title = title;
		this.weight = weight;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
