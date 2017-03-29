package com.mycompany.myweb.dto;

public class Room {
	private int rid;
	private String rname;
	private String rmid;
	private boolean rempty;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRmid() {
		return rmid;
	}
	public void setRmid(String rmid) {
		this.rmid = rmid;
	}
	public boolean isRempty() {
		return rempty;
	}
	public void setRempty(boolean rempty) {
		this.rempty = rempty;
	}
	
}
