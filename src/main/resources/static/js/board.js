/**
 * 게시판 스크립트 2021. 12. 09. 곽은정
jquery를 사용
 */
function brd(){
	
}

brd.view = function(serial){
	$frm = $("#frm_search")[0];
	$frm.serial.value = serial;
	$frm.action = "view";
	$frm.submit();
	
}	

brd.page = function(nowPage){
	$frm = $("#frm_search")[0]
	$frm.nowPage.value = nowPage;
	$frm.action = "list";
	$frm.submit();
}
/*
brd.submit = function(frmId, url){
	$frm = $(frmId)[0];
	$frm.action = "board.brd?job=" + url
	$frm.submit();

}
*/
	
$(function(){
	$frm = $("#frm_search")[0];
	
	$("#btnSearch").click(function(){
		$frm.action = "list";
		$frm.nowPage.value = 1;
		$frm.submit();
		/*
		brd.submit('#frm_search', list);
		*/
	})
	
	$("#btnInsert").click(function(){
		$frm.action = "insert";
		$frm.submit();
	})

	$("#btnSave").click(function(){		
		$param = $("#frm_board").serialize();
		$.post("insertSave", $param, function(data){
			//param이 frm_board의 모든 정보를 추출하고, 그걸 data가 받음. 스프링으로 가면 그걸 vo가 받음.
			var json = JSON.parse(data);
			
			if(json.flag == 'OK'){
				var $fd = $("#frm_upload")[0];
				$fd.grp.value = json.grp;
				$fd.enctype="multipart/form-data";
				$fd.action = "fileUp?job=i";
				$fd.submit();
			}else{
				alert("저장 중 오류 발생");
			}
		})
	})

	$("#btnList").click(function(){
		$frm = $("#frm_board")[0];
		$frm.action = "list";
		$frm.submit();
	})
	
	$("#btnModify").click(function(){
		$frm = $("#frm_board")[0];
		$frm.action = "modify";
		$frm.submit();
	})
	
	$("#btnModifySave").click(function() {
		$("#pwd_check").show();
	})

	
	$("#btnReply").click(function(){
		$frm = $("#frm_board")[0];
		$frm.action = "repl";
		$frm.submit();
	})
	
	$("#btnReplySave").click(function(){
		$param = $("#frm_board").serialize();
		$.post("replSave", $param, function(data){
			var json = JSON.parse(data);
			if (json.flag == "OK") {
				var $fd = $("#frm_upload")[0];
				$fd.grp.value = json.grp;
				$fd.enctype = "multipart/form-data";
				$fd.action = "fileUp?job=r";
				alert($fd.serial.value)
				$fd.submit();
			}else{
				alert("답변 글 저장 중 오류 발생");
			}	
		})
	})
	
	$("#btnDelete").click(function(){
		$("#pwd_check").show();
		$("#modal #btnPwdCheckDelete").click(function() {
			$("id_check").css("display", "none");
			$("#frm_board")[0].pwd.value = $("#inputPwd").val();
			$frm = $("#frm_board")[0];
			$frm.action = "delete";
			$frm.submit();
		})
	})

})

var loadInterval = []; //이미지가 서버에 upload 되었는지 체크하는 기능
function summer(){	
	var fonts = [
		"맑은 고딕", "고딕", "돋움", "바탕", "바탕체", "굴림", "굴림체"
	]
	fonts.sort();
	
	$("#summernote").summernote({
		height: 300,
		fontNames: fonts,
		callbacks: {
			onImageUpload : function(files){
				loadInterval.length = files.length;
				$("#frm_board").addClass("spinner");
				for(var i = files.length-1; i>=0; i--){
					sendFile(i, files[i])
				}
			},
			onMediaDelete : function(target){
				var file = decodeURI(target[0].src);
				$.ajax({
					data : {target : file},
					type : 'POST',
					url : 'summerDelete',
					cache : false,
					success : function(msg){}
				})
			}
		}
	});
}

function sendFile(intervalPos, file){
	var form_data = new FormData(); //form tag 생성
	form_data.append('file', file);
	$.ajax({
		data 		: form_data,
		type 		: 'POST',
		url 		: 'summerUp',
		enctype 	: 'multipart/form-data',
		cache	 	: false,
		contentType : false,
		processData : false,
		success		: function(img){
			loadInterval[intervalPos] =
			setInterval(loadCheck.bind(null, intervalPos, img), 1500);
		}
	})
}

function loadCheck(pos, img){
	var target = new Image(); //업로드 될 이미지
	target.onload = function() { //이미지가 모두 서버에 저장된 상태
		clearInterval(loadInterval[pos]);
		$('#summernote').summernote('editor.insertImage', img)
		$("#frm_board").removeClass("spinner");
	}
	target.src = img;
}


function pwdCheckClose(){
	$("#pwd_check").css("display","none");
}

function pwdCheckDelete(){
	$("#frm_board")[0].pwd.value = $("#modalPwd").val();
	console.log($("#modalPwd").val());
	$frm = $("#frm_board")[0];
	$frm.action = "delete";
	$frm.submit();
}

function pwdCheckSave(){
	$("id_check").css("display", "none");
	$("#frm_board")[0].pwd.value = $("#modalPwd").val();
	$param = $("#frm_board").serialize();
	//alert($("#delFile").is(":checked")==true)
	$.post("modifySave", $param, function(data){
		var json = JSON.parse(data);
		if (json.flag == "OK") {
			var $fd = $("#frm_upload")[0];
			$fd.enctype = "multipart/form-data";
			$fd.action = "fileUp?job=m";
			$fd.submit();
		} else {
			alert("수정 중 오류 발생");
		}
	})
}