package es.uam.eps.padsof.p3.exercise;

import java.util.*;

public class MultiQuestion extends MUQuestion{
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
	public MultiQuestion(String title, int weight, int numAns, boolean randomOrder) {
		super(title, weight, numAns, randomOrder);
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
	 */
	
	public void addSolution(String sol){
		Option opt;
		opt = new Option(sol);
		this.solution.add(opt);
		this.numSol ++;
	}
	
	/**
	 * Method to remove a solution
	 * @param sol
	 * @return true if it has been successfully deleted, false if not
	 */
	
	public boolean deleteSolution(Option sol){
		if(this.solution.contains(sol)){
			this.solution.remove(sol);
			this.numSol --;
			return true;
		}
		return false;
	}
	
}
