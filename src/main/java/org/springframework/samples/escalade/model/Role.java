package org.springframework.samples.escalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "roles", //
		uniqueConstraints = { //
				@UniqueConstraint(name = "ROLE_UK", columnNames = "Role_Name") })
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_entity_generator")
	@SequenceGenerator(name = "base_entity_generator", sequenceName = "base_entity_sequence")
	@Column(name = "Role_Id", nullable = false)
	protected Long roleId;

	@Column(name = "Role_Name", length = 30, nullable = false)
	private String roleName;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}