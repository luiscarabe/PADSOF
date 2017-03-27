package es.uam.eps.padsof.p3.exercise;

import java.util.List;

public class UniqQuestion extends MUQuestion{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Option> solution;
	
	/**
	 * @param title
	 * @param weight
	 * @param answers
	 * @param numAns
	 * @param randomOrder
	 * @param solution
	 */
	public UniqQuestion(String title, int weight, int numAns, boolean randomOrder, Exercise exer) {
		super(title, weight, numAns, randomOrder, exer);
		this.solution = null;
	}
	

	/**
	 * @return the solution
	 */
	public List<Option> getSolution() {
		return solution;
	}


	/**
	 * @param solution the solution to set
	 */
	public void setSolution(List<Option> solution) {
		this.solution = solution;
	}


	/**
	 * 
	 * @param s
	 * @return true if created successfully, false if not
	 */
	public boolean setSolution(Option o) {
		if (!this.getAnswers().contains(o)){
			return false;
		}
		this.solution.add(o);
		return true;
	}
	
	/**
	 * Method to delete an option
	 * @param sol
	 * @return true if it has been successfully deleted, false if not
	 */
	
	public boolean deleteOption(Option sol){
		if(this.solution.equals(sol)){
			this.solution = null;
		}
		if(this.getAnswers().contains(sol)){
			this.getAnswers().remove(sol);
			this.setNumAns(this.getNumAns()-1);
			return true;
		}
		return false;
	}
	
}
