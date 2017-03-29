package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Gas {
	private int gid;
	private int grid;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date gdate;
	private String gday;
	private double ggas;	//###.# 형태로 DB에 저장됨
	private boolean gstate;
	private int count;
	
	public String getGday() {
		return gday;
	}
	public void setGday(String gday) {
		this.gday = gday;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getGrid() {
		return grid;
	}
	public void setGrid(int grid) {
		this.grid = grid;
	}
	public Date getGdate() {
		return gdate;
	}
	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	public double getGgas() {
		return ggas;
	}
	public void setGgas(double ggas) {
		this.ggas = ggas;
	}
	public boolean isGstate() {
		return gstate;
	}
	public void setGstate(boolean gstate) {
		this.gstate = gstate;
	}
	
	
	
}
