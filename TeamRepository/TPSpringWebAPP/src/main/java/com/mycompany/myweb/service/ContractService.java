package com.mycompany.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.ContractDao;
import com.mycompany.myweb.dto.Contract;

@Component
public class ContractService {
	
	public static final int WRITE_SUCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private ContractDao contractDao;
	
	public int write(Contract contract){
		int row = contractDao.insert(contract);
		if(row == 0) { return WRITE_FAIL; }
		return WRITE_SUCESS;
	}
	
	public int modify(Contract contract){
		int row = contractDao.update(contract);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCESS;
	}
	
	public int remove(String cid){
		int row = contractDao.delete(cid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCESS;
	}
	
	public Contract info(int crid){
		return contractDao.selectByCrid(crid);
	}
}
