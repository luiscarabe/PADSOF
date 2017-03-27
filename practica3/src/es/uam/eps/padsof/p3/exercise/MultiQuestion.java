package es.uam.eps.padsof.p3.exercise;

import java.util.*;

public class MultiQuestion extends MUQuestion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Option> solution;
	private int numSol;
	
	/**
	 * @param title
	 * @param weight
	 * @param numAns
	 * @param randomOrder
	 * @param solution
	 * @param numSol
	 */
	public MultiQuestion(String title, int weight, int numAns, boolean randomOrder, Exercise exer) {
		super(title, weight, numAns, randomOrder, exer);
		this.solution = new ArrayList<Option>();
		this.numSol = 0;
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
	 * @return the numSol
	 */
	public int getNumSol() {
		return numSol;
	}

	/**
	 * @param numSol the numSol to set
	 */
	public void setNumSol(int numSol) {
		this.numSol = numSol;
	}
	/**
	 * Method to add solution
	 * @param sol
	 * @return true if added successfully, false if not
	 */
	
	public boolean addSolution(Option o){
		if (!this.getAnswers().contains(o)){
			return false;
		}
		this.solution.add(o);
		this.numSol ++;
		return true;
	}
	
	/**
	 * Method to delete an option
	 * @param sol
	 * @return true if it has been successfully deleted, false if not
	 */
	
	public boolean deleteOption(Option sol){
		if(this.solution.contains(sol)){
			this.solution.remove(sol);
			this.numSol --;
		}
		if(this.getAnswers().contains(sol)){
			this.getAnswers().remove(sol);
			this.setNumAns(this.getNumAns()-1);
			return true;
		}
		return false;
	}
	
}
