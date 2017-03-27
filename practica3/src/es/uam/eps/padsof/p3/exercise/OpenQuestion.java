package es.uam.eps.padsof.p3.exercise;

import java.util.*;

public class OpenQuestion extends Question{
	private List<Option> solution;

	/**
	 * @param title
	 * @param weight
	 * @param solution
	 */
	public OpenQuestion(String title, int weight, Exercise exer) {
		super(title, weight, exer);
		this.solution = new ArrayList<Option>();
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
	 * Method to add a solution
	 * @param sol
	 */

	public void setSolution(Option sol){
		this.solution.add(sol);
	}
	
	/**
	 * Method to remove a solution
	 * @param sol
	 * @return true if it has been succesfully deleted, false if not
	 */
	
	public boolean deleteSolution(Option sol){
		if(this.solution.contains(sol)){
			this.solution.remove(sol);
			return true;
		}
		return false;
	}

}
