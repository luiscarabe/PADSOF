package es.uam.eps.padsof.p3.exercise;

public abstract class MUQuestion extends Question{
	private Option answers[];
	private int numAns;
	private boolean randomOrder;
	
	
	public MUQuestion(String title, int weight, Option[] answers, int numAns, boolean randomOrder) {
		super(title, weight);
		this.answers = answers;
		this.numAns = numAns;
		this.randomOrder = randomOrder;
	}
	public Option[] getAnswers() {
		return answers;
	}
	public void setAnswers(Option[] answers) {
		this.answers = answers;
	}
	public int getNumAns() {
		return numAns;
	}
	public void setNumAns(int numAns) {
		this.numAns = numAns;
	}

	public boolean isRandomOrder() {
		return randomOrder;
	}

	public void setRandomOrder(boolean randomOrder) {
		this.randomOrder = randomOrder;
	}
	
}
