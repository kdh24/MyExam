package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Member;

@Component
public class MemberDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Member member){
		String sql = "insert into member"
				   + "(mid, mpassword, mname, memail, maddress, mtel, mlevel) "
				   + "values(?, ?, ?, ?, ?, ?, ?)";
		
		int row = jdbcTemplate.update(sql, member.getMid(),
										   member.getMpassword(),
										   member.getMname(),
										   member.getMemail(),
										   member.getMaddress(),
										   member.getMtel(),
										   member.getMlevel()
									 );
		return row;
	}
	
	public int update(Member member){
		String sql = "update member set mpassword=?, memail=?, maddress=?, mtel=? where mid=?";
		int row = jdbcTemplate.update(sql, member.getMpassword(),
										   member.getMemail(),
										   member.getMaddress(),
										   member.getMtel(),
										   member.getMid()
									 );
		return row;
	}
	
	public int delete(String mid){
		String sql = "delete from member where mid=?";
		int row = jdbcTemplate.update(sql, mid);
		
		return row;
	}
	
	public Member selectByMid(String mid){
		String sql = "select mid, mpassword, mname, memail, maddress, mtel, mlevel from member where mid=?";
		List<Member> list = jdbcTemplate.query(sql, new Object[]{mid}, new RowMapper<Member>(){

			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMname(rs.getString("mname"));
				member.setMemail(rs.getString("memail"));
				member.setMaddress(rs.getString("maddress"));
				member.setMtel(rs.getString("mtel"));
				member.setMlevel(rs.getString("mlevel"));
				
				return member;
			}});
		
		return (list.size()!=0) ? list.get(0) : null; 
	}
	
	public String selectByMemail(String memail){
		String sql = "select mid from member where memail=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{memail}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				
				return rs.getString("mid");
			}});
		
		return (list.size()!=0) ? list.get(0) : null;
	}
	
	public String selectByMpassword(String mid, String memail){
		String sql = "select mpassword from member where mid=? and memail=? ";
		List<String> list = jdbcTemplate.query(sql, new Object[]{mid,memail}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
	            
				return rs.getString("mpassword"); 
			}
	      
		});
		return (list.size() != 0)? list.get(0):null; 
	}
	
	public List<Member> selectByPage(int pageNo, int rowsPerPage){
		String sql = "select rn, mid, mpassword, mname, memail, maddress, mtel, mlevel "
				   + "from ("
				          + "select rownum as rn, mid, mpassword, mname, memail, maddress, mtel, mlevel "
				          + "from ("
				          		 + "select * from member"
				          	   + ") "
				          + "where rownum<=?"
				        + ") "
				   + "where rn>=?";
		List<Member> list = jdbcTemplate.query(sql, new Object[]{pageNo*rowsPerPage, (pageNo-1)*rowsPerPage+1}, new RowMapper<Member>(){

			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMname(rs.getString("mname"));
				member.setMemail(rs.getString("memail"));
				member.setMaddress(rs.getString("maddress"));
				member.setMtel(rs.getString("mtel"));
				member.setMlevel(rs.getString("mlevel"));
				
				return member;
			}});
		
		return list;
	}
	
	public List<Member> selectByMeber(int pageNo, int rowsPerPage){
		String sql = "select rn, mid, mname, memail, maddress, mtel, mlevel "
				   + "from ("
				          + "select rownum as rn, mid, mname, memail, maddress, mtel, mlevel "
				          + "from ("
				          		 + "select * from member"
				          	   + ") "
				          + "where rownum<=?"
				        + ") "
				   + "where rn>=? and mlevel in 'user' ";
		List<Member> list = jdbcTemplate.query(sql, new Object[]{pageNo*rowsPerPage, (pageNo-1)*rowsPerPage+1}, new RowMapper<Member>(){

			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMemail(rs.getString("memail"));
				member.setMaddress(rs.getString("maddress"));
				member.setMtel(rs.getString("mtel"));
				member.setMlevel(rs.getString("mlevel"));
				
				return member;
			}});
		
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from member";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);	// 쿼리문을 실행한 후 하나의 객체를 리턴한다.
		return count;
	}
	
}