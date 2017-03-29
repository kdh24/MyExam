package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.BoardNoticeDao;
import com.mycompany.myweb.dto.BoardNotice;

@Component
public class BoardNoticeService {
	
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private BoardNoticeDao boardNoticeDao;
	
	public List<BoardNotice> list(int pageNo, int rowsPerPage){
		return boardNoticeDao.selectByPage(pageNo, rowsPerPage);
	}
	
	public List<BoardNotice> listByTitle(String btitle , int pageNo, int rowsPerPage){
		return boardNoticeDao.selectByTitle(btitle, pageNo, rowsPerPage);
	}
	
	public int write(BoardNotice boardNotice){
		int row = boardNoticeDao.insert(boardNotice);
		if(row == 0) { return WRITE_FAIL; }
		return WRITE_SUCCESS;
	}
	
	public int modify(BoardNotice boardNotice){
		int row = boardNoticeDao.update(boardNotice);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int bno){
		int row = boardNoticeDao.delete(bno);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public BoardNotice info(int bno){
		return boardNoticeDao.selectByBno(bno);
	}
	
	public int getcount(){
		return boardNoticeDao.count();
	}
	public int getcountByTitle(String btitle){
		return boardNoticeDao.countByTitle(btitle);
	}
}
