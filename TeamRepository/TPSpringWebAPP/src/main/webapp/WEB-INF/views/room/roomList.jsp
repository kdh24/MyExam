<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body style="background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg)" >
	Room List
	<hr/>
	<div>	
		<div>
		<span style="border: 1px solid black;">서비스 소개</span><span style="border: 1px solid black;">게시판</span><span style="border: 1px solid black;">내방 상태확인</span><span style="border: 1px solid black;">계약관리</span><span style="border: 1px solid black;">로그?</span>
		</div>
		<div>
			<c:forEach var="room" items="${list}">
				<a href="roomInfo?rid=${room.rid}"><img src="#" style="width: 200px"></a>
			</c:forEach>
		</div>
	</div>
	
</body>
<!-- body 종료 -->
</html>
