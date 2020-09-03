package com.ps.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ps.model.BasicDto;
import com.ps.model.FEATUREENUM;
import com.ps.model.GAMEENUM;
import com.ps.model.IDINFOENUM;

@Service
public class FFMService {

	private RestTemplate restTemplate;
	private Map<String, Integer> restMap;
	
	private final static String REST_URL = "http://localhost:12300/featureflags";

	public BasicDto[] getDtos(HttpServletRequest request) {
		int[] valArr = getCurValFromBit(request);

		int gameVal = valArr[0];
		int featureVal = valArr[1];
		int idInfoVal = valArr[2];

		BasicDto gameDto = new BasicDto(GAMEENUM.AMERICA_AWGAME.getType(), gameVal);
		BasicDto featureDto = new BasicDto(FEATUREENUM.AMERICA_FEATURE.getType(), featureVal);
		BasicDto IdDto = new BasicDto(IDINFOENUM.AMERICA_ID.getType(), idInfoVal);

		return new BasicDto[] {gameDto, featureDto, IdDto};
	}

	private RestTemplate getRestTemplate() {
		if(restTemplate == null) {
			restTemplate = new RestTemplate();
		}
		return restTemplate;
	}
	private int[] getCurValFromBit(HttpServletRequest request) {
		
		int gameVal = 0;
		int featureVal = 0;
		int idInfoVal = 0;

		for(GAMEENUM iEnum: GAMEENUM.values()) {
			String idStr = request.getParameter(iEnum.getName());
			gameVal *= 2;
			if(idStr != null && idStr.equalsIgnoreCase("On")) {
				gameVal++;
			}
		}

		for(FEATUREENUM iEnum: FEATUREENUM.values()) {
			String idStr = request.getParameter(iEnum.getName());
			featureVal *= 2;
			if(idStr != null && idStr.equalsIgnoreCase("On")) {
				featureVal++;
			}
		}

		for(IDINFOENUM iEnum: IDINFOENUM.values()) {
			String idStr = request.getParameter(iEnum.getName());
			idInfoVal *= 2;
			if(idStr != null && idStr.equalsIgnoreCase("On")) {
				idInfoVal++;
			}
		}
		return new int[] {gameVal, featureVal, idInfoVal};
	}
	public void postNewValue(BasicDto dto) {
		restTemplate = getRestTemplate();

		// post to API
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BasicDto> request = new HttpEntity<>(dto, headers);

		BasicDto[] cDto = restTemplate.postForObject(REST_URL, request, BasicDto[].class);
		
	}

	// getIsON() true(1) -> on false(0) -> off called by JSP
	public boolean isOn(IDINFOENUM iEnum) {
		return get(iEnum.getIndex(), iEnum.getType());
	}
	public boolean isOn(GAMEENUM iEnum) {
		return get(iEnum.getIndex(), iEnum.getType());
	}
	public boolean isOn(FEATUREENUM iEnum) {
		return get(iEnum.getIndex(), iEnum.getType());
	}

	private boolean get(int index, String type) {
		if(restMap == null) {
			restMap = storeRestValsToMap();
		}
		if(restMap.containsKey(type)) {
			return numToBitVal(restMap.get(type), index);
		}else {
			return false;
		}
	}
	// num -> 15 -> 01111 index -> 5 return 0
	private boolean numToBitVal(int num, int index) {

		while(index-- > 1 && num > 0) {
			num /= 2;
		}
		if(num % 2 == 0) {
			return false; // 0 -> off -> false
		}else {
			return true;// 1 -> on -> true
		}
	}
	private Map<String, Integer> storeRestValsToMap() {

		restTemplate = getRestTemplate();
		// GET FROM API
		BasicDto[] dtos = restTemplate.getForObject(REST_URL, BasicDto[].class);

		restMap = new HashMap<>();
		for(BasicDto dto: dtos) {
			restMap.put(dto.getName(), dto.getValue());
		}
		return restMap;
	}
}
