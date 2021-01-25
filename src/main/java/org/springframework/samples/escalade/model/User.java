	package org.springframework.samples.escalade.model;
	
	import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
	
	
	@Entity
	//@NamedQuery(name="User.findTopoBkgByUserName", query="SELECT DISTINCT topoBkg, user FROM User user left join fetch User.topoBkgs WHERE user.userName = :userName")
	@Table(name = "users")
	public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		//@NotEmpty(message = "Please enter your user name.")
		@Column(name="userName")
		private String userName;
		
		//@NotEmpty(message = "Please enter your password.")
		@Column(name ="password")
		private String password;
		
		//@NotEmpty(message = "Please enter your password confirm.")
		@Column(name="passwordConfirm")
		private String passwordConfirm;
		
		//@NotEmpty(message = "Please enter your first name.")
		@Column(name="firstName")
		private String firstName;
		//@NotEmpty(message = "Please enter your last name.")
		@Column(name="lastName")
		private String lastName;
		@Column(name="address")
		private String address;
		@Column(name="postalCode")
		private String postalCode;
		@Column(name="city")
		private String city;
		//@NotEmpty(message = "Please enter your telephone number.")
		@Column(name="telephone")
		private String telephone;
		//@NotEmpty(message = "Please enter your email addresss.")
		@Column(name="email")
		private String email;
		@Column(name="enabled")
		private Boolean enabled;
	
		@OneToMany(targetEntity = Site.class, mappedBy = "user")
		public List<Site> sites;
		
				
		@ManyToMany
		@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
		private Set<Role> roles;
	
	
		@OneToMany(targetEntity = Topo.class, cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
		private Set<Topo> topos;
	
		@OneToMany(targetEntity = TopoBkg.class, cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
		private Set<TopoBkg> topoBkgs;
				
					
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public List<Site> getSites() {
			return sites;
		}

		public void setSites(List<Site> sites) {
			this.sites = sites;
		}

		public void addSite(Site site) {
			// TODO Auto-generated method stub
	
		}
	
		public Object getSite(String name, boolean b) {
			// TODO Auto-generated method stub
			return null;
		}
		
				
		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
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

		public Set<Topo> getTopos() {
			return topos;
		}

		public void setTopos(Set<Topo> topos) {
			this.topos = topos;
		}

		public Set<TopoBkg> getTopoBkgs() {
			return topoBkgs;
		}

		public void setTopoBkgs(Set<TopoBkg> topoBkgs) {
			this.topoBkgs = topoBkgs;
		}

		
		public List<Topo> getTopoList() {
			return topoList;
		}

		public void setTopoList(List<Topo> topoList) {
			this.topoList = topoList;
		}

			
	
		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		/**
		 * 
		 */
		public User()
		{
			
		}
	
		

		
		
		/**
		 * @param id
		 * @param userName
		 * @param password
		 * @param passwordConfirm
		 * @param firstName
		 * @param lastName
		 * @param address
		 * @param postalCode
		 * @param city
		 * @param telephone
		 * @param email
		 * @param enabled
		 * @param sites
		 * @param roles
		 * @param topos
		 * @param topoBkgs
		 * @param topoList
		 */
		public User(Integer id, String userName, String password, String passwordConfirm, String firstName,
				String lastName, String address, String postalCode, String city, String telephone, String email,
				Boolean enabled, List<Site> sites, Set<Role> roles, Set<Topo> topos, Set<TopoBkg> topoBkgs,
				List<Topo> topoList) {
			this.id = id;
			this.userName = userName;
			this.password = password;
			this.passwordConfirm = passwordConfirm;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.postalCode = postalCode;
			this.city = city;
			this.telephone = telephone;
			this.email = email;
			this.enabled = enabled;
			this.sites = sites;
			this.roles = roles;
			this.topos = topos;
			this.topoBkgs = topoBkgs;
			this.topoList = topoList;
		}

		public void addTopoBkg(TopoBkg topoBkg) {
			// TODO Auto-generated method stub
			
		}
		/*
		 * R Bi-directionelle
		 */
		@OneToMany(cascade = {CascadeType.ALL}, mappedBy="user" )	
		private List<Topo> topoList= new ArrayList<>();
		
		
		public void addTopo(Topo topo)
		{
			topo.setTopo(topo);
			
		}
		
	}