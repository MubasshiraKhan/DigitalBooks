package com.digitalbooks.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
public class Role {
	
	private Integer id;

	private ERole name;

}