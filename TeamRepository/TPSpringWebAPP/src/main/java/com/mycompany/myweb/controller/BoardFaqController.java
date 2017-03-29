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

import com.mycompany.myweb.dto.BoardFaq;
import com.mycompany.myweb.dto.BoardPage;
import com.mycompany.myweb.service.BoardFaqService;

@Controller
@RequestMapping("/boardfaq")
public class BoardFaqController {
	private static final Logger logger = LoggerFactory.getLogger(BoardFaqController.class);

	BoardPage boardPage;
	List<BoardFaq> list = null;
	
	@Autowired
	private BoardFaqService boardFaqService;
	
	@RequestMapping("/index")
	public String index() {
		
		return "boardfaq/index";
	}
	
	@RequestMapping("/list")
	public String list(String pageNum, Model model, HttpSession session, String category) {
		setPageConfig(pageNum, session, model, category);
		
		session.setAttribute("category", category);
		return "boardfaq/list";
	}
	
/*	@RequestMapping("/searchByCategory")
	public String searchByCategory(String pageNum, Model model, HttpSession session, String category) {
		setPageConfig(pageNum, session, model, category);
		list = boardFaqService.listByCategory(category, boardPage.getPageNum(), boardPage.getRowsPerPage());
//		List<BoardFaq> list = null;
//		list = boardFaqService.listByCategory(category, boardPage.getPageNum(), boardPage.getRowsPerPage());
//
//		model.addAttribute("list", list);
		
		return "boardfaq/searchByCategory";
	}*/
	
	public void setPageConfig(String pageNum, HttpSession session, Model model, String category){
		boardPage = new BoardPage(pageNum, session);
		boardPage.setPageConfig(2, 5, 1);
		
		if(!category.equals("all")){
			boardPage.setTotalBoardNo(boardFaqService.getCountByCategory(category));
			list = boardFaqService.listByCategory(category, boardPage.getPageNum(), boardPage.getRowsPerPage());
		}else{
			boardPage.setTotalBoardNo(boardFaqService.getCount());	
			list = boardFaqService.list(boardPage.getPageNum(), boardPage.getRowsPerPage());
		}
		
		boardPage.setTotalPageConfig();
		
		model.addAttribute("pageNum", boardPage.getPageNum());
		model.addAttribute("rowsPerPage", boardPage.getRowsPerPage());
		model.addAttribute("pagesPerGroup", boardPage.getPagesPerGroup());
		model.addAttribute("totalBoardNo", boardPage.getTotalBoardNo());
		model.addAttribute("totalPageNo", boardPage.getTotalPageNo());
		model.addAttribute("totalGroupNo", boardPage.getTotalGroupNo());
		model.addAttribute("groupNo", boardPage.getGroupNo());
		model.addAttribute("startPageNo", boardPage.getStartPageNo());
		model.addAttribute("endPageNo", boardPage.getEndPageNo());
		
		model.addAttribute("list", list);
//		return boardPage;
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write(){
		return "boardfaq/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardFaq boardFaq, HttpSession session){
		try{
			String mid = (String) session.getAttribute("login");
				
			int result = boardFaqService.write(boardFaq);
			if(result == BoardFaqService.WRITE_FAIL) {
				return "boardfaq/write";
			} else {
				return "redirect:/boardfaq/list?category=" + boardFaq.getFbcategory();
			}
		}catch(Exception e){
			e.printStackTrace();
			return "boardfaq/write";
		}	

	}
	
}
