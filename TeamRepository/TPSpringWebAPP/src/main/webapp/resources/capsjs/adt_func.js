////////////// 지수가 입력한 부분 //////////////////////////////////////
function getContextPath() {
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
};

function check_login(){
	//$("#btnLogin").on("click", function(){
		console.log("click");
		var mid = $("#userID").val();
		var mpassword = $("#userPW").val();
		var contextPath = getContextPath();
		
		$.ajax({
			url : contextPath + "/member/login",
			data : {"mid":mid, "mpassword":mpassword},
			method : "post",
			success : function(data){
				if(data.result == "success"){
					$("#loginDiv").hide();
					$("#logoutDiv").show();
					$("#spanMid").html(data.mid);
					
					$(".logged").show();
					$(".need_login").hide();
					
					$(location).attr('href', getContextPath());
				}else if(data.result == "wrongMid"){
					BootstrapDialog.show({
						title : '안내 메시지',
						message : "아이디가 존재하지 않습니다.",
						size : BootstrapDialog.SIZE_SMALL
					});
				}else{
					BootstrapDialog.show({
						title : '안내 메시지',
						message : "패스워드가 틀립니다.",
						size : BootstrapDialog.SIZE_SMALL
					});
				}
			}
			
		});
	//});
}

$(function(){
	var contextPath = getContextPath();
	$("#btnLogout").on("click", function(){
		$.ajax({
			url : contextPath+"/member/logout",
			success : function(data){
				if(data.result == "success"){
					console.log(data.result);
					$("#loginDiv").show();
					$("#logoutDiv").hide();
					$("#spanMid").html("");		
					
					$(".logged").hide();
					$(".need_login").show();
					
					$("#userID").val("");
					$("#userPW").val("");
					
					$(location).attr('href', getContextPath());
				}
			}
		});
	});
});

///////////////////////////////////////////////////////////////////////////////

/*function check_login()
{
	var f = document.loginForm;
	
	if (f.userID.value == '') {	alert('ID 를 입력하세요.');	f.userID.focus();	return;	}
	else if (f.password.value == '') {	alert('Password 를 입력하세요.'); f.password.focus(); return;}
	else
	{
		if($("#saveID").prop("checked")) {
			$.cookie('userID', $("#userID").val());
		} else {
			$.removeCookie("userID");
		}
		
		f.target	= 'hiddenfrm';
		//f.action	= '/member/login';
	//	f.action	= '/login/login_proc.asp';
		
		f.submit();
	}
}*/


$(document).ready(function() {
	var login_id = $.cookie('userID');

    if(login_id != undefined) 
	{
        $("#userID").val(login_id);
        $("#saveID").prop("checked",true);
    }
});


function noBack()
{
	window.history.forward(); 
}


//a/s문의 입력 체크 변경, 2016.01.14
function check_inqureWrite()
{
	var f = document.inqureWriteForm;
	
	//설치위치 선택 필수로 변경 2016.01.14
	if (typeof(f.dvrnum.length) == "number")
	{
		if($("#a0").is(":checked")){alert('설치위치를 선택 하세요.');$("#a0").focus(); return;}
	}

	if (f.subject.value == '') { alert('제목을 입력하세요.'); f.subject.focus(); return;}
	//문의유형 선택 필수로 변경 2016.01.14
	if($("#q0").is(":checked")){alert('문의유형을 선택 하세요.');$("#q0").focus(); return;}
	else if (f.contents.value == '') { alert('문의사항을 입력하세요.'); f.contents.focus(); return;}
	else
	{
		if (confirm('서비스문의를 등록하시겠습니까?'))
		{
			f.action	= '/process/proc_inquire_insert.asp';
			f.submit();
		}		
	}
}

function check_inqureModify()
{
	var f = document.inqureModifyForm;

	if (f.subject.value == '') { alert('제목을 입력하세요.'); f.subject.focus(); return;}
	else if (f.contents.value == '') { alert('문의사항을 입력하세요.'); f.contents.focus(); return;}
	else
	{
		if (confirm('수정하시겠습니까?'))
		{
			f.action	= '/process/proc_inquire_update.asp';
			f.submit();
		}		
	}
}

function delete_inquire(idx)
{
	if (confirm('삭제하시겠습니까?'))	
		location.href = '/process/proc_inquire_delete.asp?idx=' + idx;	
}

function save_reply(idx)
{
	var f = document.inqureReplyForm;
	if (f.comment.value == '') { alert('댓글내용을 입력하세요.'); f.comment.focus(); return;}	
	else
	{
		f.action	= '/process/proc_inquirereply_insert.asp';
		f.submit();
	}
}

function imeMode_check(obj)
{
	var check = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;	
	if (check.test(obj.value))
	{
		alert('영문으로 입력하세요.'); obj.value = '';	return;
	}
}

//웹뷰어 보기 새창 링크 변경, 특정모델명 유무에 따른 조치. 2015.12.17
function popViewer(vid)
{
	//newWin = window.open('/viewer_v2/?autono=0&vid=' + vid, 'newWin', 'width=1010, height=692, menubar=no, status=no, toolbar=no');	
	newWin = window.open('/viewer_v4/viewer_gateway.asp?vid=' + vid, 'newWin', 'width=976, height=594, menubar=no, status=no, toolbar=no');	
}
function popViewerTest(vid)
{	
	newWin = window.open('/viewer_v2_test/viewer_gateway.asp?vid=' + vid, 'newWin', 'width=1010, height=692, menubar=no, status=no, toolbar=no');	
}

