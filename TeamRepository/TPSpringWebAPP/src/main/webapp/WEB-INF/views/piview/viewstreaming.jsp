<%@ page contentType="application/json;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
{
		"nowvoTH_tid":${nowvoTH.tid},
		"nowvoTH_trid":${nowvoTH.trid}, 
		"nowvoTH_tdate":"${nowvoTH.tdate}",
		"nowvoTH_ttemperature":${nowvoTH.ttemperature},
		"nowvoTH_thumidity":${nowvoTH.thumidity},
		
		"nowvoGas_gid":${nowvoGas.gid},
		"nowvoGas_grid":${nowvoGas.grid}, 
		"nowvoGas_gdate":"${nowvoGas.gdate}",
		"nowvoGas_ggas":${nowvoGas.ggas},
		"nowvoGas_gstate":${nowvoGas.gstate},
		
		"nowvoFlame_fid":${nowvoFlame.fid},
		"nowvoFlame_frid":${nowvoFlame.frid}, 
		"nowvoFlame_fdate":"${nowvoFlame.fdate}",
		"nowvoFlame_fflame":${nowvoFlame.fflame},
		"nowvoFlame_fstate":${nowvoFlame.fstate},
		
		"nowvoVisitor_vid":${nowvoVisitor.vid},
		"nowvoVisitor_vrid":${nowvoVisitor.vrid}, 
		"nowvoVisitor_vdate":"${nowvoVisitor.vdate}",
		"nowvoVisitor_vstate":${nowvoVisitor.vstate}
}