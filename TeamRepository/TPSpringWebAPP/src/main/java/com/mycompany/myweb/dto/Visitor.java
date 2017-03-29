package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Visitor {
	private int vid;
	private int vrid;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date vdate;
	private String vday;
	private boolean vstate; //1 은 열림 0은 닫힘
	private int count;
	
	public String getVday() {
		return vday;
	}
	public void setVday(String vday) {
		this.vday = vday;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getVrid() {
		return vrid;
	}
	public void setVrid(int vrid) {
		this.vrid = vrid;
	}
	public Date getVdate() {
		return vdate;
	}
	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}
	public boolean isVstate() {
		return vstate;
	}
	public void setVstate(boolean vstate) {
		this.vstate = vstate;
	}
	

	
}
