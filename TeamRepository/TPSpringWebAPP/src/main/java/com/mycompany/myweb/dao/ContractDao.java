package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.Contract;

@Component
public class ContractDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(Contract contract){
		String sql = "insert into contract(cid, crid, cfire, cgas, ctemperature, cvisitor, cview) values (SEQ_CONTRACT_CID.nextval,?,?,?,?,?,?) ";
		int row = jdbcTemplate.update(
			sql,
//			contract.getCid(),
			contract.getCrid(),
			contract.isCfire(),
			contract.isCgas(),
			contract.isCtemperature(),
			contract.isCvisitor(),
			contract.isCview()
		);
		return row;
	}
	
	public int update(Contract contract){
		String sql = "update contract set cfire=?, cgas=?, ctemperature=?, cvisitor=?, cview=? where cid=? ";
		int row = jdbcTemplate.update(
			sql,
			contract.isCfire(),
			contract.isCgas(),
			contract.isCtemperature(),
			contract.isCvisitor(),
			contract.isCview(),
			contract.getCid()
		);
		return row;
	}
	
	public int delete(String cid) {
		String sql = "delete from contract where cid=? ";
		int row = jdbcTemplate.update(sql,cid);
		return row; 
	}
	
	public Contract selectByCrid(int crid){
		String sql = "select cid, crid, cfire, cgas, ctemperature, cvisitor, cview from contract where crid=? ";
		List<Contract> list = jdbcTemplate.query(sql, new Object[] {crid}, new RowMapper<Contract>(){
			@Override
			public Contract mapRow(ResultSet rs, int row) throws SQLException {
				Contract contract = new Contract();
				contract.setCid(rs.getInt("cid"));
				contract.setCrid(rs.getInt("crid"));
				contract.setCfire(rs.getBoolean("cfire"));
				contract.setCgas(rs.getBoolean("cgas"));
				contract.setCtemperature(rs.getBoolean("ctemperature"));
				contract.setCvisitor(rs.getBoolean("cvisitor"));
				contract.setCview(rs.getBoolean("cview"));
				return contract;
			}
		});
		return(list.size() != 0)? list.get(0) : null;
	}
}
