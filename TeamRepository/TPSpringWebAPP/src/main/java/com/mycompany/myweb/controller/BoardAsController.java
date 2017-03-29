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

import com.mycompany.myweb.dto.BoardAS;
import com.mycompany.myweb.service.BoardASService;

@Controller
@RequestMapping("/boardas")
public class BoardAsController {
	private static final Logger logger = LoggerFactory.getLogger(BoardAsController.class);
	
	@Autowired
	private BoardASService boardAsService;
		
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session){
		//logger.info("■CTL■ boardas 페이지 호출");
		
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
		
		int totalBoardASNo = boardAsService.getcount();
		
		int totalPageNo = totalBoardASNo/rowsPerPage +((totalBoardASNo%rowsPerPage !=0) ?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup !=0) ?1:0 );
		
		int groupNo = (intPageNo-1)/pagesPerGroup +1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		String mid = (String) session.getAttribute("login");
		
		List<BoardAS> list = boardAsService.list(mid, intPageNo, rowsPerPage);
		
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardASNo", totalBoardASNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("list", list);
		return "boardas/list";
	} 
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "boardas/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardAS boardas, HttpSession session){
		try{
			String mid = (String) session.getAttribute("login");
			//boardas.setBawriter(mid);
			int result = boardAsService.write(boardas);
			if(result == BoardASService.WRITE_FAIL) {
				return "boardas/write";
			} else {
				return "redirect:/boardas/list";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "boardas/write";
		}
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modify(int bano, Model model){
		BoardAS boardas = boardAsService.info(bano);
		model.addAttribute("boardas", boardas);
		return "boardas/modify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modify(BoardAS boardas, HttpSession session){
		try{
			int result = boardAsService.modify(boardas);
			
			if(result == BoardASService.MODIFY_FAIL){
				return "boardas/modify";
			}else{
				return "redirect:/boardas/list";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "boardas/modify";
		}
	}
	
	@RequestMapping("/info")
	public String info(int bano, Model model){
		BoardAS boardas = boardAsService.info(bano);
		model.addAttribute("boardas", boardas);
		return "boardas/info";
	}
	
	@RequestMapping("/delete")
	public String delete(int bano){
		int result = boardAsService.remove(bano);
		return "redirect:/boardas/list";
	}
	
}
