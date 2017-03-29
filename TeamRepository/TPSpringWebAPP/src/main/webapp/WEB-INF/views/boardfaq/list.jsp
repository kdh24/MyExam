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
		
		.sub_faq{margin-left:20px;}
		.faq_contents a{display:block;}
		
		.sub_faq>h2{margin:50px 10px 20px; font:30px NANUM; color:#333;}
		
		
		.faq_contents>ul:first-child{overflow:hidden; border-bottom:2px solid #999;}
		.faq_contents>ul:first-child>li{float:left; width:155px; background:url(../resources/capsimages/faq_ul_line.png) no-repeat left center;}
		.faq_contents>ul:first-child>li>a{text-align:center; font:12px/50px NANUM; color:#333}
		.faq_contents>ul:first-child .active>a{background:url(../resources/capsimages/faq_ul_back.png) no-repeat center; color:#fff}
		
		.faq_list>li{ background:url(../resources/capsimages/faq_list_q.png) no-repeat 40px 17px;  }
		.faq_list>li>a{font:13px NanumGothic; color:#333; padding:15px 100px; background:url(../resources/capsimages/faq_list_a_img.png) no-repeat right 20px center;border-bottom:1px solid #d0d0d0;}
		
		.faq_list .active>a{background:url(../resources/capsimages/faq_list_a_img_active.png) no-repeat right 20px center;}
		
		.faq_list>li>div{display:none; font:13px/18px NANUM; padding:12px 100px 40px; position:relative; background:#f6f6f6; border-bottom:1px solid #d0d0d0;}
		.faq_list>.active>div{display:block;}
		.faq_list>li>div>span{font-weight:bold; color:#cc6699; display:block; position:absolute; left:39px; top:18px;}

		
 .page>div{width:516px; margin:auto; overflow:hidden; }
 .page>div>ul{float:left; margin:0 5px; font-size:0; width:360px;  text-align:center;}
 .page>div>ul>li{width:28px; border:1px solid #9e9e9e; display:inline-block; margin:0 3px;}
 .page>div>ul>li>a{ font:10px/28px NANUM; color:#696969}
 .page>div>ul .active>a{background:#646464; color:#fff;}
 .page>div>button{margin:0 3px; width:30px; height:30px; font-size:0; float:left;}
 .page>div>button>img{width:80%; margin:2px auto 0}
	
	
	</style>
	<!-- ================ ★추가 CSS 넣는곳 곳 / 종료 ================ -->
	<!-- ================ ★추가 자바 스크립트 넣는 곳 / 시작 ================ -->	
	<script type="text/javascript">
		/* 
	$(function() {
		$(".sub_faq ul li").on("click", function() {
			$(".sub_faq ul li").removeClass("active");
			$(this).addClass("active");
		});
	});
	  */
	
	  $(function() {
			var cBtn = $(".faq_list li");
			var cBtnA = $(".faq_list li div");
//	 		console.log(cBtn);

			cBtn.click(function() {
				if($(this).hasClass("active") == true){
					$(this).removeClass("active");
				} else{
					cBtn.removeClass("active");
					$(this).addClass("active");
					
		
				}
			});
			
			cBtnA.click(function() {
				if($(this).hasClass("active") == true){
					$(this).removeClass("active");
				} else{
					cBtn.removeClass("active");

				}
			});
			
		});
	
	</script>
	<!-- ================ ★추가 자바 스크립트 넣는 곳 / 종료 ================ -->
</HEAD>
<!-- head 종료 -->
<!-- body 시작 -->
<BODY >
			<div class="visual_area">
				<div class="sub_faq">
					<c:if test="${mlevel == 'admin'}">
					<a href="write" class="radius_btn right_btn mt15_w40"><span>FAQ 추가</span></a>
					</c:if>
					<h2>FAQ</h2>
					<div class="faq_contents">
						<ul>
							<li <c:if test="${category=='all'}">class="active"</c:if>><a href="<%=pageContext.getServletContext().getContextPath()%>/boardfaq/list?category=all">전체</a></li>
							<li <c:if test="${category=='member'}">class="active"</c:if>><a href="<%=pageContext.getServletContext().getContextPath()%>/boardfaq/list?category=member" >회원정보</a></li>
							<li <c:if test="${category=='product'}">class="active"</c:if>><a href="<%=pageContext.getServletContext().getContextPath()%>/boardfaq/list?category=product" >제품문의</a></li>
							<li <c:if test="${category=='site'}">class="active"</c:if>><a href="<%=pageContext.getServletContext().getContextPath()%>/boardfaq/list?category=site">사이트 이용</a></li>
							<li <c:if test="${category=='etc'}">class="active"</c:if>><a href="<%=pageContext.getServletContext().getContextPath()%>/boardfaq/list?category=etc" >기타</a></li>
						</ul>
						
						<ul class="faq_list">
							<c:if test="${list != null}">
								<c:forEach var="boardFaq" items="${list}">
								<li>
									<a href="#">${boardFaq.fbtitle}</a>
									<div>
										<span>A.</span>
										${boardFaq.fbcontent}
									</div>
								</li>
								</c:forEach>
							</c:if>
						</ul>
					</div>
					
					<div class="paginate01">
						<div>
							<c:if test="${pageNum > 1}" >
								<a class="direction prevp" href="list?pageNum=1&category=${category}">처음</a>	
            					<c:if test="${groupNo>1}">
	           					<a class="prev" href="list?pageNum=${startPageNo-1}&category=${category}">[이전]</a>
	           					</c:if>
							</c:if>
							
<!-- 							<a href="#" class="active">1</a> -->
							<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}" >
								 <a
								 <c:if test="${pageNum==i}"> class="active"</c:if>
								 	href="list?pageNum=${i}&category=${category}">${i}</a>
							</c:forEach>
							
							<c:if test="${pageNum != endPageNo}" >
							<c:if test="${endPageNo > 1}" >
            					<c:if test="${groupNo>1}">
	            				<a class="next" href="list?pageNum=${endPageNo+1}&category=${category}">[다음]</a>
	            				</c:if>
								<a class="direction nextn" href="list?pageNum=${totalPageNo}&category=${category}">끝</a>
							</c:if>
							</c:if>
						</div>
					</div>
					
					<!-- 
						<div class="paginate01">
							<a class="direction prevp" href="/?cont=c05">처음</a>			
							
							<a href="#" class="active">1</a>
							
							<a href="JavaScript:goList('noticeForm', '/?cont=c05', 2)">2</a>
							
							<a class="direction nextn" href="/?cont=c05&pageNum=2">끝</a>
						</div>
					 -->
				</div>
			</div>
	
</BODY>
<!-- body 종료 -->
</HTML>
