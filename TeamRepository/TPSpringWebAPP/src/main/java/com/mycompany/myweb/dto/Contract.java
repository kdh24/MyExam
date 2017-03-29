package com.mycompany.myweb.dto;

public class Contract {
	private int cid;
	private int crid;
	private boolean cfire;
	private boolean cgas;
	private boolean ctemperature;
	private boolean cvisitor;
	private boolean cview;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public int getCrid() {
		return crid;
	}
	public void setCrid(int crid) {
		this.crid = crid;
	}
	public boolean isCfire() {
		return cfire;
	}
	public void setCfire(boolean cfire) {
		this.cfire = cfire;
	}
	public boolean isCgas() {
		return cgas;
	}
	public void setCgas(boolean cgas) {
		this.cgas = cgas;
	}
	public boolean isCtemperature() {
		return ctemperature;
	}
	public void setCtemperature(boolean ctemperature) {
		this.ctemperature = ctemperature;
	}
	public boolean isCvisitor() {
		return cvisitor;
	}
	public void setCvisitor(boolean cvisitor) {
		this.cvisitor = cvisitor;
	}
	public boolean isCview() {
		return cview;
	}
	public void setCview(boolean cview) {
		this.cview = cview;
	}
	
}
