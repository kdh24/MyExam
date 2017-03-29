package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login")
	public String login(String mid, String mpassword, HttpSession session, Model model) {
		String result = "success";
		int intResult = memberService.login(mid, mpassword);		
		if(intResult == MemberService.LOGIN_SUCCESS) {
			session.setAttribute("login", mid);
			Member member = memberService.info(mid, mpassword);
			String mlevel;
			mlevel = member.getMlevel();
			session.setAttribute("mlevel", mlevel); 
		} else if(intResult == MemberService.LOGIN_FAIL_MID) {
			result = "wrongMid";
		} else {
			result = "wrongMpassword";
		}
		model.addAttribute("result", result);
		return "member/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("login");
		session.removeAttribute("mlevel");
		return "member/logout";
	}
	
	/*@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(){
		return "member/joinForm";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(Member member){
		try{
			int result = memberService.join(member);
			return "redirect:/member/login";
		}catch(Exception e){
			return "member/loginForm";
		}
	}*/
	
	/* 패스워드 검증 기능은 아직 넣지 않음 -> 새 페이지 혹은 모달창이나 자바스크립트로 구현 예정 */
	@RequestMapping("/info")
	public String info(String mpassword, HttpSession session, Model model){
		/*if(mpassword == null){
			return "redirect:/";
		}*/
		String mid = (String) session.getAttribute("login");
		Member member = memberService.info(mid, mpassword);
		model.addAttribute("member", member);
		return "member/info";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyForm(String mid, Model model){
		Member member = memberService.info(mid, null);
		model.addAttribute("member", member);
		return "member/modifyForm";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(Member member){
		//Member dbMember = memberService.info(member.getMid(), null);
		logger.info(member.toString());
		memberService.modify(member);
		
		return "redirect:/member/info";
	}
	
	@RequestMapping("/remove")
	public String remove(String mid, HttpSession session){
		memberService.withdraw(mid);
		session.removeAttribute("login");
		return "redirect:/member/list";
	}
	
	@RequestMapping(value="/findMid", method=RequestMethod.GET)
	public String findMidForm(){
		return "member/findMidForm";
	}
	
	@RequestMapping(value = "/findMid", method = RequestMethod.POST)
	public String findMid(String memail, Model model, HttpSession session){
		String mid = memberService.findMid(memail);
		if (mid == null) {
			model.addAttribute("error", "이메일이 존재하지 않음");
			return "member/findMidForm";
		}
		session.setAttribute("findMid", mid);
		return "member/findMidOk";
	}
	
	@RequestMapping(value="/findMpassword", method=RequestMethod.GET)
	public String findMpasswordForm(){
		return "member/findMpasswordForm";
	}
	
	@RequestMapping(value="/findMpassword", method=RequestMethod.POST)
	public String findMpassword(String mid, String memail, Model model, HttpSession session){
		String mpassword = memberService.findMpassword(mid, memail);
		if (mpassword == null){
			model.addAttribute("error", "아이디또는 이메일이 일치하지 않음");
			return "member/findMpasswordForm";
		}
		session.setAttribute("findMpassword", mpassword);
		return "member/findMpasswordOk";
	}
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session, String mid){
		int intPageNo = 1;
		if(pageNo == null){
			pageNo = (String) session.getAttribute("pageNo");
			if(pageNo != null){
				intPageNo = Integer.parseInt(pageNo);
			}
		} else {
			intPageNo = Integer.parseInt(pageNo);
		}
		session.setAttribute("pageNo", String.valueOf(intPageNo));
			
		int rowsPerPage = 10;
		int pagesPerGroup = 5;
		int totalMemberNo = memberService.getcount();
		
		int totalPageNo = totalMemberNo/rowsPerPage +((totalMemberNo%rowsPerPage !=0) ?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup !=0) ?1:0 );
		
		int groupNo = (intPageNo-1)/pagesPerGroup +1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		List<Member> list = memberService.listByMember(intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalMemberNo", totalMemberNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("mid", mid);
		model.addAttribute("list", list);
		return "member/list";
	}  
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(){
		return "member/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member, HttpSession session){
		try{
			String mid = (String) session.getAttribute("login");
			//boardas.setBawriter(mid);
			int result = memberService.join(member);
			if(result == MemberService.JOIN_FAIL) {
				return "member/join";
			} else {
				return "redirect:/member/list";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "member/join";
		}
	}
}