package com.digitalbooks.models;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	
	
	
	public Integer getRole_id() {
		return id;
	}

	public void setRole_id(Integer role_id) {
		this.id = role_id;
	}


	public Role() {

	}

	public Role(ERole name) {
		this.name = name;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	
	
}