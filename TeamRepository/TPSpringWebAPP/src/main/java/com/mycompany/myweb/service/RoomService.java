package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.RoomDao;
import com.mycompany.myweb.dto.Room;

@Component
public class RoomService {
	
	public static final int WRITE_SUCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	
	@Autowired
	private RoomDao roomDao;
	
	public int write(Room room){
		int row = roomDao.insert(room);
		if(row == 0) { return WRITE_FAIL; }
		return WRITE_SUCESS;
	}
	
	public int modify(Room room){
		int row = roomDao.update(room);
		if(row == 0) { return MODIFY_FAIL; }
		return MODIFY_SUCESS;
	}
	
	public int remove(int rid){
		int row = roomDao.delete(rid);
		
		if(row == 0) { return REMOVE_FAIL; }
		return MODIFY_SUCESS;
	}
	
	public Room info(int rid){
		return roomDao.selectByRid(rid);
	} 
	
	public List<Room> roomList(String rmid){
		return roomDao.selectList(rmid);
	}
}
