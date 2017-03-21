package es.uam.eps.padsof.p3;

public class UniqQuestion extends MUQuestion{
	private Option solution;

	public UniqQuestion(String title, int weight, Option[] answers, int numAns, boolean randomOrder, Option solution) {
		super(title, weight, answers, numAns, randomOrder);
		this.solution = solution;
	}

	public Option getSolution() {
		return solution;
	}

	public void setSolution(Option solution) {
		this.solution = solution;
	}
	
	
}
