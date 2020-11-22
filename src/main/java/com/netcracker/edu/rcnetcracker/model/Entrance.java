package com.netcracker.edu.rcnetcracker.model;

public class Entrance {
	protected Long entrance_id;
	protected Long type_id;
	protected Long location_id;
	protected Long role_id;
	protected Long building_id;
	protected String name;
	protected boolean isActive;

	public Long getEntrance_id() {
		return entrance_id;
	}

	public void setEntrance_id(Long entrance_id) {
		this.entrance_id = entrance_id;
	}

	public Long getType_id() {
		return type_id;
	}

	public void setType_id(Long type_id) {
		this.type_id = type_id;
	}

	public Long getLocation_id() {
		return location_id;
	}

	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public Long getBuilding_id() {
		return building_id;
	}

	public void setBuilding_id(Long building_id) {
		this.building_id = building_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
