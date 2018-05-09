package crudApp.crudDemo.mapper;

import crudApp.crudDemo.DTO.UserDTO;
import crudApp.crudDemo.entity.User;

public class UserMapper {


	public static UserDTO map(User user){

		System.out.println("Inside Mapper UserDTO");
		return (user == null ? null : new UserDTO(user.getAddress(),user.getAge(), user.getDob(), user.getEmail(), user.getMobNo(), user.getName()));
	}


	public static User map(UserDTO user){

		System.out.println("Inside Mapper User");
		return (user == null ? null : new User(user.getAddress(),user.getAge(), user.getDob(), user.getEmail(), user.getMobNo(), user.getName()));
	}

}
