package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Room;

@Component
public class RoomDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Room room){
		String sql = "insert into Room(rid, rname, rmid, rempty) values(seq_room_rid.nextval, ?, ?, ?)";
		int row = jdbcTemplate.update(
				sql,
				room.getRname(),
				room.getRmid(),
				room.isRempty()
				);
		return row;
	}
	
	public int update(Room room){
		String sql = "update room set rname=?, rempty=? where rid=? ";
		int row = jdbcTemplate.update(
				sql,
				room.getRname(),
				room.isRempty(),
				room.getRid()
				);
		return row;
	}
	
	public int delete(int rid){
		String sql = "delete from Room where rid=?";
		int row = jdbcTemplate.update(sql, rid);
		return row;
	}
	
	public Room selectByRid(int rid){
		String sql = "select rid, rname, rmid, rempty from room where rid=?";
		List<Room> list = jdbcTemplate.query(sql, new Object[] {rid}, new RowMapper<Room>(){
			@Override
			public Room mapRow(ResultSet rs, int row) throws SQLException {
				Room room = new Room();
				room.setRid(rs.getInt("rid"));
				room.setRname(rs.getString("rname"));
				room.setRmid(rs.getString("rmid"));
				room.setRempty(rs.getBoolean("rempty"));
				return room;
			}
		});
		return (list.size()!=0) ? list.get(0) : null; 
	}
	
	public List<Room> selectList(String rmid){
		String sql = "select rid, rname, rmid, rempty from room where rmid=? ORDER BY rid ASC";
		List<Room> list = jdbcTemplate.query(sql, new Object[] {rmid}, new RowMapper<Room>(){
			@Override
			public Room mapRow(ResultSet rs, int row) throws SQLException {
				Room room = new Room();
				room.setRid(rs.getInt("rid"));
				room.setRname(rs.getString("rname"));
				room.setRmid(rs.getString("rmid"));
				room.setRempty(rs.getBoolean("rempty"));
				return room;
			}
		});
		return (list.size()!=0) ? list : null; 
	}
	
	
	
	public int count(){
		String sql = "select count(*) from room";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}
