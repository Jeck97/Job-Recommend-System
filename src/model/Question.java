package model;


public class Question {

	private String category1;
	private String category2;
	private String query;
	private String selection1;
	private String selection2;
	
	public Question(String[] data) {
		
		this.category1 = data[0];
		this.category2 = data[1];
		this.query = data[2];
		this.selection1 = data[3];
		this.selection2 = data[4];
		
	}
	
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public String getSelection1() {
		return selection1;
	}
	public void setSelection1(String selection1) {
		this.selection1 = selection1;
	}
	public String getSelection2() {
		return selection2;
	}
	public void setSelection2(String selection2) {
		this.selection2 = selection2;
	}
	
}
