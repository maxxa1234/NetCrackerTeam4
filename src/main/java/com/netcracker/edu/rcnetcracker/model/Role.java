package com.netcracker.edu.rcnetcracker.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends BaseEntity {
//	protected Long role_id;
	protected String role;

	public Role(Long id) {
		super(id);
	}
}
