package com.github.sample.controller;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;






@RestController
public class GithubController {
	
	@Autowired
	HttpServletRequest request;
	
	 private final Logger LOGGER = LoggerFactory.getLogger(GithubController.class.getName());
	 
	@PostMapping("/webhook")
	public ResponseEntity<String> gitHubRequest( @RequestBody JsonNode Payload	){
		   LOGGER.info("Start ::gitHubRequest");
		   LOGGER.info("Payload-----------"+Payload);
		   String header = request.getHeader("testing");
		   LOGGER.info("header-----------"+header);
			StringBuffer baseUrl = request.getRequestURL();
			  LOGGER.info("baseUrl-----------"+baseUrl);
		  String response = "hello from controller..........";
		  HttpHeaders responseHeaders = new HttpHeaders();
	        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
	        LOGGER.info("End ::gitHubRequest");
		  return new ResponseEntity<String>(response, responseHeaders, HttpStatus.CREATED);
	}
	

}
