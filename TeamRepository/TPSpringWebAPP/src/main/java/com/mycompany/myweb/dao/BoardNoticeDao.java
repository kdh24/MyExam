package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.BoardNotice;

@Component
public class BoardNoticeDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(BoardNotice boardNotice){
		String sql = "insert into board_Notice(bno, btitle, bcontent, bwriter, bdate, bhitcount) values(SEQ_BOARDNOTICE_BNO.nextval,?,?,?,sysdate,0) ";
		int row = jdbcTemplate.update(
			sql,
			boardNotice.getBtitle(),
			boardNotice.getBcontent(),
			boardNotice.getBwriter()
		);
		return row;
	}
	
	public int update(BoardNotice boardNotice){
		String sql = "update board_Notice set btitle=?, bcontent=?, bhitcount=? where bno=? ";
		int row = jdbcTemplate.update(
				sql,
				boardNotice.getBtitle(),
				boardNotice.getBcontent(),
				boardNotice.getBhitcount(),
				boardNotice.getBno()
			);
		return row;
	}
	
	public int delete(int bno) {
		String sql = "delete from board_Notice where bno=? ";
		int row = jdbcTemplate.update(sql,bno);
		return row; 
	}
	
	public BoardNotice selectByBno(int bno){
		String sql = "select bno, btitle, bcontent, bwriter, bdate, bhitcount from board_Notice where bno=? ";
		List<BoardNotice> list = jdbcTemplate.query(sql, new Object[] {bno}, new RowMapper<BoardNotice>(){
			@Override
			public BoardNotice mapRow(ResultSet rs, int row) throws SQLException {
				BoardNotice boardNotice = new BoardNotice();
				boardNotice.setBno(rs.getInt("bno"));
				boardNotice.setBtitle(rs.getString("btitle"));
				boardNotice.setBcontent(rs.getString("bcontent"));
				boardNotice.setBwriter(rs.getString("bwriter"));
				boardNotice.setBdate(rs.getDate("bdate"));
				boardNotice.setBhitcount(rs.getInt("bhitcount"));
				return boardNotice;
			}
		});
		return(list.size() != 0)? list.get(0) : null;	
	}
	
	public List<BoardNotice> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "select rn, bno, btitle, bcontent, bwriter, bdate ,bhitcount "; 
		sql += "from ( ";
		sql += "select rownum as rn, bno, btitle, bcontent, bwriter, bdate, bhitcount ";
		sql += " from (select bno, btitle, bcontent, bwriter, bdate, bhitcount from board_Notice order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<BoardNotice> list = jdbcTemplate.query(
			sql,
			new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
			new RowMapper<BoardNotice>(){
				@Override
				public BoardNotice mapRow(ResultSet rs, int row) throws SQLException {
					BoardNotice boardNotice = new BoardNotice();
					boardNotice.setBno(rs.getInt("bno"));
					boardNotice.setBtitle(rs.getString("btitle"));
					boardNotice.setBcontent(rs.getString("bcontent"));
					boardNotice.setBwriter(rs.getString("bwriter"));
					boardNotice.setBdate(rs.getDate("bdate"));
					boardNotice.setBhitcount(rs.getInt("bhitcount"));
					return boardNotice;
				}
			}
		);
		return list;
	}
	
	public List<BoardNotice> selectByTitle(String btitle , int pageNo, int rowsPerPage){
		String sql = "select rn, bno, btitle, bdate "; 
		sql += "from ( ";
		sql += "select rownum as rn, bno, btitle, bdate ";
		sql += " from (select bno, btitle, bdate from board_Notice where btitle||bcontent like ? order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<BoardNotice> list = jdbcTemplate.query(
			sql,
			new Object[]{("%"+btitle+"%"), (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
			new RowMapper<BoardNotice>(){
				@Override
				public BoardNotice mapRow(ResultSet rs, int row) throws SQLException {
					BoardNotice boardNotice = new BoardNotice();
					boardNotice.setBno(rs.getInt("bno"));
					boardNotice.setBtitle(rs.getString("btitle"));
					boardNotice.setBdate(rs.getDate("bdate"));
					return boardNotice;
				}
			}
		);

		return list;
	}
	
	public int count(){
		String sql = "select count(*) from board_Notice";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;	
	}
	
	public int countByTitle(String btitle){
		String sql = "select count(*) from board_Notice where btitle||bcontent like ? ";
		int count = (Integer)jdbcTemplate.queryForObject(
				sql,
				new Object[]{"%"+btitle+"%"}, Integer.class);
		return count;	
	}
}
