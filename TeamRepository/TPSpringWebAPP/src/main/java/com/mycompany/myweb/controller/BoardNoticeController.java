package com.mycompany.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.BoardNotice;
import com.mycompany.myweb.service.BoardNoticeService;

@Controller
@RequestMapping("/boardnotice")
public class BoardNoticeController {
	@Autowired
	private BoardNoticeService boardNoticeService;
	
	@RequestMapping("/list")
	public String list(String pageNo, Model model, HttpSession session, String btitle){
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
		int totalBoardNoticeNo;
		
		List<BoardNotice> list; 
		
		if(btitle != null){
			totalBoardNoticeNo = boardNoticeService.getcountByTitle(btitle);
			list = boardNoticeService.listByTitle(btitle, intPageNo, rowsPerPage);
		}else {
			totalBoardNoticeNo = boardNoticeService.getcount();
			list = boardNoticeService.list(intPageNo, rowsPerPage);
		}
		
		int totalPageNo = totalBoardNoticeNo/rowsPerPage +((totalBoardNoticeNo%rowsPerPage !=0) ?1:0);
		int totalGroupNo = totalPageNo/pagesPerGroup + ((totalPageNo%pagesPerGroup !=0) ?1:0 );
		
		int groupNo = (intPageNo-1)/pagesPerGroup +1;
		int startPageNo = (groupNo-1)*pagesPerGroup +1;
		int endPageNo = startPageNo + pagesPerGroup -1;
		if(groupNo == totalGroupNo) { endPageNo = totalPageNo; }
		
		model.addAttribute("pageNo", intPageNo);
		model.addAttribute("rowsPerPage", rowsPerPage);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalBoardNoticeNo", totalBoardNoticeNo);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("btitle", btitle);
		model.addAttribute("list", list);
		return "boardnotice/list";
	} 
	
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "boardnotice/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardNotice boardNotice, HttpSession session){

			String mid = (String) session.getAttribute("login");
			
			int result = boardNoticeService.write(boardNotice);
			if(result == BoardNoticeService.WRITE_FAIL) {
				return "boardnotice/write";
			} else {
				return "redirect:/boardnotice/list";
			}

	}
	
	@RequestMapping("/info")
	public String info(int bno, Model model){
		BoardNotice boardNotice = boardNoticeService.info(bno);
		boardNotice.setBhitcount(boardNotice.getBhitcount()+1);
		boardNoticeService.modify(boardNotice);
		model.addAttribute("boardnotice", boardNotice);
		return "boardnotice/info";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modify(int bno, Model model){
		BoardNotice boardNotice = boardNoticeService.info(bno);
		model.addAttribute("boardnotice", boardNotice);
		return "boardnotice/modify";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modify(BoardNotice boardNotice){
		BoardNotice dbBoardNotice = boardNoticeService.info(boardNotice.getBno());
		boardNotice.setBhitcount(dbBoardNotice.getBhitcount());
		boardNoticeService.modify(boardNotice);
		return "redirect:/boardnotice/list";
	}
	
	@RequestMapping("/remove")
	public String remove(int bno){
		boardNoticeService.remove(bno);
		return "redirect:/boardnotice/list";
	}
	
}