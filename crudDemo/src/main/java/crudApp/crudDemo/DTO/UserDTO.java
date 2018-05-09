/*This Class represents DTO and used for mapping for entity object
 *
 * Author : Gaurav
 * */

package crudApp.crudDemo.DTO;


public class UserDTO {


	private String name;
	private String age;
	private String address;
	private String dob;
	private String email;
	private String mobNo;

	public UserDTO(){}
	
	public UserDTO(String name, String age, String address, String dob, String email, String mobNo) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.mobNo = mobNo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
}
