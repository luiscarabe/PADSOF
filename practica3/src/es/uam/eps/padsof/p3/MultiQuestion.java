package es.uam.eps.padsof.p3;

public class MultiQuestion extends MUQuestion{
	private Option solution[];
	private int numSol;
	

	public MultiQuestion(String title, int weight, Option[] answers, int numAns, boolean randomOrder, Option[] solution,
			int numSol) {
		super(title, weight, answers, numAns, randomOrder);
		this.solution = solution;
		this.numSol = numSol;
	}
	public Option[] getSolution() {
		return solution;
	}
	public void setSolution(Option[] solution) {
		this.solution = solution;
	}
	public int getNumSol() {
		return numSol;
	}
	public void setNumSol(int numSol) {
		this.numSol = numSol;
	}
	
}
