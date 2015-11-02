package com.demo.zmq.Client.model;

public class Status {
    public static final int STATUS_OK = 200;

	private int status;
	private String[] msg;

	//getters
	public int getStatus() {
		return this.status;
	}
	public String[] getMsg() {
		return this.msg;
	}

	//setters
	public void setStatus(int i) {
		this.status = i;
	}
	public void setMsg(String[] s) {
		this.msg = s;
	}
}

