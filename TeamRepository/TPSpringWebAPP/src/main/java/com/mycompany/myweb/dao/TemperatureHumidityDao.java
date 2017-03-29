package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.TemperatureHumidity;

@Component
public class TemperatureHumidityDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(TemperatureHumidity temperatureHumidity){
		/////////////////////////
		// 구동 정상 확인
		/////////////////////////
		String sql = "insert into temperature_Humidity(tid, trid, tdate, ttemperature, thumidity) values (seq_temperatureHumidity_tid.nextval,?,?,?,?) ";
		int row = jdbcTemplate.update(
			sql,
			temperatureHumidity.getTrid(),
			temperatureHumidity.getTdate(),
			temperatureHumidity.getTtemperature(),
			temperatureHumidity.getThumidity()
		);
		return row;
	}

	
	public int delete(int tid){
		String sql = "delete from temperature_Humidity where tid=?";
		int row = jdbcTemplate.update(sql,tid);
		return row; 
	}
	
	public TemperatureHumidity selectByTrid(int trid){
		String sql = "select tid, trid, tdate, ttemperature, thumidity "
				   + "from ("
				   + 	"select rownum as rn, tid, trid, tdate, ttemperature, thumidity "
				   + 	"from Temperature_Humidity "
				   +	"where trid=? order by tid desc"	
				   + 	") "
				   + "where rn=1";
		List<TemperatureHumidity> list = jdbcTemplate.query(sql, new Object[] {trid}, new RowMapper<TemperatureHumidity>(){
			@Override
			public TemperatureHumidity mapRow(ResultSet rs, int row) throws SQLException {
				TemperatureHumidity temperatureHumidity = new TemperatureHumidity();
				temperatureHumidity.setTid(rs.getInt("tid"));
				temperatureHumidity.setTrid(rs.getInt("trid"));
				temperatureHumidity.setTdate(rs.getDate("tdate"));
				temperatureHumidity.setTtemperature(rs.getDouble("ttemperature"));
				temperatureHumidity.setThumidity(rs.getDouble("thumidity"));
				return temperatureHumidity;
			}
		});
		return(list.size() != 0)? list.get(0) : null;
	}
	
	public List<TemperatureHumidity> selectByHour(int trid, String tday){
		String sql = "select trid, TO_CHAR(tdate, 'yyyymmddhh24') as hour_per_day, round(avg(ttemperature)) as avg_t, round(avg(thumidity)) as avg_h "
				+ "from temperature_humidity " 
				+ "where trid = ?"
				+ "GROUP BY trid, TO_CHAR(tdate, 'yyyymmddhh24') "
				+ "having TO_CHAR(tdate, 'yyyymmddhh24') like ? " 
				+ "order by TO_CHAR(tdate, 'yyyymmddhh24')";
		
		List<TemperatureHumidity> list = jdbcTemplate.query(sql, new Object[] {trid, tday}, new RowMapper<TemperatureHumidity>(){
			@Override
			public TemperatureHumidity mapRow(ResultSet rs, int rowNum) throws SQLException {
				TemperatureHumidity temperatureHumidity = new TemperatureHumidity();
				
				temperatureHumidity.setTid(0);
				temperatureHumidity.setTrid(rs.getInt("trid"));
				temperatureHumidity.setTdate(null);
				temperatureHumidity.setTdateString(rs.getString("hour_per_day"));
				temperatureHumidity.setTtemperature(rs.getDouble("avg_t"));
				temperatureHumidity.setThumidity(rs.getDouble("avg_h"));
				
				return temperatureHumidity;
			}
		});
		
		return list;
	}

	public TemperatureHumidity selectByEndOfData(int trid) {
		String sql = "select TID, TRID, TDATE, TTEMPERATURE, THUMIDITY from TEMPERATURE_HUMIDITY" 
						+ " inner join ("
						+ " select TRID as targetRid, max(TDATE) as maxReg from TEMPERATURE_HUMIDITY group by TRID )"
						+ " enddata on" 
						+ " TEMPERATURE_HUMIDITY.TRID = enddata.targetRid and TEMPERATURE_HUMIDITY.TDATE = enddata.maxReg"
						+ " where TEMPERATURE_HUMIDITY.TRID=?";
		List<TemperatureHumidity> list = jdbcTemplate.query(sql, new Object[]{trid},
				new RowMapper<TemperatureHumidity>(){
					@Override
					public TemperatureHumidity mapRow(ResultSet rs, int row) throws SQLException {
						TemperatureHumidity voTH = new TemperatureHumidity();
						voTH.setTid(rs.getInt("TID"));
						voTH.setTrid(rs.getInt("TRID"));
						voTH.setTdate(rs.getDate("TDATE"));
						voTH.setTtemperature(rs.getDouble("TTEMPERATURE"));
						voTH.setThumidity(rs.getDouble("THUMIDITY"));
						return voTH;
					}
		} );
		return (list.size() !=0)?list.get(0):null;
	}	
}
