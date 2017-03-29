package com.mycompany.myweb.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BoardAS {
	private int bano;
	private String batitle;
	private String bacontent;
	private String bawriter;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date badate;
	
	public BoardAS(){}
	
	public BoardAS(int bano, String batitle, String bacontent, String bawriter, Date badate) {
		this.bano = bano;
		this.batitle = batitle;
		this.bacontent = bacontent;
		this.bawriter = bawriter;
		this.badate = badate;
	}

	public int getBano() {
		return bano;
	}

	public void setBano(int bano) {
		this.bano = bano;
	}

	public String getBatitle() {
		return batitle;
	}

	public void setBatitle(String batitle) {
		this.batitle = batitle;
	}

	public String getBacontent() {
		return bacontent;
	}

	public void setBacontent(String bacontent) {
		this.bacontent = bacontent;
	}

	public String getBawriter() {
		return bawriter;
	}

	public void setBawriter(String bawriter) {
		this.bawriter = bawriter;
	}

	public Date getBadate() {
		return badate;
	}

	public void setBadate(Date badate) {
		this.badate = badate;
	}
	
	
	
}
