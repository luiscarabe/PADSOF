package es.uam.eps.padsof.p3;

public class Unit extends CourseElement {
	private CourseElement courElem[];

	public Unit(int id, String title, String desc, boolean hidden, CourseElement[] courElem) {
		super(id, title, desc, hidden);
		this.courElem = courElem;
	}
	
	public CourseElement[] getCourElem() {
		return courElem;
	}

	public void setCourElem(CourseElement[] courElem) {
		this.courElem = courElem;
	}

	
}
