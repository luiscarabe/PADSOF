package es.uam.eps.padsof.p3.exercise;

import java.util.*;

public class TFQuestion extends Question {
	private List<Option> solution;

	/**
	 * @param title
	 * @param weight
	 */
	public TFQuestion(String title, int weight, Exercise exer) {
		super(title, weight, exer);
		this.solution = null;
	}

	/**
	 * @return the solution
	 */
	public List<Option> getSolution() {
		return solution;
	}


	/**
	 * 
	 * @param s
	 * @return true if created successfully, false if not
	 */
	public boolean setSolution(Option solution) {
		if(solution.getOption().equals("f") || solution.getOption().equals("t")){
			this.solution.add(solution);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Method to remove a solution
	 * @param sol
	 * @return true if it has been succesfully deleted, false if not
	 */
	
	public boolean deleteSolution(Option sol){
		if(this.solution.equals(sol)){
			this.solution = null;
			return true;
		}
		return false;
	}
	
	
}
