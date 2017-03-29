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
	
	<!-- ================ 모달 알림창 관련 JS&CSS ================ -->
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/bootstrap-dialog.min.css" rel="stylesheet" type="text/css">
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/bootstrap-dialog.min.js" type="text/javascript"></SCRIPT>
	
	<%-- ================ ★추가 CSS 넣는곳 곳 / 시작 ================ --%> 
	<%-- jumbotron-narrow --%>
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/jumbotron-narrow.css" rel="stylesheet">
	<%-- 개발자 정의 --%>
	<style type="text/css">
	
		.tb2_style{
			margin-top: 20px;
		}
	
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
				if($('#batitle').val().replace(/ /g, '') == ""){
					BootstrapDialog.show({
						title : '안내 메시지',
						message : "제목을 작성해 주세요.",
						size : BootstrapDialog.SIZE_SMALL
					});
				}else if($('#bacontent').val().replace(/ /g, '') == ""){
					BootstrapDialog.show({
						title : '안내 메시지',
						message : "내용을 작성해 주세요.",
						size : BootstrapDialog.SIZE_SMALL
					});
				}else{
					$("#write_form").submit();
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
	<SECTION id="container" style="position: fixed;">
		<DIV class="content_area">
			<div class="content_area_scroll">
				
				<div class="content_in">
					<h2>A/S 문의</h2>

					<form id="write_form" method="post">
						<table class="tb2_style">
							<colgroup>
								<col style="width : 120px">
								<col style="width: 550px;">
							</colgroup>
							<thead>
								<tr>
									<th class="t_style">제목</th>
									<th>
										<input type="text" id="batitle" value="${boardas.batitle}" name="batitle" class="form-control" style="height: 28px">
										<%--등록일<span>12.06.13</span>--%>
									</th>
								</tr>
							</thead>
							
							<tbody>
								<tr>	
									<td class="t_style">작성자</td>
									<td style="padding: 10px 0;">
										<input type="hidden" name="bawriter" class="form-control" style="height: 28px" value="${login}">
										<span style="font-size: 17px">${login}</span>
									</td>
	
								</tr>
								<tr style="height: 50vh">
									<td class="t_style">내용</td>
									<td>
										<textarea name="bacontent" id="bacontent" class="form-control" style="height: 90%">${boardas.bacontent}</textarea>
									</td>
								</tr>
							</tbody>
						</table>
						<div>
							<a id="btn_cancel" href="#" class="radius_btn right_btn mt15_w40"><span>취소</span></a>
							<a id="btn_confirm" href="#" class="radius_btn right_btn mt15_w40"><span>확인</span></a>
							
						</div>
					</form>
				</div>
			</DIV>
		</DIV>
	</SECTION>
	
</BODY>
<%-- body 종료 --%>
</HTML>
