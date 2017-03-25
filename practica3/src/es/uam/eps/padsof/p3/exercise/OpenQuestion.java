package es.uam.eps.padsof.p3.exercise;

public class OpenQuestion extends Question{
	private Option solution[];

	public OpenQuestion(String title, int weight, Option solution[]) {
		super(title, weight);
		this.solution = solution;
	}

	public Option[] getSolution() {
		return solution;
	}

	public void setSolution(Option solution[]) {
		this.solution = solution;
	}

}
