package com.kyip.api.templateproject.external;

import java.io.Serializable;
import java.util.Date;

public class BasicResponse implements Serializable {

	private static final long serialVersionUID = -1390821302424391096L;

	private Date now;
	private boolean success;

	public Date getNow() {
		return now;
	}

	public void setNow(Date now) {
		this.now = now;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
