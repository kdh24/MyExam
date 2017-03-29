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
	
	<%-- ================ 차트 관련 CSS&JS / 시작 ================ --%>
	
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<%-- ================ 차트 관련 CSS&JS / 끝 ================ --%>
	
	<%-- 사용자 함수 모음--%>
	<SCRIPT src="<%=pageContext.getServletContext().getContextPath()%>/resources/capsjs/adt_func.js" type="text/javascript"></SCRIPT>
	<%-- ================ CAPS 관련 CSS&JS / 종료 ================ --%>
	<%-- ================ ★추가 CSS 넣는곳 곳 / 시작 ================ --%> 
	
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
	        text-align: left;
		    padding: 17px 0 13px 18px;
		    border-bottom: 1px solid #ccc;
		    color: #62666a;
		    font-size: 15px;
		    font-weight: normal;
		}
		
		.tb2_style td{
			padding: 17px 0 13px 18px;
		    font-size: 15px;
		    font-weight: normal;
		}
		
		.content_area{
			min-width: 0;
			position: absolute;
	    	top: 0;
	    	left: 0;
		}
		
		.content_in {
			width:800px;
/* 			margin: auto; */
			margin-top: 70px;
		}
		
		.content_in h2 {
			font-size:24px;
			height:30px;
			line-height:30px;
			margin-bottom:8px;
		}
		
		.pieChart{
			display: inline-block;
		}
		
		#columnChart {
			height: 300px;
			min-width: 310px;
			max-width: 800px;
		}	
		
		.chart{
			margin: 20px 0;
		}
		
		.highcharts-credits{
			display: none;
		}
		
		.tb2_style>thead>tr>th{text-align:center;}
		.roomContract h3, div{text-align:center;}
		.roomContract{border:1px solid blue; padding-left:100px; position:relative}
		.roomContract h3{width:70px; height:125px; position:absolute; left:10px; top:30px; font-size:35px; }
		.roomContract div{width:330px; font-size:30px;}
		
		#contract{overflow:hidden; width:325px; margin-top:-15px;}
		#contract>li{float:left; width:55px; margin:5px; text-align:center;}
		#contract>li>span{height:40px; display:block;}
		#contract>li>span>b{font-size:32px;}
		
	</style>
	<%-- ================ ★추가 CSS 넣는곳 곳 / 종료 ================ --%>
	<%-- ================ ★추가 자바 스크립트 넣는 곳 / 시작 ================ --%>	
	<script type="text/javascript">
	
		
		$(function(){
			
			<%-- 라인 차트 --%>
			var dlist1 = new Array();				// 날짜를 받을 1차원 배열
			
			var list_t = new Array();
			var list_h = new Array(); 
			
			var tlist = ${tlist};
			
			$.each(tlist, function(index, value){
				
				list_t.push(value.ttemperature);
				list_h.push(value.thumidity);	
				
				var str = value.tdateString;		// 날짜
			    dlist1.push(str.substring(8));		// "16112317" 형식의 문자열 끝의 2자리만 추출
			});
			
			<%-- 멀티 y축 그래프 --%>
			Highcharts.chart('lineChart', {
		        chart: {
		            zoomType: 'xy'
		        },
		        title: {
		            text: '시간 별 평균 온도, 습도'
		        },
		        subtitle: {
		            text: 'Temperature and Humidity'
		        },
		        xAxis: [{
		            categories: dlist1,
		            crosshair: true
		        }],
		        yAxis: [{ // Primary yAxis
		            labels: {
		                format: '{value}°C',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            },
		            title: {
		                text: 'Temperature',
		                style: {
		                    color: Highcharts.getOptions().colors[1]
		                }
		            }
		        }, { // Secondary yAxis
		            title: {
		                text: 'Humidity',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            labels: {
		                format: '{value}% RH',
		                style: {
		                    color: Highcharts.getOptions().colors[0]
		                }
		            },
		            opposite: true
		        }],
		        tooltip: {
		            shared: true
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'left',
		            x: 120,
		            verticalAlign: 'top',
		            y: 100,
		            floating: true,
		            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
		        },
		        series: [{
		            name: 'Humidity',
		            type: 'spline',
		            yAxis: 1,
		            data: list_h,
		            tooltip: {
		                valueSuffix: '% RH'
		            }

		        }, {
		            name: 'Temperature',
		            type: 'spline',
		            data: list_t,
		            tooltip: {
		                valueSuffix: '°C'
		            }
		        }]
		    });
				
			<%-- <c:forEach items="${tlist}" var="item">	// model로 부턴 받은 list 객체의 길이만큼 반복
			
				var sub_list1 = new Array();			// 2개의 값을 받을 1차원 배열
			    sub_list1[0] = "${item.ttemperature}";	// 온도
			    sub_list1[1] = "${item.thumidity}";	  // 습도
			    
			    var str = "${item.tdateString}";	// 날짜
			    dlist1.push(str.substring(8));		// "16112317" 형식의 문자열 끝의 2자리만 추출
			    list1.push(sub_list1);				// list 배열에 2개의 값을 가진 1차원 배열 sub_list 배열을 입력 -> 2차원 배열이 된다

			</c:forEach> --%>
			    
			<%-- 멀티 칼럼 차트 --%>  
			var dlist2 = new Array();				// 날짜를 받을 1차원 배열
			
			var flist = ${flist};
			var glist = ${glist};
			var vlist = ${vlist};
			
			var column_list_v = new Array();
			var column_list_f = new Array();
			var column_list_g = new Array();
			
			for(var i=0; i<flist.length; i++){
				
				column_list_f.push(flist[i].count);
				column_list_g.push(glist[i].count);
				
				if(vlist[i] == null){
					column_list_v.push(0);
				}else{
					column_list_v.push(vlist[i].count);
				}
				
				var str = flist[i].fday;			// 날짜
			    dlist2.push(str.substring(8));		// "16112317" 형식의 문자열 끝의 2자리만 추출
			}
			
			<%-- 멀티 칼럼 차트 --%>
			var chart = Highcharts.chart('columnChart', {

		        chart: {
		            type: 'column'
		        },

		        title: {
		            text: '시간 별 화재, 가스, 외부인 출입 감지 회수'
		        },

		        subtitle: {
		            text: 'flame, gas, visitor'
		        },

		        legend: {
		            align: 'right',
		            verticalAlign: 'middle',
		            layout: 'vertical'
		        },

		        xAxis: {
		            categories: dlist2,
		            labels: {
		                x: -10
		            }
		        },

		        yAxis: {
		            allowDecimals: false,
		            title: {
		                text: 'Count'
		            }
		        },

		        series: [{
		            name: 'visitor',
		            data: column_list_v
		        }, {
		            name: 'gas',
		            data: column_list_g
		        }, {
		            name: 'flame',
		            data: column_list_f
		        }],

		        responsive: {
		            rules: [{
		                condition: {
		                    maxWidth: 500
		                },
		                chartOptions: {
		                    legend: {
		                        align: 'center',
		                        verticalAlign: 'bottom',
		                        layout: 'horizontal'
		                    },
		                    yAxis: {
		                        labels: {
		                            align: 'left',
		                            x: 0,
		                            y: -5
		                        },
		                        title: {
		                            text: null
		                        }
		                    },
		                    subtitle: {
		                        text: null
		                    },
		                    credits: {
		                        enabled: false
		                    }
		                }
		            }]
		        }
		    });
			
			<%-- 날짜 선택 시 페이지 전환 --%>
			$("#selectDate").on("change", function(){
				
				$("#formDate").submit(function(){
					var selectDate = $("#selectDate").val();
					$("#cday").val() = selectDate.replace(/\-/g,'');
					$("#crid").val() = $("#selectbox option:selected").val();
				});
			})
			
		});
		
		function clickOption() {
			var contextPath = getContextPath();
			var value = $("#selectbox option:selected").val();
			var contract = $("#contract li").text();
	 		console.log(contract);
			console.log(contextPath);
	 		console.log(value);
			
			var contractUl = $("#contract");
			var contractSpan = $("#contract li a");
			var roomContract = $(".roomContract");
			console.log(contractSpan);
			console.log(roomContract);
			
			/* 
			$.ajax({
				url: contextPath + "/contract/select",
				data : {"room" : value},
				method : "post",
				success: function(data) {
					console.log("SUCCESS");
					console.log(data.trim());
					contractUl.html(data.trim());
				}
			}); */
			
			$.ajax({
				url: contextPath + "/contract/value",
				data : {"room" : value},
				method : "post",
				success: function(data) {
					console.log("value ajax");
					console.log(data.text.length);
					var html = "";
// 							html += '<h3>' + data.roomName + '</h3>' ; 
							html += '<div class="alert alert-info">' + data.contract.room + '</div>';
							html += '<ul id="contract">';
							for(var i=0; i<data.text.length; i++){
								html += '<li><strong>' + data.text[i] +'</strong>';
								if(data.contract.temperature[i] == 'true'){
									html += '<span class="label label-success">';
									html += '<b class="glyphicon glyphicon-ok"></b>';
								}else{
									html += '<span class="label label-default">';
								}
								html += '</span></li>';
							}
							html += '</ul>';
						html += '</div>';
						roomContract.html(html);
					
				}
			});
		}
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
					<h2 style="text-align:left; font-size:36px;">계약 정보</h2>
					<form id="write_form" method="post">
						<table class="tb2_style">
							<colgroup>
								<col style="width : 180px">
								<col style="width : 180px">
								<col style="width : 340px">
							</colgroup>
							<thead>
								<tr>
									<th>계약자 정보</th>
									<th>룸 정보</th>
									<th>계약 상세 정보</th>
								</tr>
							</thead>
							
							<tbody>
								<tr>	
									<td>
										<div>
											<c:if test="${member != null}">
												<ul>
													<li>이름 : ${member.mname}</li>
													<li>주소 : ${member.maddress}</li>
													<li>전화번호 : ${member.mtel}</li>
													<li>이메일 : ${member.memail}</li>
												</ul>			
											</c:if>
										</div>
									</td>
									<td>
										<%-- <select name="rooms">
											<c:forEach var="roomList" items="${list}">
												<option value="${roomList.rname}">${roomList.rname}</option>
											</c:forEach>
										</select> --%>
										<div style="width:180px;">
										    <select name="selectbox" size="7"  id="selectbox" style="width:100px; padding-left:5px;">
										    	<c:forEach var="roomList" items="${list}">
										    		<option value="${roomList.rid}" onclick="clickOption()">${roomList.rname}</option>
										        </c:forEach>
										    </select>
										</div>
									</td>
									<td class="roomContract">
<!-- 										<h3>룸<br /> 계약 정보 </h3> -->
										<div class="alert alert-info">${list.get(0).rname}</div>
										<ul id="contract">
											<c:if test="${contract != null}">
												<li><strong>온,습도 </strong>
														<c:if test="${contract.ctemperature == 'true'}">
															<span class="label label-success">
															<b class=" glyphicon glyphicon-ok"></b></span></c:if>
														<c:if test="${contract.ctemperature != 'true'}">
															<span class="label label-default"></span>
														</c:if></li>
												<li><strong>불 </strong>	
														<c:if test="${contract.cfire == 'true'}">
															<span class="label label-success">
															<b class=" glyphicon glyphicon-ok"></b></span></c:if>
														<c:if test="${contract.cfire != 'true'}">
															<span class="label label-default"></span>
														</c:if></li>
												<li><strong>가스</strong>
														<c:if test="${contract.cgas == 'true'}">
															<span class="label label-success">
															<b class=" glyphicon glyphicon-ok"></b></span></c:if>
														<c:if test="${contract.cgas != 'true'}">
															<span class="label label-default"></span>
														</c:if></li>
												<li><strong>카메라</strong>
														<c:if test="${contract.cview == 'true'}">
															<span class="label label-success">
															<b class=" glyphicon glyphicon-ok"></b></span></c:if>
														<c:if test="${contract.cview != 'true'}">
															<span class="label label-default"></span>
														</c:if></li>
												<li><strong>방문자 </strong>
														<c:if test="${contract.cvisitor == 'true'}">
															<span class="label label-success">
															<b class=" glyphicon glyphicon-ok"></b></span></c:if>
														<c:if test="${contract.cvisitor != 'true'}">
															<span class="label label-default"></span>
														</c:if></li>
											</c:if>
										</ul>
									</td>
								</tr>
							</tbody>
							
							<tfoot>
								<tr>
									<td colspan="3">
										<%-- 날짜 선택 버튼 --%>
										<input id="selectDate" type="date" class="form-control" style="width: 170px;" value="">
										<form id = formDate>
											<input type="hidden" id = "crid" name = "crid" value="">
											<input type="hidden" id = "cday" name = "cday" value="">
										</form>						
										<%-- 라인 차트 --%>
										<div id="lineChart" class="chart" style="min-width: 310px; height: 400px;"></div>
													
										<%-- 멀티 컬럼 차트 --%>
										<div id="columnChart" class="chart"></div>			
										
									</td>
								</tr>
							</tfoot>
							
						</table>
					</form>
				</div>
				
			</DIV>
			
			
		</DIV>
	</SECTION>
	
</BODY>
<%-- body 종료 --%>
</HTML>
