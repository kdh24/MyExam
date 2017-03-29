function fNewWin(url, width, height)  {
	cw=screen.availWidth;
	ch=screen.availHeight; 
	sw=width;
	sh=height;
	ml=(cw-sw)/2;
	mt=(ch-sh)/2;
	newWin = window.open(url,'newWin','width='+sw+',height='+sh+',top='+mt+',left='+ml+',toobar=no,scrollbars=yes,menubar=no,status=no,directories=no,');

}

function fNewWinMain(url, winname, width, height)  {
	cw=screen.availWidth;
	ch=screen.availHeight; 
	sw=width;
	sh=height;
	ml=(cw-sw)/2;
	mt=(ch-sh)/2;
	newWin = window.open(url,winname,'width='+sw+',height='+sh+',top='+mt+',left='+ml+',toobar=no,scrollbars=yes,menubar=no,status=no ,directories=no,');

}

$(document).ready(function(){
	var inTxt = $('.placeholder').find('input');
	
	//기본적으로 value값을 가지고 있을때 
	inTxt.each(function(){
		if($(this).val() != ''){
			$(this).addClass('focus');	
		};
	});
	//포커스가 있을때
	inTxt.on('focusin', function(){
		$(this).addClass('focus');
	});
	//포커스가 사라졌을때
	inTxt.on('focusout', function(){
		if($(this).val() === '') {
			$(this).removeClass('focus');	
		} else {
			$(this).addClass('focus');		
		}
	});
	$('.placeholder').on('click', function(){
		$(this).find('input').focus();
	});


	var areaTxt = $('.placeholder').find('textarea');
	
	//기본적으로 value값을 가지고 있을때 
	areaTxt.each(function(){
		if($(this).val() != ''){
			$(this).addClass('focus');	
		};
	});
	//포커스가 있을때
	areaTxt.on('focusin', function(){
		$(this).addClass('focus');
	});
	//포커스가 사라졌을때
	areaTxt.on('focusout', function(){
		if($(this).val() === '') {
			$(this).removeClass('focus');	
		} else {
			$(this).addClass('focus');		
		}
	});
	$('.placeholder').on('click', function(){
		$(this).find('textarea').focus();
	});
});

//player
$(function(){
	$(window).load(function(e) {
		$(".player_btn").click(function() {
			var maskH = $(document).height();
			var maskW = $(document).width();
			var lyH = $(window).height();
			var lyW = $(window).width();		
			var ly = $(this).attr("alt");		
			$('.content_area').css("overflow","hidden");
			$('#player_mask').css({'width':maskW,'height':maskH});
			$('#player_mask').fadeTo('300',0.5);
			$('.'+ly).css('top', $(window).scrollTop() + lyH/2 - $('.'+ly).height()/2);
			$('.'+ly).css('left',lyW/2-$('.'+ly).width()/2).show();		
			$('#player_mask').click(function () {
				$('.content_area').css("overflow","auto");
				$('#player_mask,.'+ly).hide();		
			});	
			$('.app_close').click(function () {
				$('.content_area').css("overflow","auto");
				$('#player_mask,.'+ly).hide();	
				$(".player_btn").removeClass('active');
			});	
		});
		$(".player_btn").click(function() {
			$(this).addClass('active');
		});
	});	
});

//player
$(function(){
	$(window).load(function(e) {
		$("#member_drop").click(function() {
			var maskH = $(document).height();
			var maskW = $(document).width();
			var lyH = $(window).height();
			var lyW = $(window).width();		
			var ly = $(this).attr("alt");		
			$('.content_area').css("overflow","hidden");
			$('#player_mask').css({'width':maskW,'height':maskH});
			$('#player_mask').fadeTo('300',0.5);
			$('.'+ly).css('top', $(window).scrollTop() + lyH/2 - $('.'+ly).height()/2);
			$('.'+ly).css('left',lyW/2-$('.'+ly).width()/2).show();		
			$('#player_mask').click(function () {
				$('.content_area').css("overflow","auto");
				$('#player_mask,.'+ly).hide();		
			});	
			$('.app_close').click(function () {
				$('.content_area').css("overflow","auto");
				$('#player_mask,.'+ly).hide();	
				$(".player_btn").removeClass('active');
			});	
		});
		$(".player_btn").click(function() {
			$(this).addClass('active');
		});
	});	
});

function fncAdd1(add)
{
    var fm  = document.frm1;
    var num = parseInt(frm1.cnt.value);
    num += add;
    if(num<1) num=1;
    frm1.cnt.value = num;
}
function fncAdd2(add)
{
    var fm  = document.frm2;
    var num = parseInt(frm2.cnt.value);
    num += add;
    if(num<1) num=1;
    frm2.cnt.value = num;
}
function fncAdd3(add)
{
    var fm  = document.frm3;
    var num = parseInt(frm3.cnt.value);
    num += add;
    if(num<2) num=2;
    frm3.cnt.value = num + 'x';
}

