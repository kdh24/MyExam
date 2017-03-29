package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.GasDao;
import com.mycompany.myweb.dto.Gas;

@Component
public class GasService {
	public static final int INPUT_SUCESS = 0;
	public static final int INPUT_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private GasDao gasDao;
	
	public int input(Gas gas){
		int row = gasDao.insert(gas);
		if(row == 0) return INPUT_FAIL;
		return INPUT_SUCESS;
	}
	
	public int remove(int gid){
		int row = gasDao.delete(gid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCESS;
	}
	
	public Gas info(int grid){
		return gasDao.selectByGrid(grid);
	} 

	public Gas endofinfo(int grid){
		return gasDao.selectByEndOfData(grid);
	} 
	
	public List<Gas> list(int grid, String gday){
		return gasDao.selectByGdate(grid, gday);
	}
}
