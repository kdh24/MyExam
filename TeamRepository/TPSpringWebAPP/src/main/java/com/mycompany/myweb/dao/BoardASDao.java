package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.BoardAS;

@Component
public class BoardASDao {
	private static final Logger logger = LoggerFactory.getLogger(BoardASDao.class);

	
	@Autowired
	private	JdbcTemplate jdbcTemplate; 
	
	public int insert(BoardAS boardAS){
		String sql = "insert into board_AS(bano, batitle, bacontent, bawriter, badate) values(SEQ_BOARDAS_BANO.nextval,?,?,?,sysdate) ";
		int row = jdbcTemplate.update(
			sql,
			boardAS.getBatitle(),
			boardAS.getBacontent(),
			boardAS.getBawriter()
		);
		return row;
	}
	
	public int update(BoardAS boardAS){
		String sql = "update board_AS set batitle=?, bacontent=? where bano=? ";
		int row = jdbcTemplate.update(
				sql,
				boardAS.getBatitle(),
				boardAS.getBacontent(),
				boardAS.getBano()
			);
		return row;
	}
	
	public int delete(int bano) {
		String sql = "delete from board_AS where bano=? ";
		int row = jdbcTemplate.update(sql, bano);
		return row; 
	}
	
	public BoardAS selectByBano(int bano){
		String sql = "select bano, batitle, bacontent, bawriter, badate from board_AS where bano=? ";
		List<BoardAS> list = jdbcTemplate.query(sql, new Object[] {bano}, new RowMapper<BoardAS>(){
			@Override
			public BoardAS mapRow(ResultSet rs, int row) throws SQLException {
				BoardAS boardAS = new BoardAS();
				boardAS.setBano(rs.getInt("bano"));
				boardAS.setBatitle(rs.getString("batitle"));
				boardAS.setBacontent(rs.getString("bacontent"));
				boardAS.setBawriter(rs.getString("bawriter"));
				boardAS.setBadate(rs.getDate("badate"));
				return boardAS;
			}
		});
		return(list.size() != 0)? list.get(0) : null;	
	}
	
	public List<BoardAS> selectByPage(String bawriter, int pageNo, int rowsPerPage) {
		String sql = "select rn, bano, batitle, bacontent, bawriter, badate "; 
		sql += "from ( ";
		sql += "select rownum as rn, bano, batitle, bacontent, bawriter, badate ";
		sql += "from (select bano, batitle, bacontent, bawriter, badate from board_AS where bawriter=? order by bano desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<BoardAS> list = jdbcTemplate.query(
			sql,
			new Object[]{ bawriter, (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1) },
			new RowMapper<BoardAS>(){
				@Override
				public BoardAS mapRow(ResultSet rs, int row) throws SQLException {
					BoardAS boardAS = new BoardAS();
					boardAS.setBano(rs.getInt("bano"));
					boardAS.setBatitle(rs.getString("batitle"));
					boardAS.setBacontent(rs.getString("bacontent"));
					boardAS.setBawriter(rs.getString("bawriter"));
					boardAS.setBadate(rs.getDate("badate"));
					return boardAS;
				}
			}
		);
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from board_AS";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return count;	
	}
}
