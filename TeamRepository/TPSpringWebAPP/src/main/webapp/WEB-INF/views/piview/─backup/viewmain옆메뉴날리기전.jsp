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
	
	function dasi(i) {
	    if (i<10) {i = "0" + i};
	    return i;
	}

	$(function(){
		//계속 사용하는 값 저장
		var contextPath = getContextPath();
		var nowRoomId = ${nowRoomid};
		
		//통신 시작
		var interval = setInterval(function(){
			$.ajax({
				url : contextPath + "/piview/viewstreaming",
				data: "roomId="+ nowRoomId,
				success: function(data) {
					/*console.log("==============================");
					console.log("data안의 내용은? " + data);
					console.log(data);
					console.log(data.length);
					console.log("==============================");*/
				    var onul=new Date();		/* 로컬컴퓨터에 설정된 표준시간대를 기준으로 한 현재 시간을 추출 */
				    var dd=["Sun","Mon","Tues","Wednes","Thurs","Fri","Satur"];
				    var d=onul.getDay();		/*현재 '요일'을 숫자로 추출 */
				    var h=onul.getHours();		/*현재 '시'를 숫자로 추출 */
				    var m=onul.getMinutes();	/*현재 '분'을 숫자로 추출 */
				    var s=onul.getSeconds();	/*현재 '초'를 숫자로 추출 */
				    m = dasi(m);
				    s = dasi(s);
				    $("#nowTimeDiv").css("display","inline-block");
					$("#nowTime").html(dd[d]+"day "+h+":"+m+":"+s);
					
					$("#nowvoTH_ttemperature").html("온도 : " + data.nowvoTH_ttemperature + " ℃");
					$("#nowvoTH_thumidity").html("습도 : " + data.nowvoTH_thumidity + " %");
					$("#nowvoGas_ggas").html("공기 : " + data.nowvoGas_ggas);
					if(data.nowvoGas_gstate == true){
						$("#nowvoGas_gstate").css("color","#ED1C24");
						$("#nowvoGas_gstate").html("가스 : 발생");
					}else{
						$("#nowvoGas_gstate").css("color","#FFFFFF");
						$("#nowvoGas_gstate").html("가스 : 정상");
					}

					if(data.nowvoFlame_fstate == true){
						$("#nowvoFlame_fstate").css("color","#ED1C24");
						$("#nowvoFlame_fstate").html("화재 : 발생");
					}else{
						$("#nowvoFlame_fstate").css("color","#FFFFFF");
						$("#nowvoFlame_fstate").html("화재 : 정상");
					}

					if(data.nowvoVisitor_vstate == true){
						$("#nowvoVisitor_vstate").css("color","#ED1C24");
						$("#nowvoVisitor_vstate").html("문상태 : 열림");
					}else{
						$("#nowvoVisitor_vstate").css("color","#FFFFFF");
						$("#nowvoVisitor_vstate").html("문상태 : 닫힘");
					}
										
					var html = "";
						html += "== 온도습도 ==" + '<br/>';
						html += data.nowvoTH_tid + '<br/>';
						html += data.nowvoTH_trid + '<br/>';
						html += data.nowvoTH_tdate + '<br/>';
						html += data.nowvoTH_ttemperature + '<br/>';
						html += data.nowvoTH_thumidity + '<br/>';
						
						html += "== 가스 ==" + '<br/>';
						html += data.nowvoGas_gid + '<br/>';
						html += data.nowvoGas_grid + '<br/>';
						html += data.nowvoGas_gdate + '<br/>';
						html += data.nowvoGas_ggas + '<br/>';
						html += data.nowvoGas_gstate + '<br/>';
						
						html += "== 화재 ==" + '<br/>';
						html += data.nowvoFlame_fid + '<br/>';
						html += data.nowvoFlame_frid  + '<br/>';
						html += data.nowvoFlame_fdate + '<br/>';
						html += data.nowvoFlame_fflame + '<br/>';
						html += data.nowvoFlame_fstate + '<br/>';
						
						html += "== 방문자 ==" + '<br/>';
						html += data.nowvoVisitor_vid + '<br/>';
						html += data.nowvoVisitor_vrid + '<br/>';
						html += data.nowvoVisitor_vdate + '<br/>';
						html += data.nowvoVisitor_vstate + '<br/>';
					$("#scrollDiv").html(html);	
				}
			});
		
		}, 1000);
		
	});
	
	</script>
	<!-- ★추가 자바 스크립트 넣는 곳 / 종료 -->	
</head>
<!-- head 종료 -->
<!-- body 시작 -->

