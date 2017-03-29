package com.mycompany.myweb.dto;

import javax.servlet.http.HttpSession;

public class BoardPage {
	private int intPageNo;
	private int rowsPerPage;
	private int pagesPerGroup;
	private int totalBoardNo;
	private int totalPageNo;
	private int totalGroupNo;
	private int groupNo;
	private int startPageNo;
	private int endPageNo;
	
	public BoardPage() {
	}

	public BoardPage(String pageNum, HttpSession session) {
		if(pageNum == null){
			pageNum = (String) session.getAttribute("pageNum");
			if(pageNum != null){
				this.intPageNo = Integer.parseInt(pageNum);
			} else {
				this.intPageNo = 1;
			}
		}else {
			this.intPageNo = Integer.parseInt(pageNum);
			session.setAttribute("pageNum", String.valueOf(intPageNo));
		}
	}
	
	public BoardPage(String pageNum, HttpSession session, int rowsPerPage, int pagesPerGroup, int totalBoardNo) {
		if(pageNum == null){
			pageNum = (String) session.getAttribute("pageNum");
			if(pageNum != null){
				this.intPageNo = Integer.parseInt(pageNum);
			}
		}else {
			this.intPageNo = Integer.parseInt(pageNum);
			session.setAttribute("pageNum", String.valueOf(pageNum));
		}
		this.rowsPerPage = rowsPerPage;
		this.pagesPerGroup = pagesPerGroup;
		this.totalBoardNo = totalBoardNo;
	}

	
	public void setPageConfig(int rowsPerPage, int pagesPerGroup, int totalBoardNo) {
		this.rowsPerPage = rowsPerPage;
		this.pagesPerGroup = pagesPerGroup;
		this.totalBoardNo = totalBoardNo;
	}
	
	public int getPageNum() {
		return intPageNo;
	}

	public void setPageNum(int pageNum) {
		this.intPageNo = pageNum;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getPagesPerGroup() {
		return pagesPerGroup;
	}

	public void setPagesPerGroup(int pagesPerGroup) {
		this.pagesPerGroup = pagesPerGroup;
	}

	public int getTotalBoardNo() {
		return totalBoardNo;
	}

	public void setTotalBoardNo(int totalBoardNo) {
		this.totalBoardNo = totalBoardNo;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo() {
		this.totalPageNo = totalBoardNo/rowsPerPage + ((totalBoardNo%rowsPerPage!=0)?1:0);
	}

	public int getTotalGroupNo() {
		return totalGroupNo;
	}

	public void setTotalGroupNo() {
		this.totalGroupNo = (totalPageNo/pagesPerGroup) + ((totalPageNo%pagesPerGroup!=0)?1:0);
	}

	public int getGroupNo() {
		return groupNo;
	}

	public void setGroupNo() {
		this.groupNo =(this.intPageNo-1)/pagesPerGroup + 1;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo() {
		this.startPageNo = (groupNo-1)*pagesPerGroup + 1;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo() {
		this.endPageNo = startPageNo + pagesPerGroup - 1;
	}
	
	public void setTotalPageConfig(){
		setTotalPageNo();
		setTotalGroupNo();
		setGroupNo();
		setStartPageNo();
		setEndPageNo();
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
	}
}
