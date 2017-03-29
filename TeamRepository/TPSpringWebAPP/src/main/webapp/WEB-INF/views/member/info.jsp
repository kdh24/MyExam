<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
<title>Spectro Team Project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>

<!-- ★추가 CSS 넣는곳 곳 / 시작 -->
<link
	href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/jumbotron-narrow.css"
	rel="stylesheet">
<style type="text/css">
	#wrap { position:fixed; top:0px; left:0px; width:100%; height:100%; 
            min-width: 1400px; min-height: 780px; 
            background-image: url("<%=pageContext.getServletContext().getContextPath()%>/resources/image/bg_morning.jpg");
            background-size: cover; transition: all 2s;
    }
      
    #member_info{
    	width: 80%;
    	margin: auto;
    }  
</style>
<!-- ★추가 CSS 넣는 곳 / 종료 -->
<!-- ★추가 자바 스크립트 넣는 곳 / 시작 -->
<script type="text/javascript">
	
</script>
<!-- ★추가 자바 스크립트 넣는 곳 / 종료 -->
</head>
<!-- head 종료 -->
<!-- body 시작 -->
<body
	style="background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg)">
	회원 정보
	<hr />
	<div id="wrap">
		<form role="form">
			<fieldset>
				<legend>회원 정보</legend>
			</fieldset>
			<div class="form-group">
				<label for="subject" class="col-md-2 control-label">아이디</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="subject" value="${member.mid}">
				</div>
			</div>
			<div class="form-group">
				<label for="subject" class="col-md-2 control-label">이름</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="subject" value="${member.mname}">
				</div>
			</div>
			<div class="form-group">
				<label for="subject" class="col-md-2 control-label">이메일</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="subject" value="${member.memail}">
				</div>
			</div>
			<div class="form-group">
				<label for="subject" class="col-md-2 control-label">주소</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="subject" value="${member.maddress}">
				</div>
			</div>
			<div class="form-group">
				<label for="subject" class="col-md-2 control-label">전화번호</label>
				<div class="col-md-10">
					<input type="text" class="form-control" id="subject" value="${member.mtel}">
				</div>
			</div>
			<c:if test="${login == member.mid}">
			<div>
				<a href="modify?mid=${member.mid}">[수정]</a> <a
					href="remove?mid=${member.mid}">[삭제]</a>
			</div>
		</c:if>
		</form>
	
		
	</div>
</body>
<!-- body 종료 -->
</html>
