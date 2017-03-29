<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<DIV class="header">
	<H1 class="header_logo">
		<A href="<%=pageContext.getServletContext().getContextPath()%>/">Spectro 웹관제 서비스</A>
	</H1>
	<SPAN class="header_txt">고객센터 1588-6400</SPAN>
	<DIV class="link_wrap">
		<!--<div class="link_wrap">-->
		<A href="javascript:book_mark();"><SPAN>서비스 즐겨찾기 추가</SPAN></A><A onclick="fNewWin('http://www.as82.kr/caps/','1024','768');">원격접속</A>
	</DIV>
</DIV>