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
	
	
	</style>
	<!-- ================ ★추가 CSS 넣는곳 곳 / 종료 ================ -->
	<!-- ================ ★추가 자바 스크립트 넣는 곳 / 시작 ================ -->	
	<script type="text/javascript">
		

	
	
	</script>
	<!-- ================ ★추가 자바 스크립트 넣는 곳 / 종료 ================ -->
</HEAD>
<!-- head 종료 -->
<!-- body 시작 -->
<BODY oncontextmenu="return false">
	<!-- 내용 시작 -->


		<!--content 시작-->
		<!-- <DIV class="content_area" style="width: 990px; height: 600px;"> -->
			<!--2015.08.06 컨텐츠영역스크롤변경요청으로 div 추가 시작-->
			<!-- <div class="content_area_scroll" style="width: 990px; height: 600px;"> -->
			<div class="" style="width: 790px; height: 600px;">
				<ul class="location">
					<li>홈</li>
					<li>이용약관</li>
				</ul>
				<!-- 내용시작 -->
				<div class="content_inner" style="width: 845px; ">
					<!--2015.08.24 텍스트변경-->
					<h2>이용약관</h2>
				
					<!--개인정보 취급방침 내용시작-->
					<div class="terms_scrollbox" style="width: 685px; height: 425px;  ">
						<strong>제1조(목적 등)</strong>① Spectro 뷰가드 웹관제(www.capslive.co.kr) 서비스
						약관(이하 "본 약관"이라 합니다)은 이용자가 주식회사 에이디티캡스(이하 "Spectro캡스"라 합니다)에서 제공하는 인터넷
						관련 서비스(이하 "서비스"라 합니다)를 이용함에 있어 이용자와 Spectro캡스의 권리,의무 및 책임사항을 규정함을 목적으로
						합니다. <br>② 이용자가 되고자 하는 사람이 Spectro캡스가 정한 회원약관에 동의를 확인하는 페이지에서
						"회원약관에 동의"를 선택 한 경우에만 회원가입정보를 입력하는 페이지로 화면이 이동할 수 있으며, "회원약관에 동의"를
						선택 한 후 "다음단계"를 누르면 본 약관에 동의하는 것으로 간주합니다. 본 약관에 정하는 이외의 이용자와 Spectro캡스의
						권리, 의무 및 책임에 관해서는 약관의규제에관한법률, 전기통신사업법 기타 대한민국의 관련 법령과 상관습에 의합니다. <br>
						<br> <strong>제2조(이용자의 정의)</strong>① "이용자"란 Spectro캡스에 접속하여 본 약관에
						따라 Spectro캡스 회원으로 가입하여 Spectro캡스가 제공하는 서비스를 받는 자를 말합니다.<br> <br>
						<strong>제3조(회원 가입)</strong>① 이용자가 되고자 하는 사람은 Spectro캡스가 정한 가입 양식에 따라
						Spectro캡스가 제공하는 각종 서비스를 받기 위한 회원정보를 기입하고 "가입하기" 단추를 누르는 방법으로 회원가입신청 및
						가입이 이루어지며 회원가입 시 Spectro캡스에 회원정보의 제공을 동의한 경우에는 제2항의 회원정보의 공유에도 동의한 것으로
						간주합니다. <br>② Spectro캡스는 제1항과 같이 회원으로 가입할 것을 신청한 자가 다음 각 호에 해당하지
						않는 한 신청한 자를 회원으로 등록합니다.<br>ⅰ) 가입신청자가 본 약관 제6조 제3항에 의하여 이전에
						회원자격을 상실한 적이 있는 경우. 다만 제6조 제3항에 의한 회원자격 상실 후 3년이 경과한 자로서 Spectro캡스의 회원
						재가입 승낙을 얻은 경우에는 예외로 합니다.<br>② Spectro캡스는 제1항과 같이 회원으로 가입할 것을 신청한
						자가 다음 각 호에 해당하지 않는 한 신청한 자를 회원으로 등록합니다.<br>ⅰ) 가입신청자가 본 약관 제6조
						제3항에 의하여 이전에 회원자격을 상실한 적이 있는 경우. 다만 제6조 제3항에 의한 회원자격 상실 후 3년이 경과한
						자로서 Spectro캡스의 회원 재가입 승낙을 얻은 경우에는 예외로 합니다.<br>ⅱ) 등록 내용에 허위, 기재누락,
						오기가 있는 경우 <br>ⅲ) 기타 회원으로 등록하는 것이 Spectro캡스의 기술상 현저히 지장이 있다고 판단되는
						경우 <br>③ 회원가입의 성립시기는 이용자의 입력정보가 Spectro캡스의 데이터베이스에 저장된 시점으로 합니다.<br>④
						회원은 제1항의 회원정보 기재 내용에 변경이 발생한 경우, 즉시 변경사항을 정정하여 기재하여야 합니다.<br>⑤14세
						미만 회원은 가입하실 수 없습니다.<br> <br> <strong>제4조(서비스의
							제공 및 변경)</strong>① Spectro캡스는 이용자에게 아래와 같은 서비스를 제공합니다.<br>ⅰ) Spectro캡스가 자체
						개발하거나 다른 회사와의 협력계약 등을 통해 회원들에게 제공할 일체의 서비스<br>② Spectro캡스는 그 변경될
						서비스의 내용 및 제공일자를 제7조 제2항에서 정한 방법으로 이용자에게 통지하고, 제1항에 정한 서비스를 변경하여
						제공할 수 있습니다.<br> <br> <strong>제5조(서비스의 중단)</strong>① 회사는
						컴퓨터 등 정보통신설비의 보수점검, 교체 및 고장, 통신의 두절 등의 사유가 발생한 경우에는 서비스의 제공을 일시적으로
						중단할 수 있고, 새로운 서비스로의 교체 기타 회사가 적절하다고 판단하는 사유에 기하여 현재 제공되는 서비스를 완전히
						중단할 수 있습니다.<br>② 제1항에 의한 서비스 중단의 경우에는 회사는 제7조 제2항에서 정한 방법으로
						이용자에게 통지합니다. 다만, 회사가 통제할 수 없는 사유로 인한 서비스의 중단(시스템 관리자의 고의, 과실이 없는
						디스크 장애, 시스템 다운 등)으로 인하여 사전 통지가 불가능한 경우에는 그러하지 아니합니다.<br> <br>
						<strong>제6조(이용자 탈퇴 및 자격 상실 등)</strong>① 이용자는 회사에 언제든지 자신의 회원 등록을
						말소해 줄 것(이용자 탈퇴)을 요청할 수 있으며 회사는 위 요청을 받은 즉시 해당 이용자의 회원 등록 말소를 위한
						절차를 밟습니다.<br>② 이용자가 다음 각 호의 사유에 해당하는 경우, 회사는 이용자의 회원자격을 적절한
						방법으로 제한 및 정지, 상실시킬 수 있습니다.<br>ⅰ) 가입 신청 시에 허위 내용을 등록한 경우<br>ⅱ)
						다른 사람의 회사 이용을 방해하거나 그 정보를 도용하는 등 전자거래질서를 위협하는 경우<br>ⅲ) 회사를
						이용하여 법령과 본 약관이 금지하거나 공서양속에 반하는 행위를 하는 경우<br>③ 회사가 이용자의 회원자격을
						상실시키기로 결정한 경우에는 회원등록을 말소합니다. 이 경우 이용자인 회원에게 회원등록 말소 전에 이를 통지하고,
						소명할 기회를 부여합니다.<br> <br> <strong>제7조(이용자에 대한 통지)</strong>①
						회사가 특정 이용자에 대한 통지를 하는 경우 회사가 부여한 메일주소로 할 수 있습니다. <br>② 회사가
						불특정다수 이용자에 대한 통지를 하는 경우 1주일이상 회사 게시판에 게시함으로써 개별 통지에 갈음할 수 있습니다.<br>
						<br> <strong>제8조(이용자의 개인정보보호)</strong>회사는 관련법령이 정하는 바에 따라서
						이용자 등록정보를 포함한 이용자의 개인정보를 보호하기 위하여 노력합니다. 이용자의 개인정보 보호에 관해서는
						신용정보의이용및보호에관한법률 및 관련법규와 회사가 정하는 "개인정보보호정책"에 정한 바에 의합니다.<br> <br>
						<strong>제9조(회사의 의무)</strong>① 회사는 법령과 본 약관이 금지하거나 공서양속에 반하는 행위를 하지
						않으며 본 약관이 정하는 바에 따라 지속적이고, 안정적으로 서비스를 제공하기 위해서 노력합니다.<br>②
						회사는 이용자가 안전하게 인터넷 서비스를 이용할 수 있도록 이용자의 개인정보(신용정보 포함)보호를 위한 보안 시스템을
						구축합니다.<br>③ 회사는 이용자가 원하지 않는 영리목적의 광고성 전자우편을 발송하지 않습니다. 단,
						회원가입 시 캡스 이메일 수신여부와 그룹 이메일 수신여부의 선택에 동의하신 경우는 필요한 정보를 메일로 발송할 수
						있습니다.<br>④ 회사는 이용자가 서비스를 이용함에 있어 회사의 고의 또는 과실로 인하여 입은 손해를 배상할
						책임을 부담합니다.<br> <br> <strong>제10조(이용자의 ID 및
							비밀번호에 대한 의무)</strong>① 회사가 관계법령, "개인정보보호정책"에 의해서 그 책임을 지는 경우를 제외하고, 자신의
						ID와 비밀번호에 관한 관리책임은 각 이용자에게 있습니다.<br> ② 이용자는 자신의 ID 및 비밀번호를
						제3자에게 이용하게 해서는 안됩니다.<br>③ 이용자는 자신의 ID 및 비밀번호를 도용당하거나 제3자가
						사용하고 있음을 인지한 경우에는 바로 회사에 통보하고 회사의 안내가 있는 경우에는 그에 따라야 합니다.<br>
						<br> <strong>제11조(이용자의 의무)</strong>① 이용자는 다음 각 호의 행위를 하여서는
						안됩니다.<br>ⅰ) 회원가입신청 또는 변경시 허위내용을 등록하는 행위<br>ⅱ) 회사에 게시된
						정보를 게시자 또는 회사의 승인 없이 변경하는 행위<br>ⅲ) 회사 기타 제3자의 인격권 또는 지적재산권을
						침해하거나 업무를 방해하는 행위<br> ⅳ) 다른 회원의 ID를 도용하는 행위<br> ⅴ)
						정크메일(junk mail), 스팸메일(spam mail), 행운의 편지(chain letters), 피라미드 조직에
						가입할 것을 권유하는 메일, 외설 또는 폭력적인 메시지·화상·음성 등이 담긴 메일을 보내거나 기타 공서양속에 반하는
						정보를 공개 또는게시하는 행위<br> ⅵ) 관련 법령에 의하여 그 전송 또는 게시가 금지되는 정보(컴퓨터
						프로그램 등)의 전송 또는 게시하는 행위<br>ⅶ) 다음의 직원이나 다음 서비스의 관리자를 가장하거나 사칭하여
						또는 타인의 명의를 모용하여 글을 게시하거나 메일을 발송하는 행위<br>ⅷ) 컴퓨터 소프트웨어, 하드웨어,
						전기통신 장비의 정상적인 가동을 방해, 파괴할 목적으로 고안된 소프트웨어 바이러스, 기타 다른 컴퓨터 코드, 파일,
						프로그램을 포함하고 있는 자료를 게시하거나 전자우편으로 발송하는 행위<br>ⅸ) 스토킹(stalking) 등
						다른 이용자를 괴롭히는 행위<br>ⅹ) 다른 이용자에 대한 개인정보를 그 동의 없이 수집,저장,공개하는 행위<br>11)
						불특정 다수의 자를 대상으로 하여 광고 또는 선전을 게시하거나 스팸메일을 전송하는 등의 방법으로 회사의 서비스를
						이용하여 영리목적의 활동을 하는 행위<br>12) 회사가 제공하는 서비스에 정한 약관 기타 서비스 이용에 관한
						규정을 위반하는 행위<br>② 제1항에 해당하는 행위를 한 이용자가 있을 경우 회사는 본 약관 제6조 제2,
						3항에서 정한 바에 따라 이용자의 회원자격을 적절한 방법으로 제한 및 정지, 상실시킬 수 있습니다.<br>③
						이용자는 그 귀책사유로 인하여 회사가나 다른 이용자가 입은 손해를 배상하여야 합니다.<br> <br>
						<strong>제12조(공개게시물의 삭제)</strong>이용자의 공개게시물의 내용이 다음 각 호에 해당하는 경우
						회사는 이용자에게 사전 통지 없이 해당 공개게시물을 삭제할 수 있고, 해당 이용자의 회원 자격을 제한, 정지 또는
						상실시킬 수 있습니다.<br>ⅰ) 다른 이용자 또는 제3자를 비방하거나 중상 모략으로 명예를 손상시키는 내용<br>ⅱ)
						공서양속에 위반되는 내용의 정보, 문장, 도형 등을 유포하는 내용<br>ⅲ) 범죄행위와 관련이 있다고 판단되는
						내용<br>ⅳ) 다른 이용자 또는 제3자의 저작권 등 기타 권리를 침해하는 내용<br>ⅴ) 이 약관
						및 기타 관계 법령에 위배된다고 판단되는 내용<br> <br> <strong>제13조(저작권의
							귀속 및 이용제한)</strong>① 회사가 작성한 저작물에 대한 저작권 기타 지적재산권은 회사에 귀속합니다.<br>②
						이용자는 회사를 이용함으로써 얻은 정보를 회사의 사전승낙 없이 복제, 전송, 출판, 배포, 방송 기타 방법에 의하여
						영리목적으로 이용하거나 제3자에게 이용하게 하여서는 안됩니다.<br> <br> <strong>제14조(약관의
							개정)</strong>① 회사는 약관의규제등에관한법률, 전자거래기본법, 전자서명법, 정보통신망이용촉진등에관한법률 등 관련법을 위배하지
						않는 범위에서 본 약관을 개정할 수 있습니다.<br>② 회사가 본 약관을 개정할 경우, 약관 개정 이전
						가입회원에 대해서는 변경약관의 적용일 7일 전에 이용자가 가입신청 시 기재한 전자주소로 전자문서에 현행 약관과 변경된
						약관의 적용예정일, 개정사유 등 변경약관의 내용을 기재하여 발송함으로써 약관변경 사실을 고지하고 그에 대한 동의여부를
						확인합니다. 이용자가 전자문서 발송일 이후 7일 이내에 회원탈퇴 등 변경약관에 이의한다는 의사표시를 하지 아니한
						경우에는 변경약관에 동의한 것으로 봅니다.<br> ③ 회사는 전항에 따라 약관변경 사실을 이용자들에게
						전자문서로 고지하는 외에 회사 홈페이지 초기화면에 변경약관의 적용일자, 개정사유 및 변경약관의 내용을 현행약관과 함께
						적용일자 7일전부터 공지합니다.<br>④ 변경된 약관에 이의가 있는 이용자는 제6조 제1항에 따라 탈퇴할 수
						있습니다.<br> <br> <strong>제15조(재판관할)</strong>회사와 이용자간에 발생한
						서비스 이용에 관한 분쟁으로 인한 소송은 민사소송법상의 관할권이 있는 대한민국의 법원에 제기하기로 합니다. <br>
						<br> <strong>부 칙</strong>본 약관은 2011. 11. 1. 부터 적용하고, 종전의 약관은
						본 약관으로 대체합니다.
					</div>
					<!--이용약관 내용끝-->
	
				</div>
				<!-- 내용끝 -->
			</div>
			<!--2015.08.06 컨텐츠영역스크롤변경요청으로 div 추가 끝-->
		</div>
		<!--content  종료 -->

	<!-- 내용 종료 -->	
</body>
<!-- body 종료 -->
</html>
