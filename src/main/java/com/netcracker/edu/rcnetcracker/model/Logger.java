package com.netcracker.edu.rcnetcracker.model;

import com.netcracker.edu.rcnetcracker.db.annotations.Attribute;
import com.netcracker.edu.rcnetcracker.db.annotations.ObjectType;
import com.netcracker.edu.rcnetcracker.db.annotations.ValueType;

import java.sql.Time;
import java.util.Date;

@ObjectType(id = 1)
public class Logger extends BaseEntity {
/*	protected Long logger_id;*/

	@Attribute(id = 1)
	protected Long entranceId;

	@Attribute(id = 2)
	protected Long eKeyId;

	@Attribute(id = 3, valueType = ValueType.DATE_VALUE)
	protected String date;

	@Attribute(id = 4, valueType = ValueType.DATE_VALUE)
	protected String time;

	public Long getEntranceId() {
		return entranceId;
	}

	public void setEntranceId(Long entranceId) {
		this.entranceId = entranceId;
	}

	public Long geteKeyId() {
		return eKeyId;
	}

	public void seteKeyId(Long eKeyId) {
		this.eKeyId = eKeyId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
