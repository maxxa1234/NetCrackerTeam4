package com.netcracker.edu.rcnetcracker.model;

public class Ekey {
	protected Long eKey_id;
	protected String keyCode;
	protected Boolean isActive;

	public long geteKey_id() {
		return eKey_id;
	}

	public void seteKey_id(long eKey_id) {
		this.eKey_id = eKey_id;
	}

	public String getKeyCode() {
		return keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}
}
