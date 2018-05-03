package Mongoproject.Mongo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Mongoproject.Mongo.model.User;
import Mongoproject.Mongo.repository.UserRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import rx.Observable;
import rx.functions.Func1;

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


	@RequestMapping("/getDetails")
	public List<String> getDetailsByRx(){
		System.out.println("Inside Mongo getDetailsByRx ");	
		HashMap<String, String> hm = new HashMap<>();
		Observable<List<User>>  usr = Observable.just(repo.findAll());
		System.out.println("The rx details are "+usr.subscribe(u->System.out.println(u.get(1).getCompany())));
		List<User> lst =       usr.toBlocking().first();
		//ResponseEntity<String> res = usr.toBlocking().subscribe(subscriber);
		// System.out.println("The data after blocking"+lst.get(1).getCompany());
		/*List<User> user = new ArrayList<>();
	repo.findAll().stream().forEach((u)->{
		user.add(u);
		System.out.println(u.getName());
		});*/
		List<String> lstt = new ArrayList<String>();
		Observable.just(repo.findAll()).map(u->u.get(0).getCompany()).subscribe(u->lstt.add(u));
		Observable.just(repo.findAll()).subscribe(u-> lstt.add(u.get(0).getCompany()));

		return lstt;

		/*return repo.findAll()   
		       .map(new Func1<User, Object>() {
		                @Override
		                public Object call(User u) {
		                    // ..
		                    // apply your logic here
		                    // ..
		                    return myDataObject; // return you data here to subcribers
		                }
		            });
	 return	usr;
	}*/
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
