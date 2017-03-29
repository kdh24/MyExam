<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<NAV class="gnb" style="background-image: url('<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/menu_bg.gif')">
	<%-- gnb 로그인 시작 --%>
	<DIV class="gnb_my_info" style="background-color:white;">
		<!-- 로그인 전 개인정보 -->
		<DIV id="loginDiv" class="login_form" <c:if test="${login != null}">style="display:none;"</c:if>>
			<FORM name="loginForm" method="post">
				<button id="btnLogin" type="button" class="login_btn" onclick="check_login();" style="height: 70px;">로그인</button>
				<INPUT name="userID" id="userID" style="-ms-ime-mode: disabled; height:30px;" onkeyup="imeMode_check(this);" type="text" onkeypress="if (event.keyCode==13){ check_login(); }"> 
				<INPUT name="password" id="userPW" type="password" onkeypress="if (event.keyCode==13){ check_login(); }" placeholder="PW를 입력해주세요" style="height:30px;">
				<LABEL class="auto_login"><INPUT name="saveID" id="saveID" type="checkbox" value="chk" > <SPAN>아이디 저장</SPAN> </LABEL>
				<DIV class="find_id">
					<A href="https://www.capslive.co.kr/?cont=c17"><SPAN>아이디 찾기</SPAN></A> <SPAN>|</SPAN> <A href="https://www.capslive.co.kr/?cont=c18"><SPAN>비밀번호 찾기</SPAN></A>
				</DIV>
			</FORM>
		</DIV>
		
		<DIV id="logoutDiv" class="login_form" <c:if test="${login == null}">style="display:none;"</c:if>>
			<FORM id="logoutForm" name="loginForm">
				<button id="btnLogout" type="button" class="login_btn" style="height: 70px;">로그아웃</button>
				<div> 안녕하세요.</div>
				<div><span id="spanMid" style="color: #3f72c3;">${login}</span> 님</div>
			</FORM>
			
			<%-- 안녕하세요! <br/>
			<span id="spanMid">${login}</span>님이 로그인 되었습니다.<br/>
			<button id="btnLogout" type="button" class="login_btn" style="height: 70px;">로그아웃</button> --%>
		</DIV>
	</DIV>
	
	<!-- gnb 로그인 끝 -->
	<!-- <SCRIPT type="text/javascript"></SCRIPT> -->

	<!-- ★★★★ 메뉴 UI 부분 ★★★★ / start -->
	<UL class="gnb_menu"  style="background-color:white;">
		<!--메뉴명변경 시작-->
		<LI>
			<A class="need_login" href="javascript:alert('로그인이 필요합니다.');" <c:if test="${login != null}">style="display:none;"</c:if>>
				<SPAN>웹뷰어 보기</SPAN>
				<!-- <IMG onclick="alert('로그인이 필요합니다.');" alt="웹뷰어 보기" src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon1.png"> -->
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon1.png">
			</A>
			
			<A href="#" class="logged" <c:if test="${login == null}">style="display:none;"</c:if>>
				<SPAN>웹뷰어 보기</SPAN>
				<!-- <IMG onclick="alert('로그인이 필요합니다.');" alt="웹뷰어 보기" src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon1.png"> -->
				<IMG onclick="fNewWin('<%=pageContext.getServletContext().getContextPath()%>/piview/viewmain','1024','680');" src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon1.png">
			</A>
		</LI>
		<LI>
			<A class="need_login" href="javascript:alert('로그인이 필요합니다.');" <c:if test="${login != null}">style="display:none;"</c:if>>
				<SPAN>서비스 내역</SPAN>
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon2.png">
			</A>
			
			<A href="<%=pageContext.getServletContext().getContextPath()%>/detail" class="logged" <c:if test="${login == null}">style="display:none;"</c:if>>
				<SPAN>서비스 내역</SPAN>
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon2.png">
			</A>						
			
		</LI>
		<LI>
			<A class="need_login" href="javascript:alert('로그인이 필요합니다.');" <c:if test="${login != null}">style="display:none;"</c:if>>
				<SPAN>유저 매뉴얼</SPAN>
				<IMG alt="사용자 매뉴얼" src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon3.png">
			</A>
			
			<A href="<%=pageContext.getServletContext().getContextPath()%>/manual" class="logged" <c:if test="${login == null}">style="display:none;"</c:if>>
				<SPAN>유저 매뉴얼</SPAN>
				<IMG alt="사용자 매뉴얼" src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon3.png">
			</A>
		</LI>
		<LI>
			<A href="<%=pageContext.getServletContext().getContextPath()%>/boardnotice/list">
			<SPAN>공지사항</SPAN>
			<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon4.png">
			</A>
		</LI>
		<LI>
			
			<A class="need_login" href="javascript:alert('로그인이 필요합니다.');" <c:if test="${login != null}">style="display:none;"</c:if>>
				<SPAN>A/S 문의</SPAN>
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon5.png">
			</A>
		
			<A class="logged" href="<%=pageContext.getServletContext().getContextPath()%>/boardas/list" <c:if test="${login == null}">style="display:none;"</c:if>>
				<SPAN>A/S 문의</SPAN>
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon5.png">
			</A>
		</LI>
		<LI>
			<A class="need_login" href="javascript:alert('로그인이 필요합니다.');" <c:if test="${login != null}">style="display:none;"</c:if>>
				<SPAN>FAQ</SPAN>
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon6.png">
			</A>
			
			<A class="logged" href="<%=pageContext.getServletContext().getContextPath()%>/boardfaq/list" <c:if test="${login == null}">style="display:none;"</c:if>>
				<SPAN>FAQ</SPAN>
				<IMG src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon6.png">
			</A>
			
		</LI>
		<LI class="gnb_border_bottom">
			<A href="#" onclick="fNewWin('<%=pageContext.getServletContext().getContextPath()%>/demo','592','404');">
			<SPAN>데모보기</SPAN><IMG alt="데모 보기" src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/main/gnb_icon7.png">
			</A>
		</LI>
		<LI class="gnb_policy">
			<A href="<%=pageContext.getServletContext().getContextPath()%>/agreement">
			<P class="gnb_terms">
			<SPAN>이용약관</SPAN>
			</P>
			</A>
		</LI>
		<LI class="gnb_policy">
			<A href="<%=pageContext.getServletContext().getContextPath()%>/privacy">
			<P class="gnb_pp">
			<SPAN>개인정보취급(처리)방침</SPAN>
			</P>
			</A>
		</LI>
	</UL>
	<!-- ★★★★ 메뉴 UI 부분 ★★★★ / end -->
	<DIV class="gnb_menu" style="height:10px; background-image: url('<%=pageContext.getServletContext().getContextPath()%>/resources/capsimages/menu_bg_line.gif')">
	</DIV>-->
</NAV>