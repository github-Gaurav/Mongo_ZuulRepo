package crudApp.crudDemo.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import crudApp.crudDemo.DTO.UserDTO;
import crudApp.crudDemo.mapper.UserMapper;
import crudApp.crudDemo.service.UserService;
import io.reactivex.Single;

@RestController
public class UserResource {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Single<ResponseEntity<UserDTO>> addUser(@RequestBody UserDTO userDTO){
		
	System.out.println("inside addUser controller package");
	 return	Single.just(userDTO)
			// .doOnSuccess(userDTO.getAddress())
			 .map(UserMapper::map)
		.flatMap(u->userService.addUser(u))
		.map(UserMapper::map)
		.map(p-> new ResponseEntity<UserDTO>(p, HttpStatus.CREATED));
	 
	}
	
	@GetMapping("/get/{id}")
	public Single<ResponseEntity<UserDTO>> getUserById(@PathVariable String id){
		System.out.println("Inside getUserById method");
				
	 return	Single.just(id).flatMap(u->userService.getById(u))
		.map(UserMapper::map).map(p-> new ResponseEntity<UserDTO>(p, HttpStatus.OK));
	}
	
	@GetMapping("/name/{name}")
	public Single<ResponseEntity<UserDTO>> getUserByName(@PathVariable String name){
		
	/* return Single.just(userService.getByUserName(name))
			 .map(UserMapper::map)
			 .map(p-> new ResponseEntity<UserDTO>(p, HttpStatus.OK));
	 
	// Single.just(name).flatMap(u->userService.getByUserName(u))
		*/
		return  null;
	}
	
	@GetMapping("/getDetails")
	public Single<ResponseEntity<List<UserDTO>>> getAll(){
		return null;
		
	}

}
