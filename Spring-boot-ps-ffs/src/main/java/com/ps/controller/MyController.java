package com.ps.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ps.model.BasicDto;
import com.ps.service.FFMService;

@Controller
public class MyController{
	
	private FFMService service = new FFMService();
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}
	
	@PostMapping("/updateFF")
	public String save(HttpServletRequest request, HttpServletResponse response) {
		BasicDto[] dtos = service.getDtos(request);
		for(BasicDto dto: dtos) {
			service.postNewValue(dto);
		}
		return "welcome";
	}
	
}