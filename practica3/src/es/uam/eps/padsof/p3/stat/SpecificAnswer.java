package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.exercise.Option;
import es.uam.eps.padsof.p3.exercise.Question;

import java.io.Serializable;
import java.util.*;

public class SpecificAnswer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Question question;
	private List<Option> answers;
	private double markOut10;
	/**
	 * Constructor of SpecificAnswer
	 * @param question
	 */
	public SpecificAnswer(Question question) {
		this.question = question;
		this.answers = new ArrayList<Option>();
		this.markOut10 = -1;
	}
	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}
	/**
	 * @return the answers
	 */
	public List<Option> getAnswers() {
		return answers;
	}
	/**
	 * @param answers the answers to set
	 */
	public void setAnswers(List<Option> answers) {
		this.answers = answers;
	}
	/**
	 * @return the markOut10
	 */
	public double getMarkOut10() {
		return markOut10;
	}
	/**
	 * @param markOut10 the markOut10 to set
	 */
	public void setMarkOut10(double markOut10) {
		this.markOut10 = markOut10;
	}
	/**
	 * Method to choose an option
	 * @param o
	 * @return
	 */
	
	public boolean chooseAnswer(Option o){
		if (this.answers.contains(o)){
			return false;
		}
		this.answers.add(o);
		return true;
	}
	
	/**
	 * MEthod to delete an answer
	 * @param o
	 */
	
	public void deleteAnswer(Option o){
		if (this.answers.contains(o)){
			this.answers.remove(o);
		}
	}
	/**
	 * Method to calculate the mark of a question
	 * @return true if it has been successfully calculated, false if not
	 */
	
	public void calculateMark(){
		int flag = 0;
		if (this.answers.isEmpty()){
			this.markOut10 = 0;
			return;
		}
		if (this.answers.size() != this.question.getSolution().size()){
			this.markOut10 = (0-this.question.getExer().getPenalty())/this.question.getExer().getWeight();
			return;
		}
		for  (Option o: this.answers){
			if (!this.question.getSolution().contains(o)){
				flag = 1;
			}
		}
		if (flag == 1){
			this.markOut10 = (0-this.question.getExer().getPenalty())/this.question.getExer().getWeight();
			return;
		}
		else{
			this.markOut10 = this.question.getWeight()/this.question.getExer().getWeight();
			return;
		}
	}
	
}
