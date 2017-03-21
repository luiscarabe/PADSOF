package es.uam.eps.padsof.p3;

public abstract class CourseElement {
	private int id;
	private String title;
	private String desc;
	private boolean hidden;
	
	public CourseElement(int id, String title, String desc, boolean hidden) {
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.hidden = hidden;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
	
}
