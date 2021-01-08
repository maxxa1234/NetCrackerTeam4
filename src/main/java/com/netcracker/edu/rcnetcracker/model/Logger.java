package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.util.Date;

@ObjectType(id = 1)
public class Logger extends BaseEntity {
/*	protected Long logger_id;*/

	@Attribute(id = 1)
	protected Entrance entrance;

	@Attribute(id = 2)
	protected Ekey eKey;

	@Attribute(id = 3, valueType = ValueType.DATE_VALUE)
	protected Date date;

	@Attribute(id = 4, valueType = ValueType.DATE_VALUE)
	protected String time;

	public Entrance getEntranceId() {
		return entrance;
	}

	public void setEntranceId(Entrance entrance) {
		this.entrance = entrance;
	}

	public Ekey geteKeyId() {
		return eKey;
	}

	public void seteKeyId(Ekey eKey) {
		this.eKey = eKey;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
