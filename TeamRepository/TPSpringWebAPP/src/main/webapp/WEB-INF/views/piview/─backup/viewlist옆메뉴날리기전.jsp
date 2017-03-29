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
				<li class="active"><a href="<%=pageContext.getServletContext().getContextPath()%>/piview/viewlist">전체</a></li>
				<li class="divider"></li>
				<li><a href="<%=pageContext.getServletContext().getContextPath()%>/piview/viewmain">201호</a></li>
				<li><a href="#">202호</a></li>
				<li><a href="#">203호</a></li>
				<li><a href="#">204호</a></li>
			</ul>
		</div>
		<div style="text-align:center; width:460px; display: inline-block; margin:0px; ">
			<span style="font-size: 15px; color: white;">
			[처음] [이전] 1 2 3 4 5 6 7 8 9 [다음] [마지막]
			</span>
		</div>
		<!-- 크기 625 / 끝-->
 	</div>
	<!-- 상단 메뉴 / 종료 -->
	<!-- 카메라 뷰 리스트 / 시작 -->		
	<div style="width:625px; height:625px; margin:0px; padding-top:10px; padding-left:10px; display:inline-block; text-align:left; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);">
	 	<!--1 -->
		<div style="position:relative; width:300px; height:300px; margin:0px; text-align:center; display: inline-block;">
			<div style="position:absolute; top:15px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">온도 : 24 ℃</span>
			</div>
			<div style="position:absolute; top:30px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">습도 : 24 %</span>
			</div>
			<div style="position:absolute; top:45px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">화재 : 정상</span>
			</div>
			<div style="position:absolute; top:60px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">가스 : 정상</span>
			</div>
			<div style="position:absolute; top:75px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">문상태 : 닫힘</span>
			</div>		
			<div style="position:absolute; top:265px; left:10px; text-align:left; background-color: black; border: 1px solid white;">
				<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">201호</span>
			</div>
			<img style="width: 300px; height: 300px;" class="thumbnail" src="http://192.168.0.24:50001?action=stream">
			<%-- <img style="width: 600px; height: 600px;" class="thumbnail" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg" > --%>	
		</div>
	 	<!--2 -->
		<div style="position:relative; width:300px; height:300px; margin:0px; text-align:center; display: inline-block;">
			<div style="position:absolute; top:15px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">온도 : 24 ℃</span>
			</div>
			<div style="position:absolute; top:30px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">습도 : 24 %</span>
			</div>
			<div style="position:absolute; top:45px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">화재 : 정상</span>
			</div>
			<div style="position:absolute; top:60px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">가스 : 정상</span>
			</div>
			<div style="position:absolute; top:75px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">문상태 : 닫힘</span>
			</div>		
			<div style="position:absolute; top:265px; left:10px; text-align:left; background-color: black; border: 1px solid white;">
				<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">202호</span>
			</div>
			<img style="width: 300px; height: 300px;" class="thumbnail" src="http://192.168.0.24:50001?action=stream">
			<%-- <img style="width: 600px; height: 600px;" class="thumbnail" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg" > --%>	
		</div>
	 	<!--3 -->
		<div style="position:relative; width:300px; height:300px; margin:0px; text-align:center; display: inline-block;">
			<div style="position:absolute; top:15px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">온도 : 24 ℃</span>
			</div>
			<div style="position:absolute; top:30px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">습도 : 24 %</span>
			</div>
			<div style="position:absolute; top:45px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">화재 : 정상</span>
			</div>
			<div style="position:absolute; top:60px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">가스 : 정상</span>
			</div>
			<div style="position:absolute; top:75px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">문상태 : 닫힘</span>
			</div>		
			<div style="position:absolute; top:265px; left:10px; text-align:left; background-color: black; border: 1px solid white;">
				<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">203호</span>
			</div>
			<img style="width: 300px; height: 300px;" class="thumbnail" src="http://192.168.0.24:50001?action=stream">
			<%-- <img style="width: 600px; height: 600px;" class="thumbnail" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg" > --%>	
		</div>
	 	<!--4 -->
		<div style="position:relative; width:300px; height:300px; margin:0px; text-align:center; display: inline-block;">
			<div style="position:absolute; top:15px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">온도 : 24 ℃</span>
			</div>
			<div style="position:absolute; top:30px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">습도 : 24 %</span>
			</div>
			<div style="position:absolute; top:45px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">화재 : 정상</span>
			</div>
			<div style="position:absolute; top:60px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">가스 : 정상</span>
			</div>
			<div style="position:absolute; top:75px; left:225px; width:70px; text-align:left;">
				<span style="font-size:10px; color: white">문상태 : 닫힘</span>
			</div>		
			<div style="position:absolute; top:265px; left:10px; text-align:left; background-color: black; border: 1px solid white;">
				<span style="font-size:15px; color: white; padding-left:5px;padding-right:5px;">204호</span>
			</div>
			<img style="width: 300px; height: 300px;" class="thumbnail" src="http://192.168.0.24:50001?action=stream">
			<%-- <img style="width: 600px; height: 600px;" class="thumbnail" src="<%=pageContext.getServletContext().getContextPath()%>/resources/imagespiview/blank.jpg" > --%>	
		</div>
	</div>
	<!-- 카메라 뷰 리스트 / 종료 -->
	<!-- 방문내역 시작 -->
	<div style="position:absolute;  width:200px; height:625px; margin:0px; padding-top:10px; padding-right:10px; display:inline-block; background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg);">
		<div id="scrollDiv" style="position:absolute;  width:190px; height:600px; overflow:scroll; overflow-x:hidden; margin:0px; ">
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
		이벤트 로그<br>
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

