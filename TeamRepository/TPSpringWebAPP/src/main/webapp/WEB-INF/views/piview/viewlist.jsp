<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
	<title>Spectro Team Project</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	
	<!-- ★추가 CSS 넣는곳 곳 / 시작 -->
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/jumbotron-narrow.css" rel="stylesheet">
	<style type="text/css">




	</style>
	<!-- ★추가 CSS 넣는 곳 / 종료 -->	
	<!-- ★추가 자바 스크립트 넣는 곳 / 시작 -->
	<script type="text/javascript">
	function getContextPath() {
		var hostIndex = location.href.indexOf( location.host ) + location.host.length;
		return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
	};
	
	function startAjax() {
		//계속 사용하는 값 저장
		var contextPath = getContextPath();
		
		<c:forEach var="room" items="${nowRoomList}">
		var nowRoomId = ${room.rid};
		//통신 시작
		$.ajax({
			url : contextPath + "/piview/viewstreaming",
			data: "roomId="+ nowRoomId,
			success: function(data) {
				/*console.log("==============================");
				console.log("data안의 내용은? " + data);
				console.log(data);
				console.log(data.length);
				console.log("==============================");*/
				
				$("#nowvoTH_ttemperature_${room.rid}").html("온도 : " + data.nowvoTH_ttemperature + " ℃");
				$("#nowvoTH_thumidity_${room.rid}").html("습도 : " + data.nowvoTH_thumidity + " %");
				$("#nowvoGas_ggas_${room.rid}").html("공기 : " + data.nowvoGas_ggas);
				if(data.nowvoGas_gstate == true){
					$("#nowvoGas_gstate_${room.rid}").css("color","#ED1C24");
					$("#nowvoGas_gstate_${room.rid}").html("가스 : 발생");
				}else{
					$("#nowvoGas_gstate_${room.rid}").css("color","#FFFFFF");
					$("#nowvoGas_gstate_${room.rid}").html("가스 : 정상");
				}

				if(data.nowvoFlame_fstate == true){
					$("#nowvoFlame_fstate_${room.rid}").css("color","#ED1C24");
					$("#nowvoFlame_fstate_${room.rid}").html("화재 : 발생");
				}else{
					$("#nowvoFlame_fstate_${room.rid}").css("color","#FFFFFF");
					$("#nowvoFlame_fstate_${room.rid}").html("화재 : 정상");
				}

				if(data.nowvoVisitor_vstate == true){
					$("#nowvoVisitor_vstate_${room.rid}").css("color","#ED1C24");
					$("#nowvoVisitor_vstate_${room.rid}").html("문상태 : 열림");
				}else{
					$("#nowvoVisitor_vstate_${room.rid}").css("color","#FFFFFF");
					$("#nowvoVisitor_vstate_${room.rid}").html("문상태 : 닫힘");
				}									

			}
		});
		</c:forEach>
		
		var t = setTimeout(function(){startAjax()},1000);

	}
	</script>
	<!-- ★추가 자바 스크립트 넣는 곳 / 종료 -->	
</head>
<!-- head 종료 -->
<!-- body 시작 -->

<!-- <iframe width="250" height="250" marginwidth="110" marginheight="110" style="margin:0px; margin-left: 0px; " src="https://www.youtube.com/embed/Dz3Jon0F7oQ" frameborder="0" allowfullscreen></iframe> -->		
<!-- <embed style="margin:0px; margin-left: 0px; " width="600" height="600" src="https://www.youtube.com/embed/Dz3Jon0F7oQ?servion=2&autoplay=1&loop=1?servion=2&autoplay=1&loop=1" frameborder="2" allowfullscreen=""></embed> -->
<%-- <body style="margin:0px; padding:0px; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);" > --%>