//togglecontrol
var activeClass = 'no';
$(document).ready(function(){
	
	$("#togglecontrol .togglecntr").hide(); // 검색
	$("#togglecontrol .togglecntrP").hide(); // ptz 접음

	$("#togglecntr_play").click(function(){
				
		$("#togglecontrol .togglecntr").show();
		$("#togglecontrol .togglecntrP").hide();
		if (activeClass == 'no')
		{
			$(this).toggleClass("active").siblings("strong.active").removeClass("active");
			activeClass = 'yes';
		}		
	});

	$("#togglecntr_ptz").click(function(){
				
		$(this).next().slideToggle("fast").siblings(".togglecntr:visible").slideUp("fast");
		$(this).toggleClass("active").siblings("strong.active").removeClass("active");
		activeClass = 'no';
	});
	
});

//2015.08.28 (bsw updated)
function closeTab(){
	$("#togglecontrol .togglecntr").slideUp();	
	$("#togglecontrol .togglecntr").toggleClass("active").siblings("strong.active").removeClass("active");
	activeClass = 'no';
}

$(document).ready(function(){
	$(".multi_choice ul li input").click(function(){
		if($(this).hasClass('checked')){
			$(this).removeClass('checked');
		}else{
			$(this).addClass('checked');
		}
	});

	$(".ptz_btn p span input").click(function(){
		if($(this).hasClass('checked')){
			$(this).removeClass('checked');
			$(".Preset_pop").hide();
		}else{
			$(this).addClass('checked');
			$(".Preset_pop").show();
		}
	});

	/*
	$(".tb4_style div .radiobtn").click(function(){
		if($(this).children('input').hasClass('checked')){
			$(this).removeClass('checked');
		}else{
			$(this).addClass('checked');
		}
	});
	*/
	/*15.10.22 Reseed Corp Sim Woo Jae*/
	$(".tb4_style .grp_input .radiobtn label").each(function(){
		 $(this).click(function(){
			var label=$(this);
			label.removeClass('checked');
			if(label.find('input').is(':checked')){
				label.addClass('checked');	
			}else{
				$(".tb4_style .grp_input .radiobtn label").removeClass('checked');	
			}
		})        
    });
	$(".tb4_style .grp_input2 .radiobtn label").each(function(){
		 $(this).click(function(){
			var label=$(this);
			label.removeClass('checked');
			if(label.find('input').is(':checked')){
				label.addClass('checked');	
			}else{
				$(".tb4_style .grp_input2 .radiobtn label").removeClass('checked');	
			}
		})        
    });
	$(".tb4_style .grp_input3 .radiobtn label").each(function(){
		 $(this).click(function(){
			var label=$(this);
			label.removeClass('checked');
			if(label.find('input').is(':checked')){
				label.addClass('checked');	
			}else{
				$(".tb4_style .grp_input3 .radiobtn label").removeClass('checked');	
			}
		})        
    });
	$(".tb4_style .grp_input4 .radiobtn label").each(function(){
		 $(this).click(function(){
			var label=$(this);
			label.removeClass('checked');
			if(label.find('input').is(':checked')){
				label.addClass('checked');	
			}else{
				$(".tb4_style .grp_input4 .radiobtn label").removeClass('checked');	
			}
		})        
    });
	$(".tb4_style .grp_input5 .radiobtn label").each(function(){
		 $(this).click(function(){
			var label=$(this);
			label.removeClass('checked');
			if(label.find('input').is(':checked')){
				label.addClass('checked');	
			}else{
				$(".tb4_style .grp_input5 .radiobtn label").removeClass('checked');	
			}
		})        
    });
	$(".tb4_style .grp_input6 .radiobtn label").each(function(){
		 $(this).click(function(){
			var label=$(this);
			label.removeClass('checked');
			if(label.find('input').is(':checked')){
				label.addClass('checked');	
			}else{
				$(".tb4_style .grp_input6 .radiobtn label").removeClass('checked');	
			}
		})        
    });

/*  */
	$(".Preset_pop_inner ul li a").click(function(){
		if($(this).hasClass('active')){
			$(this).removeClass('active');
		}else{
			$(this).addClass('active');
		}
	});


	$(".Preset_pop_close").click(function(){
		$(".Preset_pop").hide();
	});
});


//약관전체동의
function cheakAll() {
	var terms = document.agreementform.terms;
	var allchk = document.agreementform.allchk.checked;
	for(i=0; i<terms.length; i++){
		terms[i].checked = allchk;
	}
}

function cheakAll0() {
	var menu = document.form1.menu;
	var allchk = document.form1.allchk.checked;
	for(i=0; i<menu.length; i++){
		menu[i].checked = allchk;
	}
}


