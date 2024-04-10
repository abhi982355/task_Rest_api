package user.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import user.entity.classes.MappingModelClass;
import user.entity.classes.User;
import user.entity.classes.UserDetails;
import user.services.UserService;

@RestController
@RequestMapping("/user")
public class Controller {

	@Autowired
	private UserService userService;
	
	@PostMapping("/save") // new user create
	public ResponseEntity<User> saveUserWithDetails(@RequestBody MappingModelClass model){
		User user = new User();
		user.setName(model.getUserName());
		user.setAge(model.getUserAge());
		
		UserDetails details = new UserDetails(model.getUserAddress());
		user.setUserDetails(details);
		
		User saveNewUser = this.userService.saveUserWithDetails(user);
		System.out.println(saveNewUser);
		
	//	return ResponseEntity.status(HttpStatus.OK).body(saveNewUser);
		return new ResponseEntity<User>(saveNewUser,HttpStatus.OK);
	}
	
	@GetMapping("/users") // get all users data
	public ResponseEntity<Iterable<User>> fetchAllData(){
		Iterable<User> users = userService.findAllUserData();
		return new ResponseEntity<Iterable<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("{id}") // get user by id
	public ResponseEntity<User> getUserDataById(@PathVariable Integer id) throws Exception{
	    User user = userService.findUserByID(id);
	    return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}") // delete user with the help of id
	public ResponseEntity<Boolean> deleteUser(@PathVariable Integer id){
		Boolean delete = userService.deleteUser(id);
		return new ResponseEntity<Boolean>(delete,HttpStatus.OK);
	}
	
	@PutMapping("/update") // update user
	public ResponseEntity<User> updateUserWithDetails(@RequestBody User user){
		User update = userService.updateUserAndDetails(user);
		return new ResponseEntity<User>(update,HttpStatus.OK);
	}
	
	@PutMapping("/update/{name}") // update user with the help of name
	public ResponseEntity<User> updateWithTheHelpOfName(@PathVariable String name,@RequestBody User user){
		User u = userService.updateUserByName(name);
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setUserDetails(user.getUserDetails());
		
		User updateUser = userService.saveUserWithDetails(user);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}") // update user with the the help of id
	public ResponseEntity<User> updateUserWithHelpOfId(@PathVariable Integer id,@RequestBody User user){
		User u = userService.findUserByID(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setUserDetails(user.getUserDetails());
		
		User updateUser = userService.saveUserWithDetails(user);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
	}
}
