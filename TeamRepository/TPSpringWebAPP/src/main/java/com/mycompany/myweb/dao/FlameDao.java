package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Flame;

@Component
public class FlameDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Flame fflame){
		/////////////////////////
		// 구동 정상 확인
		/////////////////////////
		String sql = "insert into flame(fid, frid, fdate, fflame, fstate) values (seq_flame_fid.nextval, ?, ?, ?, ?) ";
		int row = jdbcTemplate.update(
			sql,
			fflame.getFrid(),
			fflame.getFdate(),
			fflame.getFflame(),
			fflame.isFstate()
		);
		return row;
	}
	
	public int delete(int fid) {
		String sql = "delete from fflame where fid=? ";
		int row = jdbcTemplate.update(sql, fid);
		return row; 
	}
	
	public Flame selectByFrid(int frid){
		String sql = "select fid, frid, fdate, fflame, fstate "
				   + "from ("
				   + 	"select rownum as rn, fid, frid, fdate, fflame, fstate "
				   + 	"from flame "
				   +	"where frid=? order by fid desc"	
				   + 	") "
				   + "where rn=1";
		List<Flame> list = jdbcTemplate.query(sql, new Object[] {frid}, new RowMapper<Flame>(){
			@Override
			public Flame mapRow(ResultSet rs, int row) throws SQLException {
				Flame fflame = new Flame();
				fflame.setFid(rs.getInt("fid"));
				fflame.setFrid(rs.getInt("frid"));
				fflame.setFdate(rs.getDate("fdate"));
				fflame.setFflame(rs.getDouble("fflame"));
				fflame.setFstate(rs.getBoolean("fstate"));
				return fflame;
			}
		});
		return(list.size() != 0)? list.get(0) : null;
	}
	
	public List<Flame> selectByFday(int frid, String fday){
		String sql = "select frid, TO_CHAR(fdate, 'yyyymmddhh24') as fday, round(avg(fflame)) as avg_f, count(case when fstate = '1' then 1 end) as count_event "
					+ "from flame "
					+ "where frid=? "
					+ "group by frid, TO_CHAR(fdate, 'yyyymmddhh24') "
					+ "having TO_CHAR(fdate, 'yyyymmddhh24') "
					+ "like ? "
					+ "order by TO_CHAR(fdate, 'yyyymmddhh24')";
		List<Flame> list = jdbcTemplate.query(sql, new Object[] {frid, fday}, new RowMapper<Flame>(){
			@Override
			public Flame mapRow(ResultSet rs, int row) throws SQLException {
				Flame fflame = new Flame();
				fflame.setFid(0);
				fflame.setFrid(rs.getInt("frid"));
				fflame.setFdate(null);
				fflame.setFday(rs.getString("fday"));
				fflame.setFflame(rs.getDouble("avg_f"));
				fflame.setFstate(false);
				fflame.setCount(rs.getInt("count_event"));
				return fflame;
			}
		});
		return(list.size() != 0)? list : null;
	}
	
	public Flame selectByEndOfData(int frid) {
		String sql = "select FID, FRID, FDATE, FFLAME, FSTATE from FLAME" 
				+ " inner join ("
				+ " select FRID as targetRid, max(FDATE) as maxReg from FLAME group by FRID )"
				+ " enddata on" 
				+ " FLAME.FRID = enddata.targetRid and FLAME.FDATE = enddata.maxReg"
				+ " where FLAME.FRID=?";
		List<Flame> list = jdbcTemplate.query(sql, new Object[]{frid},
				new RowMapper<Flame>(){
					@Override
					public Flame mapRow(ResultSet rs, int row) throws SQLException {
						Flame voFlame = new Flame();
						voFlame.setFid(rs.getInt("FID"));
						voFlame.setFrid(rs.getInt("FRID"));
						voFlame.setFdate(rs.getDate("FDATE"));
						voFlame.setFflame(rs.getDouble("FFLAME"));
						voFlame.setFstate(rs.getBoolean("FSTATE"));
						return voFlame;
					}
		} );
		return (list.size() !=0)?list.get(0):null;		
	}
	
	
	
}
