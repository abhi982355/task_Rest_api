package user.entity.classes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Integer id;
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_age")
	private Integer age;
	
	@OneToOne(targetEntity = UserDetails.class , cascade = CascadeType .ALL,fetch = FetchType .EAGER)
	@JoinColumn (name="fk_user_details")
	private UserDetails userDetails;
	
	public User() {
		
	}

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User(String name, Integer age, UserDetails userDetails) {
		super();
		this.name = name;
		this.age = age;
		this.userDetails = userDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", userDetails=" + userDetails + "]";
	}
}

