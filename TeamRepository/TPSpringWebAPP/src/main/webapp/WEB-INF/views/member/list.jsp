<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<HTML>
<!-- head 시작 -->
<HEAD>
	<title>Spectro Team Project</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- ================ 필수 연결 / 시작 ================ -->	
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	<!-- ================ 필수 연결 / 종료 ================ -->
	<!-- ================ CAPS 관련 CSS&JS / 시작 ================ -->
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/default.css" rel="stylesheet" type="text/css">
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/common.css" rel="stylesheet" type="text/css">
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/gnb.css" rel="stylesheet" type="text/css">
	<LINK href="<%=pageContext.getServletContext().getContextPath()%>/resources/capscss/subpage.css" rel="stylesheet" type="text/css">
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/jquery.cookie.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/jquery.ulslide.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/placeholder.js" type="text/javascript"></SCRIPT>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/publish.js" type="text/javascript"></SCRIPT>
	<!-- 사용자 함수 모음-->
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/adt_func.js" type="text/javascript"></SCRIPT>
	<!-- ================ CAPS 관련 CSS&JS / 종료 ================ -->
	<!-- ================ ★추가 CSS 넣는곳 곳 / 시작 ================ --> 
	<!-- jumbotron-narrow -->
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/jumbotron-narrow.css" rel="stylesheet">
	<!-- 개발자 정의 -->
	<style type="text/css">
	th{
		text-align: center;
	}
	
	#pagenum a{
		color:#8f9295;
		font-size: 13px;
	}
	
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
	<!-- ================ ★추가 CSS 넣는곳 곳 / 종료 ================ -->
	<!-- ================ ★추가 자바 스크립트 넣는 곳 / 시작 ================ -->	
	<script type="text/javascript">
	
	</script>
	<!-- ================ ★추가 자바 스크립트 넣는 곳 / 종료 ================ -->
</HEAD>
<!-- head 종료 -->
<!-- body 시작 -->
<BODY>
	<INPUT id="currentID" type="hidden">	
	<SECTION id="container" style="position: fixed;">
	
		<script type="text/javascript">
			$(function() {
				gnbSelect(7);
			})
		</script>
		<!--content 시작-->
		<DIV>
			<!-- ★★★컨텐츠 영역★★★★ / start-->
			<div><!-- 스크롤 처리되는 div -->

				<div class="content_in">

					<form name="noticeForm" id="noticeForm" method="post">
						<!--2015.08.06 이미지를 텍스트로변경-->
						<h2>관리자</h2>
						<a class="radius_btn right_btn mb15_w40" href="join" >
							<span>회원 추가</span>
						</a>

						<!--공지사항 내용시작-->
						<table class="tb0_style">
							<caption>관리자</caption>
							<colgroup>
								<col style="width: 100px">
								<col>
								<col style="width: 120px;">
							</colgroup>
							<thead>
								<tr>
									<th>아이디</th>
									<th>이름</th>
									<th>이메일</th>
									<th>주소</th>
									<th>전화번호</th>
									<th>삭제</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="member" items='${list}'>	<%-- 이 표현식은 null값이 들어가도 예외가 발생되지 않는다. --%> 
									<tr>
										<td>${member.mid}</td>
										<td>${member.mname}</td>
										<td>${member.memail}</td>
										<td>${member.maddress}</td>
										<td>${member.mtel}</td>
										<td class="glyphicon glyphicon-trash" onclick="location.href='<%=pageContext.getServletContext().getContextPath()%>/member/remove?mid=${member.mid}'"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- <div class="paginate01">
							<a class="direction prevp" href="/?cont=c05">처음</a> 
							<a href="#" class="active">1</a> 
							<a href="JavaScript:goList('noticeForm', '/?cont=c05', 2)">2</a> 
							<a class="direction nextn" href="/?cont=c05&amp;pageNum=2">끝</a>
						</div> -->

						<div class="paginate01">
							<a class="direction prevp" href="list?pageNo=1"></a>
							<c:if test="${groupNo>1}">
							<a class="direction prev" href="list?pageNo=${startPageNo-1}"></a>
							</c:if>
				            
							<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
							<a href="list?pageNo=${i}" <c:if test="${pageNo==i}"> class="active"</c:if>>
								${i}
							</a>
							</c:forEach>
				                        
							<c:if test="${groupNo<totalGroupNo}">
							<a class="direction next"  href="list?pageNo=${endPageNo+1}"></a>
							</c:if>
							<a class="direction nextn" href="list?pageNo=${totalPageNo}"></a>
						</div>
						<!--공지사항리스트 내용끝-->
					</form>
				</div>

			</div>
				
		</DIV>
	</SECTION>

</BODY>
<!-- body 종료 -->
</HTML>
