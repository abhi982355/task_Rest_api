package user.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.dao.layer.UserDao;
import user.entity.classes.User;
import user.entity.classes.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUserWithDetails(User user) {
		if(user!=null) {
			User newUser = this.userDao.save(user);
			return newUser;
		}
		return null;
	}

	@Override
	public User updateUserAndDetails(User user) {
		if(userIsPresent(user.getId())) {
			User updateUser = userDao.save(user);
			return updateUser;
		}
		return null;
	}
	
	// check user is exists or not;
		public Boolean userIsPresent(Integer id) {
			return userDao.existsById(id);
		}

	@Override
	public Boolean deleteUser(Integer id) {
		if(userIsPresent(id)) {
			userDao.deleteById(id); // if successfully deleted then show true;
		}
		return !userIsPresent(id);  // otherwise return false.
	}

	@Override
	public Iterable<User> findAllUserData() {
		return userDao.findAll();
	}

	@Override
	public User updateUserByName(String name) {
		return this.userDao.findByName(name);
	}

	@Override
	public User findUserByID(Integer id) {
		return this.userDao.findById(id).get();
	}

	@Override
	public User updateUserById(Integer id) {
		return this.userDao.findById(id).get();
	}



}
