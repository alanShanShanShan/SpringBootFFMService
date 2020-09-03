package com.ps.model;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicDto {
	
	private String name;
	private int value;
	
	public BasicDto() {
		
	}
	public BasicDto(String name, int value) {
		this.name = name;
		this.value = value;
	}
	public BasicDto(String json) throws JsonParseException, JsonMappingException, IOException {
		BasicDto dto = new ObjectMapper().readValue(json, BasicDto.class);
		this.name = dto.name;
		this.value = dto.value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
