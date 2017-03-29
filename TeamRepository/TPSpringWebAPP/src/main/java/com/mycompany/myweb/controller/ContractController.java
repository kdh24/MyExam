package com.mycompany.myweb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myweb.dto.Contract;
import com.mycompany.myweb.dto.Flame;
import com.mycompany.myweb.dto.Gas;
import com.mycompany.myweb.dto.Member;
import com.mycompany.myweb.dto.Room;
import com.mycompany.myweb.dto.TemperatureHumidity;
import com.mycompany.myweb.dto.Visitor;
import com.mycompany.myweb.service.ContractService;
import com.mycompany.myweb.service.FlameService;
import com.mycompany.myweb.service.GasService;
import com.mycompany.myweb.service.MemberService;
import com.mycompany.myweb.service.RoomService;
import com.mycompany.myweb.service.TemperatureHumidityService;
import com.mycompany.myweb.service.VisitorService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/contract")
public class ContractController {
	private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private TemperatureHumidityService temperatureHumidityService;
	
	@Autowired
	private GasService gasService;
	
	@Autowired
	private FlameService flameService;
	
	@Autowired
	private VisitorService visitorService;

	@RequestMapping("/detail")
	public String index(String crid, String cday, HttpSession session, Model model) {
		logger.info("############ crid: " + crid);
		logger.info("############ cday: " + cday);
		
		try{
			
			logger.info("********* detail *********");
			String loginMid = (String) session.getAttribute("login");
			logger.info(loginMid);
			Member member = memberService.info(loginMid, null);
			
			List<Room> rlist = null;
			
			if(member != null){
				model.addAttribute("member", member);

				rlist = roomService.roomList(member.getMid());
			}
			
			if (rlist != null) {
				model.addAttribute("list", rlist);
				Contract contract = contractService.info(rlist.get(0).getRid());
				if (contract != null) {
					model.addAttribute("contract", contract);
				}
			}
			
			int rid=0;
			
			if(crid == null){
				rid = rlist.get(0).getRid(); //<------------------------------------------------------- 데이터 맞춰야 함.
				logger.info("******** null rid = " + rid);
			}else{
				rid = Integer.parseInt(crid);
				logger.info("******** not null rid = " + rid);
			}
			model.addAttribute("rid", rid);
			
			// -----------------------------------
			
			Room roomInfo = roomService.info(rid);
			Contract contract = contractService.info(rid);
			model.addAttribute("roomName", roomInfo.getRname());

			logger.info(roomInfo.getRname());
			model.addAttribute("contract", contract);
			
			// ----------------------------------
			
			if(cday == null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String today =  sdf.format(new Date());
				cday = today;
				logger.info("******** cday = " + cday);
			}
			model.addAttribute("cday", cday);
			
			String[] tempArrayDay = cday.split("-");
			String day = tempArrayDay[0]+tempArrayDay[1]+tempArrayDay[2] +"%";
			logger.info("******** day = " + day);
			
			String jsonStr = null;
			
			List<TemperatureHumidity> tlist = temperatureHumidityService.list(rid, day);
			if(tlist != null){
				JSONArray jsonArray = JSONArray.fromObject(tlist);
				jsonStr = jsonArray.toString();
				model.addAttribute("tlist", jsonStr);
				logger.info("********** tlist = " + tlist.size());
				logger.info("jsonStr = " + jsonStr);
			}else{
				model.addAttribute("tlist", jsonStr);
				logger.info("jsonStr = " + jsonStr);
			}
			
			List<Flame> flist = flameService.list(rid, day);
			if(flist != null){
				JSONArray jsonArray = JSONArray.fromObject(flist);
				jsonStr = jsonArray.toString();
				model.addAttribute("flist", jsonStr);
				logger.info("********** flist = " + flist.size());
			}else{
				model.addAttribute("flist", jsonStr);
			}
			
			List<Gas> glist = gasService.list(rid, day);
			if(glist != null){
				JSONArray jsonArray = JSONArray.fromObject(glist);
				jsonStr = jsonArray.toString();
				model.addAttribute("glist", jsonStr);
				logger.info("********** glist = " + glist.size());
			}else{
				model.addAttribute("glist", jsonStr);
			}
			
			List<Visitor> vlist = visitorService.list(rid, day);
			if(vlist != null){
				JSONArray jsonArray = JSONArray.fromObject(vlist);
				jsonStr = jsonArray.toString();
				model.addAttribute("vlist", jsonStr);
				logger.info("********** vlist = " + vlist.size());
			}else{
				model.addAttribute("vlist", jsonStr);
			}
			
		}catch(Exception e){
			
			model.addAttribute("tlist", "null");
			model.addAttribute("flist", "null");
			model.addAttribute("glist", "null");
			model.addAttribute("vlist", "null");
			
			e.getStackTrace();
		}
		return "contract/detail";
	}
	
	
	@RequestMapping("/select")
	public String select(String room, Model model) {
		
		logger.info(room);
		int rmid = Integer.parseInt(room);
//		model.addAttribute("result", room);
		
		// jsp 넘긴 ul li의 value값(rid 넘버)을 받아서 해당 룸의 rid 번호로 룸객체 가져오기 
		Room roomInfo = roomService.info(rmid);
		
		// rid로 contract(계약) 객체 가져오기
		Contract contract = contractService.info(rmid);
		
		// 해당 rid 기준 roomName model로 넘겨주기 
		model.addAttribute("roomName", roomInfo.getRname());
		// 계약 객체 넘겨주기 
		model.addAttribute("contract", contract);
		
		// ajax로 넘겨받을 jsp 경로
		return "contract/select";
	}
	
	@RequestMapping("/value")
	public String getValue(String room, Model model) {
		
		logger.info(room);
		int rmid = Integer.parseInt(room);
//		model.addAttribute("result", room);
		Room roomInfo = roomService.info(rmid);
		Contract contract = contractService.info(rmid);
		model.addAttribute("roomName", roomInfo.getRname());

		logger.info(roomInfo.getRname());
		model.addAttribute("contract", contract);

		logger.info(String.valueOf(contract));
		return "contract/value";
	}
}
