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
					<li>개인정보취급(처리)방침</li>
				</ul>
				<!-- 내용시작 -->
				<div class="content_inner" style="width: 845px; ">
					<!--2015.08.24 텍스트변경-->
				<h2>개인정보취급(처리)방침</h2>
				
					<!--개인정보 취급방침 내용시작-->
					<div class="terms_scrollbox" style="width: 685px; height: 425px;  ">
						주식회사 에이디티캡스(이하 “Spectro”라고 한다)는 고객의 개인정보를 철저히 보호하고 있으며, "개인정보 보호법"과 "정보통신망 이용촉진 및 정보보호에 관한 법률"(이하 “정보통신망법”)을 성실히 준수하고 있습니다. Spectro는 개인정보 보호법 제30조 및 정보통신망법 제27조의2에 따라 개인정보 취급(처리)방침을 통하여 고객께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며, 개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.<br><br>
							<strong>제 1 조 (수집하는 개인정보 항목 및 수집방법)</strong>
							Spectro가 처리하는 개인정보의 항목과 수집방법은 다음과 같습니다.<br>
							<table class="tb5_style">
								<colgroup>
					<col style="width:165px;"><col style="width:415px;"><col style="width:135px;">
					</colgroup>
						<thead>
							<tr>
								<th>분류</th>
								<th>개인정보 항목</th>
								<th>수집방법</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>개인 고객<br>(개인사업자 포함)</td>
								<td>[필수적 정보]<br>이름, 계좌번호 또는 카드정보, 국적, 자택 주소,휴대전화번호, 이메일, 신용거래정보,신용등급 및 평점정보<br>[선택적 정보]<br>직업, 회사명, 부서, 직책, 회사전화번호 </td>
								<td>홈페이지,<br>전자우편, 서면,<br>전화</td>
							</tr>
							<tr>
								<td>법인 고객</td>
								<td>법인담당자정보(성명, 휴대전화번호, 이메일, 직장정보<br>(회사명, 부서, 직책, 전화번호, 주소)) </td>
								<td>홈페이지,<br>전자우편, 서면,<br>전화</td>
							</tr>
							<tr>
								<td>개인고객 및<br>법인고객의 추가출입자</td>
								<td>성명, 휴대전화번호, 출입기록 </td>
								<td>홈페이지,<br>전자우편, 서면,<br>전화</td>
							</tr>
						</tbody>
					</table>
					<strong>제 2 조 (개인정보의 수집 및 이용목적)</strong>
					Spectro는 수집한 개인정보를 다음 각 호의 이용 목적을 위해 활용합니다.<br>
					1. 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산: 상품 및 서비스 거래관계의 설정 또는 유지 여부 판단, 신용정보의 조회, 콘텐츠 제공 등<br>
					2. 고객관리 : 서비스 이용에 이용에 따른 본인확인 , 개인 식별 , 불량고객의 부정 이용 방지와 비인가 사용 방지 , 분쟁의 해결 , 불만처리 등 민원처리 , 경품지급 , 사은행사 , 고객 만족도 조사 , 여론조사 등<br>
					3. 마케팅 및 광고에 활용 : 이벤트 등 홍보성 정보 전달 및 재가입 권유 등<br>
					4. 법령상 의무이행을 위하여 필요한 경우<br>
					5. 그 밖에 개인정보 수집 시 동의를 받은 목적<br><br>
					<strong>제 3 조 (개인정보의 보유 및 이용기간)</strong>
					Spectro는 개인정보의 수집,이용에 관한 동의일로부터 위 이용목적을 달성할 때까지 고객의 개인정보를 보유, 이용합니다.<br><br>
					<strong>제 4 조 (개인정보의 안전성 확보조치)</strong>
					Spectro 는 다음 각 호와 같이 안전성 확보에 필요한 기술적, 관리적, 물리적 조치를 취하고 있습니다 .<br>
					1. 개인정보의 안전한 처리를 위한 내부관리계획의 수립,시행<br>
					2. 개인정보에 대한 접근 통제 및 접근 권한의 제한<br>
					3. 개인정보를 안전하게 저장·전송할 수 있는 암호화 기술의 적용 또는 이에 상응하는 조치<br>
					4. 개인정보 침해사고 발생에 대응하기 위한 접속기록의 보관 및 위조·변조 방지를 위한 조치<br>
					5. 개인정보에 대한 보안프로그램의 설치 및 갱신<br>
					6. 개인정보의 안전한 보관을 위한 보관시설의 마련 또는 잠금 장치의 설치 등 물리적 조치<br>
					7. 개인정보보호 관련 임직원 교육<br>
					8. 기타 개인정보보호를 위하여 필요한 사항<br><br>
					<strong>제 5 조 (개인정보의 제3자 제공)</strong>
					① Spectro 는 원칙적으로 고객의 개인정보를 제 2조에서 명시한 목적 범위 내에서 처리하며 , 고객의 사전 동의 없이는 본래의 범위를 초과하여 처리하거나 제 3자에게 제공하지 않습니다 . 단, 다음의 각 호의 경우에는 고객 또는 제 3자의 이익을 부당하게 침해할 우려가 있을 때를 제외하고는 개인정보를 목적 외의 용도로 이용하거나 이를 제 3자에게 제공할 수 있습니다.<br>
					1. 고객이 사전에 제 3자 제공 및 공개에 동의한 경우<br>
					2. 다른 법률에 특별한 규정이 있는 경우<br>
					3. 고객 또는 그 법정대리인이 의사표시를 할 수 없는 상태에 있거나 주소불명 등으로 사전 동의를 받을 수 없는 경우로서 명백히 고객 또는 제 3자의 급박한 생명 , 신체 , 재산의 이익을 위하여 필요하다고 인정되는 경우<br>
					4. 통계작성 및 학술연구 등의 목적을 위하여 필요한 경우로서 특정 개인을 알아볼 수 없는 형태로 개인정보를 제공하는 경우<br>
					② Spectro 는 제 1항 제 1호에 따른 동의를 받을 때에는 다음 각 호의 사항을 고객 에게 알립니다 . 다음 각 호의 어느 하나의 사항을 변경하는 경우에도 이를 고객 에게 알리고 동의를 받습니다.<br>
					1. 개인정보를 제공받는 자<br>
					2. 개인정보의 이용 목적 (제공 시에는 제공받는 자의 이용 목적을 말한다 )<br>
					3. 이용 또는 제공하는 개인정보의 항목<br>
					4. 개인정보의 보유 및 이용 기간 (제공 시에는 제공받는 자의 보유 및 이용 기간을 말한다 )<br>
					5. 동의를 거부할 권리가 있다는 사실 및 동의 거부에 따른 불이익이 있는 경우에는 그 불이익의 내용 <br><br>
					<strong>제 6 조 (수집한 개인정보의 위탁)</strong>
					① Spectro 는 다음과 같이 개인정보 취급 업무를 위탁하고 있습니다. 향후 수탁업체 및 위탁하는 업무의 내용이 변경될 경우 지체 없이 본 방침을 통해 고지하겠습니다.<br>
					<table class="tb5_style">
						<colgroup>
					<col style="width:200px;"><col style="width:480px;">
					</colgroup>
						<thead>
							<tr>
								<th>수탁업체</th>
								<th>위탁하는 업무의 내용</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>(주)효성ITX</td>
								<td>고객상담 및 각종 서비스관련 안내전화</td>
							</tr>
							<tr>
								<td>(주)엘지유플러스</td>
								<td>서비스관련 SMS문자발송</td>
							</tr>
							<tr>
								<td>노틸러스효성(주)</td>
								<td>전자세금계산서 발행</td>
							</tr>
							<tr>
								<td>NICE평가정보</td>
								<td>본인인증(휴대폰,아이핀), 신용정보조회, 채무불이행관리 </td>
							</tr>
							<tr>
								<td>엠지신용정보(주)</td>
								<td>채권추심</td>
							</tr>
							<tr>
								<td>효성에프엠에스(주)</td>
								<td>즉시인출</td>
							</tr>
							<tr>
								<td>금융결재원</td>
								<td>자동이체 송수신</td>
							</tr>
							<tr>
								<td>인터파크비즈넷</td>
								<td>고객 선물 발송</td>
							</tr>
							<tr>
								<td>LIG손해보험(주)</td>
								<td>보험가입 및 보험금 지급</td>
							</tr>
							<tr>
								<td>메리츠화재해상보험</td>
								<td>보험가입 및 보험금 지급</td>
							</tr>
							<tr>
								<td>에이스아메리칸화재해상보험</td>
								<td>보험가입 및 보험금 지급</td>
							</tr>
						</tbody>
					</table>
					② Spectro는 수탁업체와의 위탁계약 체결 시 관련 법령에 따라 위탁업무 수행목적 외 개인정보 처리금지 , 기술적,관리적,물리적 보호조치 , 위탁업무의 목적 및 범위 , 재위탁 제한 , 개인정보에 대한 접근제한 등 안전성 확보 조치에 관한 사항 , 위탁업무와 관련하여 보유하고 있는 개인정보의 관리 현황 점검 등 감독에 관한 사항 , 수탁자가 준수하여야 할 의무를 위반한 경우의 손해배상 등 책임에 관한 사항을 계약서 등 문서에 명시하고 , 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다.<br><br>
					<strong>제 7 조 (개인정보의 파기)</strong>
					① Spectro는 개인정보 수집 및 이용목적이 달성된 후에는 해당 정보를 지체 없이 파기합니다. 단, 분쟁 해결 , 민원처리 , 법령상 의무이행 및 리스크 관리업무 등을 위하여 개인정보의 보존이 필요한 경우에는 다른 정보주체의 개인정보와 분리하여 별도로 저장 및 관리 할 수 있습니다 .<br>② Spectro는 개인정보가 기록된 출력물 , 서면 등은 파쇄 또는 소각의 방법으로 파기하고 , 전자적 파일형태의 개인정보는 복원이 불가능한 방법으로 영구 삭제하는 방법으로 파기합니다.<br><br>
					<strong>제 8 조 (고객의 권리와 그 행사방법)</strong>
					① 고객은 Spectro가 처리하는 자신 및 14 세 미만 아동 (법정대리인만 해당 )의 개인정보의 열람을 요구할 수 있습니다 .<br>② 자신의 개인정보를 열람한 고객은 사실과 다르거나 확인할 수 없는 개인정보에 대하여 Spectro에 정정 또는 삭제를 요구할 수 있습니다 . 다만 , 다른 법령에서 그 개인정보가 수집 대상으로 명시되어 있는 경우에는 그 삭제를 요구할 수 없습니다 .<br>③ 고객은 Spectro에 대하여 자신의 개인정보 처리의 정지를 요구할 수 있습니다 . 다만 , 다음 각 호의 어느 하나에 해당하는 경우에는 Spectro는 해당 사유를 고객에게 알리고 , 처리정지 요구를 거절할 수 있습니다 .<br>1. 법률에 특별한 규정이 있거나 법령상 의무를 준수하기 위하여 불가피한 경우<br>2. 다른 사람의 생명, 신체를 해할 우려가 있거나 다른 사람의 재산과 그 밖의 이익을 부당하게 침해할 우려가 있는 경우<br>3. 개인정보를 처리하지 아니하면 고객과 약정한 서비스를 제공하지 못하는 등 계약의 이행이 곤란한 경우로서 고객이 그 계약의 해지 의사를 명확하게 밝히지 아니한 경우<br><br>
					<strong>제 9 조 (인터넷 접속정보파일 등 개인정보를 자동으로 수집하는 장치의 설치,운영 및 그 거부에 관한 사항)</strong>
					Spectro는 고객의 정보를 수시로 저장하고 찾아내는 ‘쿠키(cookie)’ 등 개인정보를 자동으로 수집하는 장치를 설치,운용하고 있지 않습니다<br><br>
					<strong>제 10 조 (개인정보 관리(보호)책임자)</strong>
					① Spectro는 고객의 개인정보를 보호하고 개인정보와 관련한 불만을 처리하기 위하여 다음과 같이 관련 부서 및 개인정보 관리 (보호)책임자를 지정하고 있습니다.<br>
					<div style="border:solid 1px #ccc; padding:10px 0 10px 20px; margin:10px 0;">
					<strong>개인정보 관리(보호) 책임자</strong>
					성명 : 김정국 부사장<br>
					전화번호 : 02)3485-9064<br>
					이메일 : privacy@adt.co.kr
					</div>
					② 기타 개인정보 침해에 대한 신고나 상담이 필요하신 경우에는 다음 각 호의 기관에 문의하시기 바랍니다 .<br>
					1. 개인정보분쟁조정위원회 : (02)405-5150<br>
					2. 개인정보 침해신고센터 : ( 국번없이 ) 118<br>
					3. 검찰청 대표전화 : (국번없이 )1301 (휴대전화 : 지역번호 +1301) <br>
					4. 경찰청 민원전화 : ( 국번없이 ) 182 <br><br>
					<strong>제 11 조 (개인정보 취급방침의 변경)</strong>
					Spectro는 개인정보 취급 (처리 )방침을 변경하는 경우에 변경 및 시행의 시기 , 변경된 내용을 지속적으로 공개하며 , 변경된 내용은 고객이 쉽게 확인할 수 있도록 변경 전,후를 비교하여 공개합니다 .<br>
					개인정보취급방침 버전번호 : v2.0 <br>
					<table class="tb5_style">
						<colgroup>
					<col style="width:235px;"><col style="width:235px;"><col style="width:200px;">
					</colgroup>
								<thead>
									<tr>
										<th>재개정일</th>
										<th>공개일</th>
										<th>버전</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>2006.11.</td>
										<td>2006.11.</td>
										<td>1.0</td>
									</tr>
									<tr>
										<td>2015.02.</td>
										<td>2015.02.</td>
										<td>2.0</td>
									</tr>
								</tbody>
							</table>
					</div>
					<!--개인정보 취급방침 내용끝-->
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
