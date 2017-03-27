package es.uam.eps.padsof.p3.exercise;

import java.io.Serializable;

public class Option implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String option;

	/**
	 * @param option
	 */
	public Option(String option) {
		super();
		this.option = option;
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}
	
	
}
