package es.uam.eps.padsof.p3.exercise;

public class TFQuestion extends Question {
	private Option solution;
	
	public TFQuestion(String title, int weight, Option solution) {
		super(title, weight);
		this.solution = solution;
	}

	public Option getSolution() {
		return solution;
	}

	public void setSolution(Option solution) {
		this.solution = solution;
	}
	
	
}
