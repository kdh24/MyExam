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
		
		.content_area{
			min-width: 0;
			position: absolute;
	    	top: 0;
	    	left: 0;
		}
		
		.content_in {
			width:670px;
			padding-bottom:50px;
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
		
	</script>
	<%-- ================ ★추가 자바 스크립트 넣는 곳 / 종료 ================ --%>
</HEAD>
<%-- head 종료 --%>
<%-- body 시작 --%>
<BODY>
	<SECTION id="container" style="position: fixed;">
		
		<%--content 시작--%>
		<DIV class="content_area">
			<%-- ★★★컨텐츠 영역★★★★ / start--%>
			<div class="content_area_scroll"><%-- 스크롤 처리되는 div --%>
			
				<div class="content_in">
					<h2>A/S 문의</h2>

					<a href="<%=pageContext.getServletContext().getContextPath()%>/boardas/list" class="radius_btn right_btn mb15_w40"><span>목록</span></a>
					<table class="tb2_style">
						<colgroup>
							<col style="">
							<col style="width: 120px;">
						</colgroup>
						<thead>
							<tr>
								<th>${boardas.batitle}</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;등록일<span>${boardas.badate}</span></td>
							</tr>
							<tr>
								<td colspan="2">
									<p></p>
									<div style="width: 95%; margin: auto;">${boardas.bacontent}</div>
									<p></p>
								</td>
							</tr>
						</tbody>
					</table>

					<div>
						<a href="<%=pageContext.getServletContext().getContextPath()%>/boardas/delete?bano=${boardas.bano}" class="radius_btn right_btn mt15_w40"><span>삭제</span></a>	
						<a href="<%=pageContext.getServletContext().getContextPath()%>/boardas/modify?bano=${boardas.bano}" class="radius_btn right_btn mt15_w40"><span>수정</span></a>
					</div>
				</div>
			</div>
			<%-- ★★★컨텐츠 영역★★★★ / end --%>
			
		</DIV>
	</SECTION>
	
</BODY>
<%-- body 종료 --%>
</HTML>
