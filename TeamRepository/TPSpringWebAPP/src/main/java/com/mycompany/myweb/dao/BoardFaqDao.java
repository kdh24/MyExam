package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.BoardFaq;

@Component
public class BoardFaqDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(BoardFaq boardFaq){
		String sql = "insert into board_faq(fbno, fbtitle, fbcontent, fbcategory) values(SEQ_BOARDFAQ_FBNO.nextval, ?, ?, ?) ";
		int row = jdbcTemplate.update(
				sql,
				boardFaq.getFbtitle(),
				boardFaq.getFbcontent(),
				boardFaq.getFbcategory()
				);
		
		return row;
	}
	

	public int update(BoardFaq boardFaq){
		String sql = "update board_faq set fbtitle=?, fbcontent=?, fbcategory=? where fbno=? ";
		int row = jdbcTemplate.update(
				sql,
				boardFaq.getFbtitle(),
				boardFaq.getFbcontent(),
				boardFaq.getFbcategory(),
				boardFaq.getFbno()
			);
		return row;
	}
	
	public int delete(int bno) {
		String sql = "delete from board_faq where bno=? ";
		int row = jdbcTemplate.update(sql, bno);
		return row; 
	}
	
	public BoardFaq selectByBno(int fbno){
		String sql = "select fbno, fbtitle, fbcontent from board_faq where fbno=? ";
		List<BoardFaq> list = jdbcTemplate.query(sql, new Object[] {fbno}, new RowMapper<BoardFaq>(){
			@Override
			public BoardFaq mapRow(ResultSet rs, int row) throws SQLException {
				BoardFaq boardFaq = new BoardFaq();
				boardFaq.setFbno(rs.getInt("bno"));
				boardFaq.setFbtitle(rs.getString("btitle"));
				boardFaq.setFbcontent(rs.getString("bcontent"));
				return boardFaq;
			}
		});
		return(list.size() != 0)? list.get(0) : null;	
	}
	
	public List<BoardFaq> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "select rn, fbno, fbtitle, fbcontent, fbcategory "; 
		sql += "from ( ";
		sql += "select rownum as rn, fbno, fbtitle, fbcontent, fbcategory ";
		sql += " from (select fbno, fbtitle, fbcontent, fbcategory from board_faq order by fbno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<BoardFaq> list = jdbcTemplate.query(
			sql,
			new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
			new RowMapper<BoardFaq>(){
				@Override
				public BoardFaq mapRow(ResultSet rs, int row) throws SQLException {
					BoardFaq boardFaq = new BoardFaq();
					boardFaq.setFbno(rs.getInt("fbno"));
					boardFaq.setFbtitle(rs.getString("fbtitle"));
					boardFaq.setFbcontent(rs.getString("fbcontent"));
					boardFaq.setFbcategory(rs.getString("fbcategory"));
					return boardFaq;
				}
			}
		);
		return list;
	}
	public List<BoardFaq> selectByCategory(String fbCategory, int pageNo, int rowsPerPage) {
		String sql = "select rn, fbno, fbtitle, fbcontent, fbcategory "; 
		sql += "from ( ";
		sql += "select rownum as rn, fbno, fbtitle, fbcontent, fbcategory ";
		sql += " from (select fbno, fbtitle, fbcontent, fbcategory from board_faq where fbcategory=? order by fbno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<BoardFaq> list = jdbcTemplate.query(
			sql,
			new Object[]{fbCategory, (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
			new RowMapper<BoardFaq>(){
				@Override
				public BoardFaq mapRow(ResultSet rs, int row) throws SQLException {
					BoardFaq boardFaq = new BoardFaq();
					boardFaq.setFbno(rs.getInt("fbno"));
					boardFaq.setFbtitle(rs.getString("fbtitle"));
					boardFaq.setFbcontent(rs.getString("fbcontent"));
					boardFaq.setFbcategory(rs.getString("fbcategory"));
					return boardFaq;
				}
			}
		);
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from board_faq";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;	
	}

	
	public int countByCategory(String fbCategory){
		String sql = "select count(*) from board_faq where fbcategory=?";
		int count = (Integer)jdbcTemplate.queryForObject(
				sql,
				new Object[]{fbCategory}, Integer.class);
		return count;	
	}
	
}
