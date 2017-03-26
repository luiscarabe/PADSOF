package es.uam.eps.padsof.p3.exercise;

public class TFQuestion extends Question {
	private Option solution;

	/**
	 * @param title
	 * @param weight
	 */
	public TFQuestion(String title, int weight) {
		super(title, weight);
		this.solution = null;
	}

	/**
	 * @return the solution
	 */
	public Option getSolution() {
		return solution;
	}

	/**
	 * 
	 * @param s
	 * @return true if created successfully, false if not
	 */
	public boolean setSolution(String s) {
		Option solution;
		if(s.equals("f") || s.equals("t")){
			solution = new Option("s");
			this.solution = solution;
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
