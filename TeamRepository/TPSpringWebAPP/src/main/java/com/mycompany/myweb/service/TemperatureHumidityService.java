package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.TemperatureHumidityDao;
import com.mycompany.myweb.dto.TemperatureHumidity;

@Component
public class TemperatureHumidityService {
	public static final int INPUT_SUCESS = 0;
	public static final int INPUT_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	@Autowired
	private TemperatureHumidityDao temperatureHumidityDao;
	
	public int input(TemperatureHumidity temperatureHumidity){
		int row = temperatureHumidityDao.insert(temperatureHumidity);
		if(row == 0) return INPUT_FAIL;
		return INPUT_SUCESS;
	}
	
	public int remove(int tid){
		int row = temperatureHumidityDao.delete(tid);
		if(row == 0) { return REMOVE_FAIL; }
		return REMOVE_SUCESS;
	}
	
	public TemperatureHumidity info(int trid){
		return temperatureHumidityDao.selectByTrid(trid);
	}

	public TemperatureHumidity endofinfo(int trid){
		return temperatureHumidityDao.selectByEndOfData(trid);
	}
	
	public List<TemperatureHumidity> list(int trid, String tday){
		return temperatureHumidityDao.selectByHour(trid, tday);
	}
}
