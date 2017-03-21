package es.uam.eps.padsof.p3;

public class Note extends CourseElement {
	private String text;

	public Note(int id, String title, String desc, boolean hidden, String text) {
		super(id, title, desc, hidden);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
