package es.uam.eps.padsof.p3.stat;

import es.uam.eps.padsof.p3.exercise.Option;
import es.uam.eps.padsof.p3.exercise.Question;

public class SpecificAnswer {
	private Question question;
	private Option option[];
	private double markOut10;
	private double num; //numerator
	
	public SpecificAnswer(Question question, Option[] option, double markOut10, double num) {
		this.question = question;
		this.option = option;
		this.markOut10 = markOut10;
		this.num = num;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Option[] getOption() {
		return option;
	}
	public void setOption(Option[] option) {
		this.option = option;
	}
	public double getMarkOut10() {
		return markOut10;
	}
	public void setMarkOut10(double markOut10) {
		this.markOut10 = markOut10;
	}
	public double getNum() {
		return num;
	}
	public void setNum(double num) {
		this.num = num;
	}
	
	
	
}
