package com.ps.model;

public enum GAMEENUM {
	
	ASIAN_AWGAME("Asian_Awgame", 5, "useAwesomeGames"), KOREA_AWGAME("Korea_Awgame", 4, "useAwesomeGames"), 
	EUROPE_AWGAME("Europe_Awgame", 3, "useAwesomeGames"), JAPAN_AWGAME("Japan_Awgame", 2, "useAwesomeGames"), 
	AMERICA_AWGAME("America_Awgame", 1, "useAwesomeGames");
	
	private String name;
	private int index;
	private String type;
	
	GAMEENUM(String name, int index, String type){
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
