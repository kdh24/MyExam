package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Gas;

@Component
public class GasDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Gas gas){
		/////////////////////////
		// 구동 정상 확인
		/////////////////////////
		String sql = "insert into gas(gid, grid, gdate, ggas, gstate) values (seq_gas_gid.nextval, ?, ?, ?, ?) ";
		int row = jdbcTemplate.update(
			sql,
			gas.getGrid(),
			gas.getGdate(),
			gas.getGgas(),
			gas.isGstate()
		);
		return row;
	}
	
	public int delete(int gid) {
		String sql = "delete from gas where gid=? ";
		int row = jdbcTemplate.update(sql,gid);
		return row; 
	}
	
	public Gas selectByGrid(int grid){
		String sql = "select gid, grid, gdate, ggas, gstate "
				   + "from ("
				   + 	"select rownum as rn, gid, grid, gdate, ggas, gstate "
				   + 	"from gas "
				   +	"where grid=? order by gid desc"	
				   + 	") "
				   + "where rn=1";
		List<Gas> list = jdbcTemplate.query(sql, new Object[] {grid}, new RowMapper<Gas>(){
			@Override
			public Gas mapRow(ResultSet rs, int row) throws SQLException {
				Gas gas = new Gas();
				gas.setGid(rs.getInt("gid"));
				gas.setGrid(rs.getInt("grid"));
				gas.setGdate(rs.getDate("gdate"));
				gas.setGgas(rs.getDouble("ggas"));
				gas.setGstate(rs.getBoolean("gstate"));
				return gas;
			}
		});
		return(list.size() != 0)? list.get(0) : null;
	}
	
	public List<Gas> selectByGdate(int grid, String gday){
		String sql = "select count(case when gstate = '1' then 1 end) as count_event "
					+ "from gas "
					+ "where grid=? "
					+ "group by grid, TO_CHAR(gdate, 'yyyymmddhh24') "
					+ "having TO_CHAR(gdate, 'yyyymmddhh24') "
					+ "like ? "
					+ "order by TO_CHAR(gdate, 'yyyymmddhh24')";
		List<Gas> list = jdbcTemplate.query(sql, new Object[] {grid, gday}, new RowMapper<Gas>(){
			@Override
			public Gas mapRow(ResultSet rs, int row) throws SQLException {
				Gas gas = new Gas();
				//gas.setGid(0);
				//gas.setGrid(rs.getInt("grid"));
				//gas.setGdate(null);
				//gas.setGday(rs.getString("gday"));
				//gas.setGgas(rs.getDouble("avg_g"));
				gas.setCount(rs.getInt("count_event"));
				
				return gas;
			}
		});
		return(list.size() != 0)? list : null;
	}

	public Gas selectByEndOfData(int grid) {
		String sql = "select GID, GRID, GDATE, GGAS, GSTATE from GAS" 
				+ " inner join ("
				+ " select GRID as targetRid, max(GDATE) as maxReg from GAS group by GRID )"
				+ " enddata on" 
				+ " GAS.GRID = enddata.targetRid and GAS.GDATE = enddata.maxReg"
				+ " where GAS.GRID=?";
		List<Gas> list = jdbcTemplate.query(sql, new Object[]{grid},
				new RowMapper<Gas>(){
					@Override
					public Gas mapRow(ResultSet rs, int row) throws SQLException {
						Gas voGas = new Gas();
						voGas.setGid(rs.getInt("GID"));
						voGas.setGrid(rs.getInt("GRID"));
						voGas.setGdate(rs.getDate("GDATE"));
						voGas.setGgas(rs.getDouble("GGAS"));
						voGas.setGstate(rs.getBoolean("GSTATE"));
						return voGas;
					}
		} );
		return (list.size() !=0)?list.get(0):null;		
	}
	
}
