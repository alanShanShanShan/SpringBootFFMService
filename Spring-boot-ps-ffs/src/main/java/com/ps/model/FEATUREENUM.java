package com.ps.model;

public enum FEATUREENUM {
	
	
	ASIAN_FEATURE("Asian_Feature", 5, "useNewFeature"), KOREA_FEATURE("Korea_Feature", 4, "useNewFeature"), 
	EUROPE_FEATURE("Europe_Feature", 3, "useNewFeature"), JAPAN_FEATURE("Japan_Feature", 2, "useNewFeature"), 
	AMERICA_FEATURE("America_Feature", 1, "useNewFeature");
	
	private String name;
	private int index;
	private String type;
	
	FEATUREENUM(String name, int index, String type){
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