//player select
$(function(){
	var select_root = $('div.select');
	var select_value = $('.my_value');
	var select_a = $('div.select>ul>li>a');
	var select_input = $('div.select>ul>li>input[type=radio]');
	var select_label = $('div.select>ul>li>label');
	
	// Radio Default Value
	$('div.my_value').each(function(){
		var default_value = $(this).next('.i_list').find('input[checked]').next('label').text();
		$(this).append(default_value);
	});
	
	// Line
	select_value.bind('focusin',function(){$(this).addClass('outLine')});
	select_value.bind('focusout',function(){$(this).removeClass('outLine')});
	select_input.bind('focusin',function(){$(this).parents('div.select').children('div.my_value').addClass('outLine')});
	select_input.bind('focusout',function(){$(this).parents('div.select').children('div.my_value').removeClass('outLine')});
	
	// Show
	function show_option(){
		$(this).parents('div.select:first').toggleClass('open');
	}
	
	// Hover
	function i_hover(){
		$(this).parents('ul:first').children('li').removeClass('hover');
		$(this).parents('li:first').toggleClass('hover');
	}
	
	// Hide
	function hide_option(){
		var t = $(this);
		setTimeout(function(){
			t.parents('div.select:first').removeClass('open');
		}, 1);
	}
	
	// Set Input
	function set_label(){
		var v = $(this).next('label').text();
		$(this).parents('ul:first').prev('.my_value').text('').append(v);
		$(this).parents('ul:first').prev('.my_value').addClass('selected');
	
	}
	
	// Set Anchor
	function set_anchor(){
		var v = $(this).text();
		$(this).parents('ul:first').prev('.my_value').text('').append(v);
		$(this).parents('ul:first').prev('.my_value').addClass('selected');

	}

	// Anchor Focus Out
	$('*:not("div.select a")').focus(function(){
		$('.a_list').parent('.select').removeClass('open');
	});
			
	select_value.click(show_option);
	select_root.removeClass('open');
	select_root.mouseleave(function(){$(this).removeClass('open')});
	select_a.click(set_anchor).click(hide_option).focus(i_hover).hover(i_hover);
	select_input.change(set_label).focus(set_label);
	select_label.hover(i_hover).click(hide_option);

});
//gnbSelect
$current=null
function gnbSelect($num){
	if($num>0){
	$('.gnb_menu li').eq(+$num-1).addClass('active');
	 $current=$num-1
	}else {
	return false;
	}
}
/*
if(!wcs_add) var wcs_add = {};
wcs_add["wa"] = "b9406b96909420";
wcs_do();
*/

$(document).ready(function(){
	$('.file_dw').mouseover(function(){
		$(this).addClass('active');
		$(this).next('ul').slideDown(300);
	});
	$('.file_doxline').mouseleave(function(){
		$(this).find('a').removeClass('active');
		$(this).find('ul').hide();
	});
	$('.file_ly').mouseleave(function(){
		$(this).prev().removeClass('active');
		$(this).hide();
	});

	// header 원격접속 마우스 오버시 나오는 메뉴
	$('.remote_connect_list').hover(function(){
			$(this).children('ul').slideDown(300);
		},function(){
			$(this).children('ul').hide();
	});

	// 우편번호검색
	$(".tab_content").hide(); 
	$("ul.tabs li:first").addClass("active").show(); 
	$(".tab_content:first").show(); 
	$("ul.tabs li").click(function() {
		$("ul.tabs li").removeClass("active"); 
		$(this).addClass("active"); 
		$(".tab_content").hide(); 
		var activeTab = $(this).find("a").attr("href");
		$(activeTab).fadeIn(); 
		return false;
	});

	// 아이디비번검색
	$(".idtab_content").hide(); 
	$("ul.idtabs li:first").addClass("active").show(); 
	$(".idtab_content:first").show(); 
	$("ul.idtabs li").click(function() {
		$("ul.idtabs li").removeClass("active"); 
		$(this).addClass("active"); 
		$(".idtab_content").hide(); 
		var activeTab = $(this).find("a").attr("href");
		$(activeTab).fadeIn(); 
		return false;
	});

	// 다른인증수단검색
	$(".ortab_content").hide(); 
	$("ul.ortabs li:first").addClass("active").show(); 
	$(".ortab_content:first").show(); 
	$("ul.ortabs li").click(function() {
		$("ul.ortabs li").removeClass("active"); 
		$(this).addClass("active"); 
		$(".ortab_content").hide(); 
		var activeTab = $(this).find("a").attr("href");
		$(activeTab).fadeIn(); 
		return false;
	});
});

/* 2015.8.31 STL서치에서 시분초 제어를 위함*/
//$('input[name=d]').eq(1).attr('checked', true);
//	$('input[name=q]').eq(1).attr('checked', true);
//	$('input[name=c]').eq(1).attr('checked', true);

//	$('div.my_value').each(function(){
  //         var default_value = $(this).next('.i_list').find('input[checked]').next('label').text();
    //       $(this).text(default_value);
//});
/* // 2015.8.31 STL서치에서 시분초 제어를 위함*/
