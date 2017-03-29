<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<%-- head 시작 --%>
<HEAD>
	<title>Spectro Team Project</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%-- ================ 필수 연결 / 시작 ================ --%>	
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<%-- ================ 필수 연결 / 종료 ================ --%>
	<%-- ================ CAPS 관련 CSS&JS / 시작 ================ --%>
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/default.css" rel="stylesheet" type="text/css">
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/common.css" rel="stylesheet" type="text/css">
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/gnb.css" rel="stylesheet" type="text/css">
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/subpage.css" rel="stylesheet" type="text/css">
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/jquery.cookie.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/jquery.ulslide.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/placeholder.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/publish.js" type="text/javascript"></SCRIPT>
	<%-- 사용자 함수 모음--%>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/adt_func.js" type="text/javascript"></SCRIPT>
	<%-- ================ CAPS 관련 CSS&JS / 종료 ================ --%>
	<%-- ================ ★추가 CSS 넣는곳 곳 / 시작 ================ --%> 
	<%-- jumbotron-narrow --%>
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/jumbotron-narrow.css" rel="stylesheet">
	<%-- 개발자 정의 --%>
	<style type="text/css">
	
		.tb2_style .t_style{
			text-align: center;
			font-size: 20px;
			font-weight: normal;
			border-bottom: 1px solid #ccc;
    		color: #62666a;
    		padding: 17px 0 17px 0;
    		line-height: 15px;
		}
		
		.tb2_style th + th {
		    padding: 5px 0 5px 0;
		    color: #9ea0a3;
		    font-size: 15px;
		}
		
		.tb2_style td{
			padding-top: 10px;
		}
		
		.content_area{
			min-width: 0;
			position: absolute;
	    	top: 0;
	    	left: 0;
		}
		
		.content_in {
			width:670px;
			margin: auto;
			margin-top: 70px;
		}
		
		.content_in h2 {
			font-size:24px;
			height:30px;
			line-height:30px;
			margin-bottom:8px;
		}
		
	</style>
	<%-- ================ ★추가 CSS 넣는곳 곳 / 종료 ================ --%>
	<%-- ================ ★추가 자바 스크립트 넣는 곳 / 시작 ================ --%>	
	<script type="text/javascript">
		
		$(function(){
			$("#btn_confirm").on("click", function(){
				if($('#mid').val().replace(/ /g, '') == ""){
					alert("아이디를 작성해 주세요.");
				}else if($('#mpassword').val().replace(/ /g, '') == ""){
					alert("비밀번호를 작성해 주세요.");
				}else if($('#mname').val().replace(/ /g, '') == ""){
					alert("이름을 작성해 주세요.");
				}else if($('#memail').val().replace(/ /g, '') == ""){
					alert("이메일을 작성해 주세요.");
				}else if($('#maddress').val().replace(/ /g, '') == ""){
					alert("주소를 작성해 주세요.");
				}else if($('#mtel').val().replace(/ /g, '') == ""){
					alert("전화번호를 작성해 주세요.");
				}else if($('#mlevel').val().replace(/ /g, '') == ""){
					alert("권한을 작성해 주세요.");
				}else{
					$("#join").submit();
				}
			});
			
			$("#btn_cancel").on("click", function(){
				console.log("click");
				history.back();
			}); 
		});
			
	</script>
	<%-- ================ ★추가 자바 스크립트 넣는 곳 / 종료 ================ --%>
</HEAD>
<%-- head 종료 --%>
<%-- body 시작 --%>
<BODY>
	<!-- <INPUT id="currentID" type="hidden"> -->	
	<SECTION id="container" style="position: fixed;">
		<%--header 시작--%>
		
		<%-- <%@ include file = "../template/top.jsp" %> --%>
		
		<%--//header 끝--%>
		
		<%--content 시작--%>
			<%-- 2015.08.07 추가및 영역변경 시작--%>
		<DIV class="content_area">
			<div class="content_area_scroll">
				<div class="content_in">
					<%--2015.08.06 이미지를 텍스트로변경--%>
					<h2>회원 추가</h2>

					<%-- <input type="hidden" name="subDir" value="notice/"> --%>

					<%--공지사항 내용시작--%>
					<%-- 2015.07.27 수정 table 밖으로 div 추가 및 <col style="width:550px;"> 수정 --%>
					<%-- 2015.08.06 table 스크롤div삭제
					<div class="tb_boxsc mt60"> --%>
					<form id="join" method="post">
						<table class="tb2_style">
							<colgroup>
								<col style="width : 120px">
								<col style="width: 550px;">
							</colgroup>
							<thead>
								<tr>
									<th class="t_style">아이디</th>
									<th>
										<input type="text" id="mid" name="mid" class="form-control" style="height: 28px">
										<%--등록일<span>12.06.13</span>--%>
									</th>
								</tr>
							</thead>
							<tbody>
								<tr>	
									<td class="t_style">비밀번호</td>
									<td style="padding: 10px 0;">
										<input type="password" id="mpassword" name="mpassword" class="form-control" style="height: 28px">
									</td>
								</tr>
								<tr>	
									<td class="t_style">이름</td>
									<td style="padding: 10px 0;">
										<input type="text" id="mname" name="mname" class="form-control" style="height: 28px">
									</td>
								</tr>
								<tr>	
									<td class="t_style">이메일</td>
									<td style="padding: 10px 0;">
										<input type="email" id="memail" name="memail" class="form-control" style="height: 28px">
									</td>
								</tr>
								<tr>	
									<td class="t_style">주소</td>
									<td style="padding: 10px 0;">
										<input type="text" id="maddress" name="maddress" class="form-control" style="height: 28px">
									</td>
								</tr>
								<tr>	
									<td class="t_style">전화번호</td>
									<td style="padding: 10px 0;">
										<input type="tel" id="mtel" name="mtel" class="form-control" style="height: 28px">
									</td>
								</tr>
								<tr>	
									<td class="t_style">권한</td>
									<td style="padding: 10px 0;">
										<input type="text" id="mlevel" name="mlevel" class="form-control" style="height: 28px">
									</td>
								</tr>
								<tr>	
									<td class="t_style"></td>
									<td>
										<div class="confirm pull-right" style="padding: 0 0 10px 0;">
											<button id="btn_confirm" type="button" class="btn btn-primary">확인</button>
											<button id="btn_cancel" type="button" class="btn btn-warning">취소</button>
										</div>
									</td>
								</tr>
								
																
							</tbody>
							
						</table>
					</form>
					<%-- 2015.08.06 table 스크롤div삭제</div>--%>
					<%--공지사항리스트 내용끝--%>
				</div>
				
			</DIV>

			
		</DIV>
	</SECTION>
	
</BODY>
<%-- body 종료 --%>
</HTML>
