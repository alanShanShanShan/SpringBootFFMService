package com.ps.model;

public enum IDINFOENUM {
	
	ASIAN_ID("Asian_Id", 5, "Identity_Information"), KOREA_ID("Korea_Id", 4, "Identity_Information"), 
	EUROPE_ID("Europe_Id", 3, "Identity_Information"), JAPAN_ID("Japan_Id", 2, "Identity_Information"), 
	AMERICA_ID("America_Id", 1, "Identity_Information");
	
	private String name;
	//index in form
	private int index;
	private String type;
	
	IDINFOENUM(String name, int index, String type){
		this.name = name;
		this.index = index;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
