package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.VisitorDao;
import com.mycompany.myweb.dto.Visitor;

@Component
public class VisitorService {
	public static final int INPUT_SUCESS = 0;
	public static final int INPUT_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private VisitorDao visitorDao;
	
	public int input(Visitor visitor){
		int row = visitorDao.insert(visitor);
		if(row == 0) return INPUT_FAIL;
		return INPUT_SUCESS;
	}
	
	public int remove(int vid){
		int row = visitorDao.delete(vid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCESS;
	}
	
	public Visitor info(int vrid){
		return visitorDao.selectByVrid(vrid);
	} 

	public Visitor endofinfo(int vrid){
		return visitorDao.selectByEndOfData(vrid);
	} 
	
	public List<Visitor> list(int vrid, String vday){
		return visitorDao.selectByVdate(vrid, vday);
	}
}
