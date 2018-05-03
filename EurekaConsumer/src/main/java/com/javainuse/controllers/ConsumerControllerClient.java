package com.javainuse.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
	String port;
	
	
	@RequestMapping("/get/{id}")
	public String getEmployee(@PathVariable String id) throws RestClientException, IOException {
		System.out.println("Inside get employee "+ "--->" + "Request is coming from--> " + port);
		List<ServiceInstance> instances=discoveryClient.getInstances("School-Service");
		instances.stream().forEach((u)->{
			
			System.out.println(u.getHost());
			String test = String.valueOf(u.getPort());
			System.out.println("The test host is "+ test);
			
		});
		ServiceInstance serviceInstance=instances.get(0);
		System.out.println("The Service id is "+serviceInstance.getServiceId() + "the port is " + serviceInstance.getPort());
		String baseUrl=serviceInstance.getUri().toString();
		baseUrl=baseUrl+"/get/"+id ;
		System.out.println("The Base Url is "+ baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
		instances=discoveryClient.getInstances("MONGO-SERVICE");
		baseUrl=instances.get(0).getUri().toString();
		System.out.println("The mongo URl"+ baseUrl);
		baseUrl=baseUrl+"/get";
		System.out.println("The  Mongo Base Url is "+ baseUrl);
		ResponseEntity<String> resMongo=null;
		try{
			
			resMongo=restTemplate.exchange(baseUrl,
					HttpMethod.GET, getHeaders(),String.class);
			System.out.println("The Mongo Response is" + resMongo.getBody());
			}catch (Exception ex)
			{
				System.out.println(ex);
			}
		System.out.println("The School service Response is "+ response.getBody());
		return response.getBody() + "-->Mongo details--> " + resMongo.getBody();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}