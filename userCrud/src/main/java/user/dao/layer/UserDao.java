package user.dao.layer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.entity.classes.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	public User findByName(String name);
}
