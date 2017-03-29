package com.mycompany.myweb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.BoardASDao;
import com.mycompany.myweb.dto.BoardAS;

@Component
public class BoardASService {
	private static final Logger logger = LoggerFactory.getLogger(BoardASService.class);

	
	public static final int WRITE_SUCCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private BoardASDao boardASDao;
	
	public List<BoardAS> list(String bawriter, int pageNo, int rowsPerPage){
		return boardASDao.selectByPage(bawriter, pageNo, rowsPerPage);
	}
	
	public int write(BoardAS boardAS){
		int row = boardASDao.insert(boardAS);
		//if(row == 0) { return WRITE_FAIL; }
		return WRITE_SUCCESS;
	}
	
	public int modify(BoardAS boardAS){
		int row = boardASDao.update(boardAS);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCCESS;
	}
	
	public int remove(int bano){
		int row = boardASDao.delete(bano);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCCESS;
	}
	
	public BoardAS info(int bano){
		return boardASDao.selectByBano(bano);
	}
	
	public int getcount(){
		return boardASDao.count();
	}
}
