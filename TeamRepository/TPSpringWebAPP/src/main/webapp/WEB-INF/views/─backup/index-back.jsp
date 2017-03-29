<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- head 시작 -->
<head>
	<title>Spectro Team Project</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">   
	
	<!-- ★추가 / 시작 -->
	<meta http-equiv="X-UA-Compatible" content="IE=Edge" />   
	<!-- ★추가 / 종료 -->
	
	<link href="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	   
   <!-- ★추가 CSS 넣는곳 곳 / 시작 -->
   
   <!-- ★추가 / 시작 -->
   <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
   <link href="<%=pageContext.getServletContext().getContextPath()%>/resources/css/style.css" rel="stylesheet"/>
   <!-- ★추가 / 종료 -->
   
   <style type="text/css">
      
      #wrap { position:fixed; top:0px; left:0px; width:100%; height:100%; 
            min-width: 1400px; min-height: 780px; 
            background-image: url("<%=pageContext.getServletContext().getContextPath()%>/resources/image/bg_morning.jpg");
            background-size: cover; transition: all 2s;
      }
      
      header{width:100%; overflow:hidden;}
      header>h1{float:left; margin:20px; width:90px; height:80px;  top:30px; left:60px;
             background-image: url("<%=pageContext.getServletContext().getContextPath()%>/resources/image/logo_b.png"); 
             background-size: contain; background-repeat: no-repeat;}
      
      
      /* 주메뉴 */
      
      #gnb {margin:27px 80px 30px 0;  float:right; overflow:hidden;}
      #gnb li { float: left; margin-right: 30px; }

      #gnb li a { font-size: 14px; font-weight: bold; color: #555; }
      
      /* 텍스트 박스*/
      article { position: absolute; top: 300px; left: 150px; width: 500px;}
      article p { font-size: 50px; color: #666; }
      article p strong {color: #111; }
      article em {font-size: 15px; font-style: italic; color: #333;}
      
      /* 푸터 */
      footer { position: absolute; bottom: 20px; width: 100%; height: 20px; color: white;}
      
      /* 모바일 영역 */
      figure { position: absolute; top: 200px; right: -300px; width: 1200px; height: 800px; 
             background-image: url("<%=pageContext.getServletContext().getContextPath()%>/resources/image/phone_morning.png"); transition: all 2s;
      }
      
      figure p { position: absolute; top: 70px; left: 100px; width: 540px; height: 300px;
               overflow: hidden; font-size: 20px; font-weight: bold; color: #333; line-height: 4.6;
               box-sizing: border-box; padding-left: 40px; 
      }
      
      figure span { position: relative; z-index: 5;}
      
      
   
   </style>
   <!-- ★추가 CSS 넣는 곳 / 종료 -->   
   <!-- ★추가 자바 스크립트 넣는 곳 / 시작 -->
   <script type="text/javascript">
      /* 모달  */
      $(document).ready(function(){
          $("#myBtn").click(function(){
              $("#myModal").modal();
          });
      });
   $(document).ready(function(){           

      /* 1초 마다 현재 시간값 재설정 */
      var timer = setInterval(function(){  // 변수 timer에 setInterval 구문을 실행
         
         var now = new Date();
         var hr = now.getHours();
         var min = now.getMinutes();
         var sec = now.getSeconds();   
         
         // 시간이 한자리 숫자일때 앞에 0 붙이기
         if(hr >=10){   
            hNum = hr;         
         }else{
            hNum = "0"+hr;
         };
         
         // 분이 한자리 숫자일때 앞에 0 붙이기
         if(min >=10){
            mNum = min;
         }else{
            mNum = "0"+min;
         };
         
         // 초가 한자리 숫자일때 앞에 0 붙이기
         if(sec >=10){
            sNum = sec;
         }else{
            sNum = "0"+sec;
         };
               
         // p 태그 안에 시간 출력      
         $("p span").eq(0).text(hNum);
         $("p span").eq(1).text(mNum);
         $("p span").eq(2).text(sNum);      
         
      },1000)  //1초의 시간마다 안쪽의 구문을 반복 실행
      
      
        var now = new Date();
        var hr = now.getHours();

   });
      
   </script>
   
   
   <script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/jquery-2.1.1.min.js"></script>
   <script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/prefixfree.min.js"></script>
   <script type="text/javascript" src="<%=pageContext.getServletContext().getContextPath()%>/resources/js/custom.js"></script>
   
   <!-- ★추가 자바 스크립트 넣는 곳 / 종료 -->   
</head>
<!-- head 종료 -->
<!-- body 시작 -->
<body style="background-image: url(<%=pageContext.getServletContext().getContextPath()%>/resources/image/pattern.jpg)" >
<!-- 전체프레임 시작 -->
   <div id="wrap">
      <header>
         <!-- 로고 시작 -->
         <h1></h1>
         <!-- 로고 종료 -->
         
         <!-- 주 메뉴 시작 -->
         <ul id="gnb">
            <li><a href="#">Home</a></li>
            <c:if test="${login == null}">
               <li><a id="myBtn" data-toggle="modal" href="#myModal">login</a></li>
            </c:if>
            <c:if test="${login != null}">
               <li><a href="${pageContext.servletContext.contextPath}/member/logout">logout</a></li>
            </c:if>
            <c:if test="${login != null}">
               <li><a href="${pageContext.servletContext.contextPath}/member/info">memberInfo</a></li>
            </c:if>
            <li><a href="${pageContext.servletContext.contextPath}/boardnotice/list">Boardnotice</a></li>
            <c:if test="${login != null}">
               <li><a href="${pageContext.servletContext.contextPath}/room/roomList">roomList</a></li>
            </c:if>
            
         </ul>
      </header>
      <!-- 주 메뉴 종료 -->
      <!-- 텍스트 박스 시작 -->
      <article>
         <p><strong>Home Security</strong> TPSWA</p>
         <em>Home Security Team project Spring WebApp</em>
      </article>
      <!-- 텍스트 박스 종료 -->
      
      <!-- 모바일 프레임 시작 -->
      <figure>
         <p>
         <!-- 시계 시작 -->
         <span>00</span> : <span>00</span> : <span>00</span>
         <!-- 시계 종료 -->
         </p>
      </figure>
      <!-- 모바일 프레임 종료 -->
      
      <!-- 푸터 시작 -->
      <footer>
         <p align="center">Home Security &nbsp;TPSWA 2016 Company, Inc.&copy; &nbsp;&nbsp;&nbsp;한국소프트웨어산업협회 &nbsp;서울특별시 송파구 가락동 IT 벤처 타워 12층 </p>
      </footer>
      <!-- 푸터 종료 -->
      
   </div>
   
   <!-- 전체프레임 종료 -->
   
   <!-- 모달  -->
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
      aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-sm">
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal"
                  aria-label="Close">
                  <span aria-hidden="true">×</span>
               </button>
               <h4 class="modal-title" id="myModalLabel">로그인</h4>
            </div>
            <div class="modal-body">
               <form role="form" method="post" action="${pageContext.servletContext.contextPath}/member/login">
                  <fieldset>
                     <div class="form-group">
                        <label for="user_id">아이디</label>
                        <input type="text" id="user_id" name="mid" class="form-control" placeholder="아이디를 입력하세요.">                     
                     </div>
                     
                     <div class="form-group">
                        <label for="user_pw">비밀번호</label>
                        <input type="text" id="user_pw" name="mpassword" class="form-control" placeholder="비밀번호를 입력하세요.">                     
                     </div>
                     <c:if test="${err == 'LOGIN_FAIL_MID'}">
                        <span class="help-block">아이디를 잘 못 입력하셨습니다.</span>
                     </c:if>
                     <c:if test="${err == 'LOGIN_FAIL_MPASSWORD'}">
                        <span class="help-block">비밀번호를 잘못 입력하셨습니다.</span>
                     </c:if>
                     
                     <button type="submit" class="btn btn-primary">
                         로그인
                     </button>
                     <button type="button" class="btn btn-warning" data-dismiss="modal">
                         취소
                     </button>
                  </fieldset>
               </form>
            </div>
            <!-- <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               <button type="button" class="btn btn-primary">Save changes</button>
            </div> -->
         </div>
      </div>
   </div>



</body>
<!-- body 종료 -->
</html>