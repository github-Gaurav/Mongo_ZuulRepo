package Mongoproject.Mongo.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Mongoproject.Mongo.model.User;
import Mongoproject.Mongo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private  UserRepository repo;
	
	
	public UserController(UserRepository userRepo) {
		this.repo = userRepo;
		
	}
	
	@RequestMapping("/get")
	public List<User> getDetails(){
	System.out.println("Inside Mongo get");	
	
	List<User> user = new ArrayList<>();
	repo.findAll().stream().forEach((u)->{
		user.add(u);
		System.out.println(u.getName());
		});
	 return	user;
	}
	
	@RequestMapping("/get/{name}")
	public User getDetails(@PathVariable String name){
	System.out.println("Inside Mongo get by name");	
	 return	repo.findByName(name);
	}
	
	/*@RequestMapping("/get/{company}")
	public User getDetailsByCompany(@PathVariable String company){
	System.out.println("Inside Mongo get by company");	
	 return	repo.findByCompany(company);
	}*/
	
	
	@RequestMapping(method = RequestMethod.POST, value= "/add")
	public void add(@RequestBody User user){
		System.out.println("About to save user");
		repo.save(user);
		
	}

}
