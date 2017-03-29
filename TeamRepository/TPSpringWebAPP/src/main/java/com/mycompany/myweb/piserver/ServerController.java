package com.mycompany.myweb.piserver;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.myweb.dto.Flame;
import com.mycompany.myweb.dto.Gas;
import com.mycompany.myweb.dto.TemperatureHumidity;
import com.mycompany.myweb.dto.Visitor;
import com.mycompany.myweb.service.FlameService;
import com.mycompany.myweb.service.GasService;
import com.mycompany.myweb.service.TemperatureHumidityService;
import com.mycompany.myweb.service.VisitorService;

@Controller
@RequestMapping("/piserver")
public class ServerController {	
	private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

	@Autowired
	private TemperatureHumidityService temperatureHumidityService;
	@RequestMapping(value="/acceptdht11", method=RequestMethod.POST)	
	public void AcceptPostDHT11(int trid, double ttemperature, double thumidity, HttpServletResponse response) throws Exception {
		/////////////////////////////////////////////////////////
		// 온도 습도 센서 관련    
		////////////////////////////////////////////////////////
		Date dateEventTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
/*		logger.info("[온도/습도]"
				+ "\t" + sdf.format(dateEventTime)
                + "\t" +"Room ID : " + trid
                + "\t" + "Temperature : " + ttemperature
                + "\t" + "Humidity :" + thumidity
                );*/
        
        TemperatureHumidity voTH = new TemperatureHumidity();
        voTH.setTrid(trid);
        voTH.setTdate(dateEventTime);
        voTH.setTtemperature(ttemperature);
        voTH.setThumidity(thumidity);
		int result = temperatureHumidityService.input(voTH);
		if(result == TemperatureHumidityService.INPUT_FAIL){
			logger.info("[온도/습도]" + "\t" + "insert 실패!");
		}

		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.println("{}");
	}
	
	@Autowired
	private FlameService flameService;
	@RequestMapping(value="/acceptflame", method=RequestMethod.POST)	
	public void AcceptPostFlame(int frid, double fflame, boolean fstate, HttpServletResponse response) throws Exception {
		////////////////////////////////////////////////////////
		// 화재 감지 센서 관련
		////////////////////////////////////////////////////////
        Date dateEventTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
/*        String strPrintState = (fstate==true)?"발생":"정상";
		logger.info("[화재발생]"
				+ "\t" + sdf.format(dateEventTime)
                + "\t" +"Room ID : " + frid
                + "\t" +"Flame : " + fflame
                + "\t" +"State : " + strPrintState
				);*/

        Flame voFlame = new Flame();
        voFlame.setFrid(frid);
        voFlame.setFdate(dateEventTime);
        voFlame.setFflame(fflame);
        voFlame.setFstate(fstate);
		int result = flameService.input(voFlame); 
		if(result == FlameService.INPUT_FAIL){
			logger.info("[화재상태]" + "\t" + "insert 실패!");
		}

		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.println("{}");
	}
	
	@Autowired
	private GasService gasService;
	@RequestMapping(value="/acceptgas", method=RequestMethod.POST)	
	public void AcceptPostGas(int grid, double ggas, boolean gstate, HttpServletResponse response) throws Exception {
		////////////////////////////////////////////////////////
		// 가스 발생 센서 관련
		////////////////////////////////////////////////////////
        Date dateEventTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
/*        String strPrintState = (gstate==true)?"발생":"정상";
		logger.info("[가스상태]"
				+ "\t" + sdf.format(dateEventTime)
                + "\t" +"Room ID : " + grid
                + "\t" +"Gas : " + ggas
                + "\t" +"State : " + strPrintState
				);*/
		
        Gas voGas = new Gas();
        voGas.setGrid(grid);
        voGas.setGdate(dateEventTime);
        voGas.setGgas(ggas);
        voGas.setGstate(gstate);
		int result = gasService.input(voGas); 
		if(result == GasService.INPUT_FAIL){
			logger.info("[가스상태]" + "\t" + "insert 실패!");
		}
		
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.println("{}");
	}

	@Autowired
	private VisitorService visitorService; 
	@RequestMapping(value="/acceptutsn", method=RequestMethod.POST)	
	public void AcceptPostUTSN(int vrid, boolean vstate, HttpServletResponse response) throws Exception {
		////////////////////////////////////////////////////////
		// 거리감지 센서 관련
		////////////////////////////////////////////////////////
        Date dateEventTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        
		//String strPrintState = (Integer.parseInt(vstate)==1)?"OPENED":"CLOSED";
        String strPrintState = (vstate==true)?"OPENED":"CLOSED";
/*		logger.info("[문조작]"
				+ "\t" + sdf.format(dateEventTime)
                + "\t" +"Room ID : " + vrid
				+ "\t" +"DoorState : " + strPrintState
                );*/

		
        Visitor voVisitor = new Visitor();
        voVisitor.setVrid(vrid);
        voVisitor.setVdate(dateEventTime);
        voVisitor.setVstate(vstate);
		int result = visitorService.input(voVisitor); 
		if(result == VisitorService.INPUT_FAIL){
			logger.info("[문조작]" + "\t" + "insert 실패!");
		}
		
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.println("{}");
	}

}
