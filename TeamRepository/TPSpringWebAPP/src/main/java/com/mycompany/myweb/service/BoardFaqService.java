package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.BoardFaqDao;
import com.mycompany.myweb.dto.BoardFaq;

@Component
public class BoardFaqService {
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private BoardFaqDao boardFaqDao;
	
	public List<BoardFaq> list(int pageNo, int rowsPerPage){
		return boardFaqDao.selectByPage(pageNo, rowsPerPage);
	}
	
	public List<BoardFaq> listByCategory(String fbCategory, int pageNo, int rowsPerPage){
		return boardFaqDao.selectByCategory(fbCategory, pageNo, rowsPerPage);
	}
	
	public int write(BoardFaq boardFaq){
		int row = boardFaqDao.insert(boardFaq);
		if(row == 0) { return WRITE_FAIL; }
		return WRITE_SUCCESS;
	}
	
	public int modify(BoardFaq boardFaq){
		int row = boardFaqDao.update(boardFaq);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int bno){
		int row = boardFaqDao.delete(bno);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public BoardFaq info(int bno){
		return boardFaqDao.selectByBno(bno);
	}
	
	public int getCount(){
		return boardFaqDao.count();
	}
	
	public int getCountByCategory(String fbCategory){
		return boardFaqDao.countByCategory(fbCategory);
	}
}
