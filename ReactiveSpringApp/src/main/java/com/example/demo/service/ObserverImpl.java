package com.example.demo.service;

import com.example.demo.model.User;

import io.reactivex.observables.GroupedObservable;


public class ObserverImpl {
	
	private  UserDataSearch userDataSearch = new UserDataSearch();
	
	public void printAllData(){
		
		userDataSearch.getAllData().subscribe(u->System.out.println(u));
		System.out.println("Results After filter");
		userDataSearch.getAllData().filter(u->u.getName().equalsIgnoreCase("Ankush")).subscribe(System.out::println);
		System.out.println("Map Operation As Adapter");
		userDataSearch.getAllData().map(u->u.getName()).subscribe(System.out::println);
		System.out.println("Operation for Group By");
		userDataSearch.getAllData().groupBy(u-> u.getName().contains("Gaurav") ? "Gaurav" : "Other").subscribe(u->u.subscribe(d -> show(u,d)));
		
	}
	
	private void show(GroupedObservable<String, User> u, User d) {
		
		if("Gaurav".equalsIgnoreCase(u.getKey())){
			System.out.println("Gaurav: " + d);
			
		}else {
			System.out.println("Others: "+ d);
		}
	}

	public static void main(String[] args) {
		
		ObserverImpl obs = new ObserverImpl();
		obs.printAllData();
		
		
	}

}