<!-- <iframe width="250" height="250" marginwidth="110" marginheight="110" style="margin:0px; margin-left: 0px; " src="https://www.youtube.com/embed/Dz3Jon0F7oQ" frameborder="0" allowfullscreen></iframe> -->		
<!-- <embed style="margin:0px; margin-left: 0px; " width="600" height="600" src="https://www.youtube.com/embed/Dz3Jon0F7oQ?servion=2&autoplay=1&loop=1?servion=2&autoplay=1&loop=1" frameborder="2" allowfullscreen=""></embed> -->
<%-- <body style="margin:0px; padding:0px; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);" > --%>

<body style="margin:0px; padding:0px;" >
	<%-- <IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/test.jpg" height="100%" width="100%"> --%>
	<!-- 상단 메뉴 / 시작 -->	
	<div style="width:825px; height:50px; background-color: black; padding:8px; " >
		<!-- 크기 625 / 시작-->
		<div class="btn-group" style="width:125px; display: inline-block; margin:0px; ">
			<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				Room <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu">
				<li><a href="<%=pageContext.getServletContext().getContextPath()%>/piview/viewlist">전체</a></li>
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
			
			</span>
		</div>
		<!-- 크기 625 / 끝-->
 	</div>
	<!-- 상단 메뉴 / 종료 -->
	<!-- 카메라 뷰 리스트 / 시작 -->		
	<div style="width:625px; height:625px; margin:0px; padding-top:10px; padding-left:10px; display:inline-block; text-align:left; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);">
	 	<!--1 -->
		<div style="position:relative; width:615px; height:615px; margin:0px; text-align:center;">
			<div id="nowTimeDiv" style="position:absolute; top:10px; left:230px; width:150px; height:20px; text-align:center; background-color: black; display:none;">
				<span id="nowTime" style="font-size: 12px; color: white"></span>
			</div>
			<div style="position:absolute; top:70px; left:500px; width:80px; height:20px; text-align:left;">
				<span id="nowvoTH_ttemperature" style="font-size: 12px; color: white"></span>
			</div>
			<div style="position:absolute; top:90px; left:500px; width:80px; height:20px; text-align:left;">
				<span id="nowvoTH_thumidity" style="font-size: 12px; color: white"></span>
			</div>
			<div style="position:absolute; top:110px; left:500px; width:80px; height:20px; text-align:left;">
				<span id="nowvoGas_ggas" style="font-size: 12px; color: white"></span>
			</div>
			<div style="position:absolute; top:130px; left:500px; width:70px; height:20px; text-align:left;">
				<span id="nowvoGas_gstate" style="font-size: 12px; color: white"></span>
			</div>
			<div style="position:absolute; top:150px; left:500px; width:70px; height:20px; text-align:left;">
				<span id="nowvoFlame_fstate" style="font-size: 12px; color: white"></span>
			</div>
			<div style="position:absolute; top:170px; left:500px; width:70px; height:20px; text-align:left;">
				<span id="nowvoVisitor_vstate" style="font-size: 12px; color: white"></span>
			</div>	
			<div style="position:absolute; top:565px; left:10px; text-align:left; background-color: black; border: 1px solid white;">
				<c:forEach var="room" items="${nowRoomList}">
					<c:if test="${room.rid == nowRoomid}">
						<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">${room.rname}</span>
					</c:if>
				</c:forEach>
			</div>
			<!-- <div style="position:absolute; top:565px; left:520px; text-align:left; background-color: black; border: 1px solid white;">
				<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">IOT 정상</span>
			</div>
			<div style="display:none; position:absolute; top:565px; left:518px; text-align:left; background-color: red; border: 1px solid white;">
				<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">IOT 고장</span>
			</div> -->
			<c:if test="${nowRoomid == 100}">
				<!-- <img style="width: 600px; height: 600px;" class="thumbnail" src="http://192.168.0.24:50001?action=stream"> -->
				<img style="width: 600px; height: 600px;" class="thumbnail" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg">
			</c:if>
			<c:if test="${nowRoomid != 100}">
				<img style="width: 600px; height: 600px;" class="thumbnail" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg">
			</c:if>

		</div>

	</div>
	<!-- 카메라 뷰 리스트 / 종료 -->
	<!-- 방문내역 시작 -->
	<div style="position:absolute;  width:200px; height:625px; margin:0px; padding-top:10px; padding-right:10px; display:inline-block; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);">
		<div id="scrollDiv" style="position:absolute;  width:190px; height:600px; overflow:scroll; overflow-x:hidden; margin:0px; ">
			<!-- 이벤트로그 -->
		</div>
		<script>
			var divdiv = document.getElementById("scrollDiv");
			divdiv.scrollTop = divdiv.scrollHeight; 
		</script>
	</div>
	<!-- 방문내역 / 종료 -->

</body>
<!-- body 종료 -->
</html>

