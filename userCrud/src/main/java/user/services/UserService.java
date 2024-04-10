package user.services;

import java.util.Optional;

import user.entity.classes.User;
import user.entity.classes.UserDetails;

public interface UserService {
	
	// for save new user
    public User saveUserWithDetails(User user);
	
    // find all user data (fetch all data)
	public Iterable<User> findAllUserData();
	
	// update user and user details
	public User updateUserAndDetails(User user);
	
	// delete user with the help of id
	public Boolean deleteUser(Integer id);
	
	// find user with the help of id
	public User findUserByID(Integer id);
	
}
