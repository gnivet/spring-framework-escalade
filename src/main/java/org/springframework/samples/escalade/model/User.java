package org.springframework.samples.escalade.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.core.style.ToStringCreator;



@Entity
@Table(name = "users")
public class User  {

	private Integer id;
	private String username;
	private String password;
	private String passwordConfirm;
	private Set<Role> roles;
	private String firstName;
	private String lastName;
	private String address;
	private String postalCode;
	private String city;
	private String telephone;
	private String email;
	private Boolean enabled;
	
		
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	@ManyToMany
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
	public Set<Role> getRoles() {
		return roles;
	}

	
	
	
	public void addSite(Site site) {
		// TODO Auto-generated method stub

	}

	public Object getSite(String name, boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
	

	@Transient
	public User getusername() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 public boolean isNew() {
	        return this.id == null;
	    }
	
	 
	
	public void setNew(boolean isNew) {
	}
 	*/
	 
	@Override
    public String toString() {
        return new ToStringCreator(this)

            .append("id", this.getId())
            //.append("new", this.isNew())
            .append("lastName", this.getLastName())
            .append("firstName", this.getFirstName())
            .append("address", this.address)
            .append("city", this.city)
            .append("telephone", this.telephone)
            .toString();
    }

	/*
	 * 
	 */
	public User getusername(User User ) {
		return User.getusername();
		// TODO Auto-generated method stub
		
	} 

	/*
	 * Ajout 9/3 2020
	 *
	 */
	
	@ManyToMany(mappedBy="user")
    public List <Site> sites;
	
	
	
	
	
	/**
	 * 
	 */
	public User() {
	}

	
	

	
	
	
}