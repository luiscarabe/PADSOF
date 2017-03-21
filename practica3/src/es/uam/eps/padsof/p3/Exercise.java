package es.uam.eps.padsof.p3;

public class Exercise extends CourseElement {
	private int weight;
	private int penalty;
	private int numQues;
	private ExerciseStat stats;
	
	
	public Exercise(int id, String title, String desc, boolean hidden, int weight, int penalty, int numQues,
			ExerciseStat stats) {
		super(id, title, desc, hidden);
		this.weight = weight;
		this.penalty = penalty;
		this.numQues = numQues;
		this.stats = stats;
	}
	public int getWeight() {
		return weight;
	}
	public int getNumQues() {
		return numQues;
	}
	public void setNumQues(int numQues) {
		this.numQues = numQues;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	public ExerciseStat getStats() {
		return stats;
	}
	public void setStats(ExerciseStat stats) {
		this.stats = stats;
	}
	

	
	
}
