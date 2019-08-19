package com.example.test.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.DTO.UEDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/test")
public class ConsulTestController {

	ObjectMapper mapper = new ObjectMapper();
	
	
	@Value("${var1}")
	String testVar;
	
	@Value("${UE}")
	String UEmap;
	
	@GetMapping("/getConsul")
	public void test() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("testVar"+testVar);
		System.out.println("UE config"+ UEmap);
		Map<String, UEDTO> UEMap2 = mapper.readValue(UEmap, Map.class); 
		System.out.println(UEMap2);
		UEDTO ueobj = UEMap2.get("preRequest");
		System.out.println(ueobj.getIsEanabled());
		
		
	}
}