<body style="margin:0px; padding:0px;" onload="startAjax()">

	<%-- <IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/test.jpg" height="100%" width="100%"> --%>
	<!-- 상단 메뉴 / 시작 -->	
	<div style="width:100%; height:50px; background-color: #222222; padding:8px; " >
		<!-- 크기 625 / 시작-->
		<div class="btn-group" style="width:125px; display: inline-block; margin:0px; ">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				Room <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li class="active"><a href="<%=pageContext.getServletContext().getContextPath()%>/piview/viewlist">전체</a></li>
				<li class="divider"></li>
				<c:forEach var="room" items="${nowRoomList}">
				<li <c:if test="${room.rid == nowRoomid}">class="active"</c:if>>
					<a href="<%=pageContext.getServletContext().getContextPath()%>/piview/viewmain?roomId=${room.rid}">${room.rname}</a>
				</li>
				</c:forEach>
			</ul>
		</div>
		<div style="text-align:center; width:460px; display: inline-block; margin:0px; ">
			<span style="font-size: 15px; color: white;">
			<!-- [처음] [이전] 1 2 3 4 5 6 7 8 9 [다음] [마지막] -->
			</span>
		</div>
		<!-- 크기 625 / 끝-->
 	</div>
	<!-- 상단 메뉴 / 종료 -->
	<!-- 카메라 뷰 리스트 / 시작 -->		
	<div style="width:100%; text-align: center; overflow:scroll; overflow-x:hidden; height:635px; margin:0px; padding:0px; display:inline-block; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);">
		<c:forEach var="room" items="${nowRoomList}">
			<!-- 미니 뷰 / start -->
			<div style="position:relative; width:300px; height:305px; padding-top:5px; text-align:center; display: inline-block;">
				<div style="position:absolute; top:15px; left:225px; width:70px; text-align:left;">
					<span id="nowvoTH_ttemperature_${room.rid}" style="font-size:10px; color: white; background-color: #222222;"></span>
				</div>
				<div style="position:absolute; top:28px; left:225px; width:70px; text-align:left;">
					<span id="nowvoTH_thumidity_${room.rid}" style="font-size:10px; color: white; background-color: #222222;"></span>
				</div>
				<div style="position:absolute; top:41px; left:225px; width:70px; text-align:left;">
					<span id="nowvoGas_ggas_${room.rid}" style="font-size:10px; color: white; background-color: #222222;"></span>
				</div>
				<div style="position:absolute; top:54px; left:225px; width:70px; text-align:left;">
					<span id="nowvoGas_gstate_${room.rid}" style="font-size:10px; color: white; background-color: #222222;"></span>
				</div>
				<div style="position:absolute; top:67px; left:225px; width:70px; text-align:left;">
					<span id="nowvoFlame_fstate_${room.rid}" style="font-size:10px; color: white; background-color: #222222;"></span>
				</div>	
				<div style="position:absolute; top:80px; left:225px; width:70px; text-align:left;">
					<span id="nowvoVisitor_vstate_${room.rid}" style="font-size:10px; color: white; background-color: #222222;"></span>
				</div>					
				<div style="position:absolute; top:275px; left:5px; text-align:left; background-color: black; border: 1px solid white;">
					<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">${room.rname}</span>
				</div>
				<a href="<%=pageContext.getServletContext().getContextPath()%>/piview/viewmain?roomId=${room.rid}">
				<c:choose>
				<c:when test="${room.rid == 100}">
					<img style="width: 300px; height: 300px;" src="http://192.168.0.24:50001?action=stream">
					<%-- <img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/100.jpg"> --%>
				</c:when>
				<c:when test="${room.rid == 101}">
					<img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/101.jpg">			
				</c:when>
				<c:when test="${room.rid == 102}">
					<img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/102.jpg">			
				</c:when>
				<c:when test="${room.rid == 103}">
					<img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/103.jpg">			
				</c:when>
				<c:when test="${room.rid == 104}">
					<img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/104.jpg">			
				</c:when>
				<c:when test="${room.rid == 105}">
					<img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/105.jpg">			
				</c:when>

				<c:otherwise>
					<img style="width: 300px; height: 300px;" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg">
				</c:otherwise>
				</c:choose>
				</a>
			</div>
			<!-- 미니 뷰 / end -->
		</c:forEach>

	</div>
	<!-- 카메라 뷰 리스트 / 종료 -->
</body>
<!-- body 종료 -->
</html>