//게시판 페이지 이동 시 GET방식으로 변경, 
//2016.01.12
function goList(formName, pageName, pageNum)
{
	
	//document.getElementById(formName).pageNum.value = pageNum;	
	//document.getElementById(formName).action = pageName;				
	//document.getElementById(formName).submit();
	console.log(location.href);
	location.href = pageName + "?pageNum=" + pageNum;
}

function logout()
{
	//alert("로그아웃");
	if(newWin != null)
	{
		newWin.close();
	}

	location.href = '/login/logout_proc.asp';
}

function logout_admin()
{
	//alert("로그아웃");
	
	location.href = '/login/logout_proc.asp';
}

function book_mark() { 

window.external.AddFavorite('https://www.capslive.co.kr/','ADT 뷰가드 웹뷰어'); 

}

//게시판 리스트의 검색 이벤트 함수
//2016.01.12
function goSearch(url){
		
		var searchVal = encodeURL($("#search").val());
		var strSearchVal = "";

		if(searchVal == $("#search").attr("placeholder") || searchVal == ""){
			strSearchVal = "";
		}else{
			strSearchVal = "&search=" + searchVal;
		}
		
		$(location).attr("href", url + strSearchVal);
}

//URL ENCODE 함수 
//2016.01.12
function encodeURL(str){
 
    var s0, i, s, u;
	s0 = "";                // encoded str
 
    for (i = 0; i < str.length; i++){   // scan the source
	    s = str.charAt(i);
	    u = str.charCodeAt(i);          // get unicode of the char
 
        if (s == " "){s0 += "+";}       // SP should be converted to "+"
	    else {
	        if ( u == 0x2a || u == 0x2d || u == 0x2e || u == 0x5f || ((u >= 0x30) && (u <= 0x39)) || ((u >= 0x41) && (u <= 0x5a)) || ((u >= 0x61) && (u <= 0x7a))){       // check for escape
				s0 = s0 + s;            // don't escape
			}
			else {                  // escape
			    if ((u >= 0x0) && (u <= 0x7f)){     // single byte format
			        s = "0"+u.toString(16);
			        s0 += "%"+ s.substr(s.length-2);
			    }
				else if (u > 0x1fffff){     // quaternary byte format (extended)
				    s0 += "%" + (oxf0 + ((u & 0x1c0000) >> 18)).toString(16);
				    s0 += "%" + (0x80 + ((u & 0x3f000) >> 12)).toString(16);
				    s0 += "%" + (0x80 + ((u & 0xfc0) >> 6)).toString(16);
				    s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
				}
				else if (u > 0x7ff){        // triple byte format
				    s0 += "%" + (0xe0 + ((u & 0xf000) >> 12)).toString(16);
				    s0 += "%" + (0x80 + ((u & 0xfc0) >> 6)).toString(16);
				    s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
				}
				else {                      // double byte format
				    s0 += "%" + (0xc0 + ((u & 0x7c0) >> 6)).toString(16);
				    s0 += "%" + (0x80 + (u & 0x3f)).toString(16);
				}
			}
		}
	}
	return s0;
}
 //URL DECODE 함수
//2016.01.12
function decodeURL(str){
 
    var s0, i, j, s, ss, u, n, f;
	s0 = "";                // decoded str
 
    for (i = 0; i < str.length; i++){   // scan the source str
	    s = str.charAt(i);
	    if (s == "+"){s0 += " ";}       // "+" should be changed to SP
	    else {
	        if (s != "%"){s0 += s;}     // add an unescaped char
	        else{               // escape sequence decoding
	            u = 0;          // unicode of the character
	            f = 1;          // escape flag, zero means end of this sequence
	            while (true) {
	                ss = "";        // local str to parse as int
	                    for (j = 0; j < 2; j++ ) {  // get two maximum hex characters for parse
	                        sss = str.charAt(++i);
	                        if (((sss >= "0") && (sss <= "9")) || ((sss >= "a") && (sss <= "f"))  || ((sss >= "A") && (sss <= "F"))) {
                             ss += sss;      // if hex, add the hex character
                            } else {--i; break;}    // not a hex char., exit the loop
                        }
                    n = parseInt(ss, 16);           // parse the hex str as byte
                    if (n <= 0x7f){u = n; f = 1;}   // single byte format
                    if ((n >= 0xc0) && (n <= 0xdf)){u = n & 0x1f; f = 2;}   // double byte format
                    if ((n >= 0xe0) && (n <= 0xef)){u = n & 0x0f; f = 3;}   // triple byte format
                    if ((n >= 0xf0) && (n <= 0xf7)){u = n & 0x07; f = 4;}   // quaternary byte format (extended)
                    if ((n >= 0x80) && (n <= 0xbf)){u = (u << 6) + (n & 0x3f); --f;}         // not a first, shift and add 6 lower bits
                    if (f <= 1){break;}         // end of the utf byte sequence
                    if (str.charAt(i + 1) == "%"){ i++ ;}                   // test for the next shift byte
                    else {break;}                   // abnormal, format error
                }
            s0 += String.fromCharCode(u);           // add the escaped character
            }
        }
    }
    return s0;
}

function add_shortcut() { 

document.hiddenfrm.location.href='/contents/cont_shortcut.asp';

}