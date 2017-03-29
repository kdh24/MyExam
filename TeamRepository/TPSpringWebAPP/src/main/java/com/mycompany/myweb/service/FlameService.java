package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.FlameDao;
import com.mycompany.myweb.dto.Flame;

@Component
public class FlameService {
	public static final int INPUT_SUCESS = 0;
	public static final int INPUT_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private FlameDao flameDao;
	
	public int input(Flame flame){
		int row = flameDao.insert(flame);
		if(row == 0) return INPUT_FAIL;
		return INPUT_SUCESS;
	}
	
	public int remove(int fid){
		int row = flameDao.delete(fid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCESS;
	}
	
	public Flame info(int frid){
		return flameDao.selectByFrid(frid);
	}
	
	public Flame endofinfo(int frid){
		return flameDao.selectByEndOfData(frid);
	} 
	
	/** 일 별 시간 당 화재 발생 회수 */
	public List<Flame> list(int frid, String fday){
		return flameDao.selectByFday(frid, fday);
	}
	
}
