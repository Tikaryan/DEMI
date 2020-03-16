package com.example.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE_TBL")
public class RolesDO {
	
	@Id
	@Column(name="ID",unique = true, nullable = false)
	@GeneratedValue	(generator= "system-increment")
	private Integer id;
	
	@Column(name="ROLEID")
	private Integer roleId;
	
	@Column(name="ROLE")
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
