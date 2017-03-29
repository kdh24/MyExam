package com.mycompany.myweb.piview;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Flame;
import com.mycompany.myweb.dto.Gas;
import com.mycompany.myweb.dto.Room;
import com.mycompany.myweb.dto.TemperatureHumidity;
import com.mycompany.myweb.dto.Visitor;
import com.mycompany.myweb.service.FlameService;
import com.mycompany.myweb.service.GasService;
import com.mycompany.myweb.service.RoomService;
import com.mycompany.myweb.service.TemperatureHumidityService;
import com.mycompany.myweb.service.VisitorService;

@Controller
@RequestMapping("/piview")
public class ViewController {	
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);

	@RequestMapping("/viewtest")
	public String viewtest() {
		logger.info("■CTL■ piview-test 호출");
		return "piview/viewindex";
	}
	
	@Autowired
	private RoomService roomService;
	
	@RequestMapping("/viewlist")
	public String viewlist(HttpSession session, Model model) {
		logger.info("■CTL■ piview-list 호출");
		String rmid = (String) session.getAttribute("login");
		List<Room> roomList = roomService.roomList(rmid);
		model.addAttribute("nowRoomList", roomList);
		
		return "piview/viewlist";
	}
	
	@RequestMapping("/viewmain")
	public String viewmain(int roomId, HttpSession session, Model model) {
		logger.info("■CTL■ piview-main 호출");
		//현재 로그인한 사용자의 룸 리스트 받아오기
		String rmid = (String) session.getAttribute("login");
		List<Room> roomList = roomService.roomList(rmid);
		model.addAttribute("nowRoomList", roomList);

		//현재 보려는 룸 아이디
		model.addAttribute("nowRoomid", roomId); //el에 객체등록
		return "piview/viewmain";
	}
	
	
	@Autowired
	private TemperatureHumidityService temperatureHumidityService;
	@Autowired
	private FlameService flameService;
	@Autowired
	private GasService gasService;
	@Autowired
	private VisitorService visitorService; 
	@RequestMapping("/viewstreaming")
	public String viewstreaming(int roomId, Model model) {
		//logger.info("■CTL■ piview-streaming 호출 / 룸아이디 : " + roomId);
		
		TemperatureHumidity voTH = temperatureHumidityService.endofinfo(roomId);
		Gas voGas = gasService.endofinfo(roomId);
		Flame voFlame = flameService.endofinfo(roomId);
		Visitor voVisitor = visitorService.endofinfo(roomId);
		
		model.addAttribute("nowvoTH", voTH); //el에 객체등록
		model.addAttribute("nowvoGas", voGas);
		model.addAttribute("nowvoFlame", voFlame);
		model.addAttribute("nowvoVisitor", voVisitor);
		
		return "piview/viewstreaming";
	}
}
