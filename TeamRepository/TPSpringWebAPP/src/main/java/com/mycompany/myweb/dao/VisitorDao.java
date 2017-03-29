package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Visitor;

@Component
public class VisitorDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Visitor visitor){
		/////////////////////////
		// 구동 정상 확인
		/////////////////////////
		String sql = "insert into visitor(vid, vrid, vdate, vstate) values (seq_visitor_vid.nextval,?,?,?) ";
		int row = jdbcTemplate.update(
			sql,
			visitor.getVrid(),
			visitor.getVdate(),
			visitor.isVstate()
		);
		return row;
	}
	
	public int delete(int vid) {
		String sql = "delete from visitor where vid=? ";
		int row = jdbcTemplate.update(sql,vid);
		return row; 
	}
	
	public Visitor selectByVrid(int vrid){
		String sql = "select vid, vrid, vdate, vstate "
				   + "from ("
				   + 	"select rownum as rn, vid, vrid, vdate, vstate "
				   + 	"from visitor "
				   +	"where vrid=? order by gid desc"	
				   + 	") "
				   + "where rn=1";
		List<Visitor> list = jdbcTemplate.query(sql, new Object[] {vrid}, new RowMapper<Visitor>(){
			@Override
			public Visitor mapRow(ResultSet rs, int row) throws SQLException {
				Visitor Visitor = new Visitor();
				Visitor.setVid(rs.getInt("vid"));
				Visitor.setVrid(rs.getInt("vrid"));
				Visitor.setVdate(rs.getDate("vdate"));
				Visitor.setVstate(rs.getBoolean("vstate"));
				return Visitor;
			}
		});
		return(list.size() != 0)? list.get(0) : null;
	}
	
	public List<Visitor> selectByVdate(int vrid, String vday){
		String sql = "select vrid, TO_CHAR(vdate, 'yyyymmddhh24') as vday, count(case when vstate = '1' then 1 end) as count_event "
					+ "from visitor "
					+ "where vrid=? "
					+ "group by vrid, TO_CHAR(vdate, 'yyyymmddhh24') "
					+ "having TO_CHAR(vdate, 'yyyymmddhh24') "
					+ "like ? "
					+ "order by TO_CHAR(vdate, 'yyyymmddhh24')";
		List<Visitor> list = jdbcTemplate.query(sql, new Object[] {vrid, vday}, new RowMapper<Visitor>(){
			@Override
			public Visitor mapRow(ResultSet rs, int row) throws SQLException {
				Visitor visitor = new Visitor();
				visitor.setVid(0);
				visitor.setVrid(rs.getInt("vrid"));
				visitor.setVdate(null);
				visitor.setVday(rs.getString("vday"));
				visitor.setVstate(false);
				visitor.setCount(rs.getInt("count_event"));
				return visitor;
			}
		});
		return(list.size() != 0)? list : null;
	}

	public Visitor selectByEndOfData(int vrid) {

		String sql = "select VID, VRID, VDATE, VSTATE from VISITOR" 
				+ " inner join ("
				+ " select VRID as targetRid, max(VDATE) as maxReg from VISITOR group by VRID )"
				+ " enddata on" 
				+ " VISITOR.VRID = enddata.targetRid and VISITOR.VDATE = enddata.maxReg"
				+ " where VISITOR.VRID=?";
		List<Visitor> list = jdbcTemplate.query(sql, new Object[]{vrid},
				new RowMapper<Visitor>(){
					@Override
					public Visitor mapRow(ResultSet rs, int row) throws SQLException {
						Visitor voVisitor = new Visitor();
						voVisitor.setVid(rs.getInt("VID"));
						voVisitor.setVrid(rs.getInt("VRID"));
						voVisitor.setVdate(rs.getDate("VDATE"));
						voVisitor.setVstate(rs.getBoolean("VSTATE"));
						return voVisitor;
					}
		} );
		return (list.size() !=0)?list.get(0):null;
	}
	
}
