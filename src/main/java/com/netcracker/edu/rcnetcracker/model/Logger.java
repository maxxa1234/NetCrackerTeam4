package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.Date;

@ObjectType(id = 3)
public class Logger {
/*	protected Long logger_id;*/

	@Attribute(id = 13)
	protected Long entrance_id;

	@Attribute(id = 14)
	protected Long eKey_id;

	@Attribute(id = 15, valueType = ValueType.DATE_VALUE)
	protected Date dateAndTime;

	/*public Long getLogger_id() {
		return logger_id;
	}

	public void setLogger_id(Long logger_id) {
		this.logger_id = logger_id;
	}*/

	public Long getEntrance_id() {
		return entrance_id;
	}

	public void setEntrance_id(Long entrance_id) {
		this.entrance_id = entrance_id;
	}

	public Long geteKey_id() {
		return eKey_id;
	}

	public void seteKey_id(Long eKey_id) {
		this.eKey_id = eKey_id;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
}
