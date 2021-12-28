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
		/*
		$frm = $("#frm_board")[0];
		$frm.action = "board.brd?job=insertSave";
		//$frm.enctype = "multipart/form-data";
		$frm.submit();
		*/
		
		$param = $("#frm_board").serialize();
		$.post("board.brd?job=insertSave", $param, function(flag){
			var $fd = $("#frm_upload")[0];
			$fd.enctype="multipart/form-data";
			$fd.action = "board.boardUp?job=i";
			$fd.submit();
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
	
	$("#btnModifySave").click(function(){
		$("#pwd_check").show();
	})

	
	$("#btnReply").click(function(){
		$frm = $("#frm_board")[0];
		$frm.action = "repl";
		$frm.submit();
	})
	
	$("#btnReplySave").click(function(){
		$param = $("#frm_board").serialize();
		$.post("board.brd?job=replSave", $param, function(flag){
			var $fd = $("#frm_upload")[0];
			$fd.enctype="multipart/form-data";
			$fd.action = "board.boardUp?job=r";
			$fd.submit();
		})
	})
	
	$("#btnDelete").click(function(){
		$("#pwd_check").show();
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
					url : 'delete.summerUp?flag=delete',
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
		url 		: 'upload.summerUp',
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
	target.src = img;
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

function pwdCheckSave(){
	$param = $("#frm_board").serialize();
	$.post("board.brd?job=modifySave", $param, function(){
		$frm = $("#frm_upload")[0];
		$frm.enctype='multipart/form-data';
		$frm.action = "board.boardUp?job=m";
		$frm.submit();
	})
}
function pwdCheckDelete(){
	$frm = $("#frm_board")[0];
	$frm.action = "board.brd?job=delete";
	$frm.submit();
}












