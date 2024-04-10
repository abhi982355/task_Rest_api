package user.entity.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_details_id")
	private Integer userDetailsId;

	@Column(name = "user_address")
	private String Address;

	public UserDetails() {

	}

	public UserDetails(String address) {
		super();
		Address = address;
	}

	public Integer getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "UserDetails [userDetailsId=" + userDetailsId + ", Address=" + Address + "]";
	}

}
