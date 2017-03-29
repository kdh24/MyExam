package com.mycompany.myweb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;


@Component
public class MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	@Autowired
	private MemberDao memberDao;
	
	public static final int JOIN_SUCCESS=0;
	public static final int JOIN_FAIL=1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_MPASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS=0;
	public static final int LOGOUT_FAIL=1;
	
	public static final int MODIFY_SUCCESS=0;
	public static final int MODIFY_FAIL=1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL_MID = 1;
	public static final int WITHDRAW_FAIL_MPASSWORD = 2;
	
	public int login(String mid, String mpassword){
		Member member = memberDao.selectByMid(mid);
		if(member == null) return LOGIN_FAIL_MID;
		if(member.getMpassword().equals(mpassword) == false) return LOGIN_FAIL_MPASSWORD;
		return LOGIN_SUCCESS;
	}
	
	public int logout(String mid){	// 서비스에선 가급적 HttpSesstion을 사용하지 않는게 좋다 (컨트롤러에서 하는게 좋다) service가 session에 종속되기 때문(session이 없으면 실행이 안된다)
		
		return LOGOUT_SUCCESS;
	}
	
	public int join(Member member){
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	/*
	 * 회원 정보 기능은 아직 비밀번호 검증 기능이 없음 / 차후 추가할 예정(모달이나 자바스크립트로 진행예정)
	*/
	public Member info(String mid, String mpassword){
		Member member = memberDao.selectByMid(mid);
		//if(member.getMpassword().equals(mpassword) == false) return null;
		return member;
	}
	
	public Member getMember(String mid){
		Member member = memberDao.selectByMid(mid);
		return member;
	}
	
	public int modify(Member member){
		Member dbMember = memberDao.selectByMid(member.getMid());
		logger.info("mid : "+member.getMid());
		logger.info("dbmember :" + dbMember.getMid());
		if(dbMember.getMid().equals(member.getMid()) == false)  return MODIFY_FAIL;
		int row = memberDao.update(member);
		if(row!=1) return MODIFY_FAIL;
		return MODIFY_SUCCESS;
	}
	
	public String findMpassword(String mid, String memail){
		Member member = memberDao.selectByMid(mid);	
		if(member == null) return null;	// 입력한 mid가 존재 하지 않으면 null을 반환하도록 dao를 작성했으므로
		if(member.getMemail().equals(memail) == false) return null;
		return memberDao.selectByMpassword(mid, memail);
	}
	
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
	}
	
	public int withdraw(String mid){
		Member member = memberDao.selectByMid(mid);
		memberDao.delete(mid);
		return WITHDRAW_SUCCESS; 
	}
	
	public boolean isMid(String mid){
		Member member = memberDao.selectByMid(mid);
		if(member == null) return false;
		return true;
	}
	
	public int getcount(){
		return memberDao.count();
	}
	
	public List<Member> listByMember(int pageNo, int rowsPerPage){
		return memberDao.selectByMeber(pageNo, rowsPerPage);
	}
	
}