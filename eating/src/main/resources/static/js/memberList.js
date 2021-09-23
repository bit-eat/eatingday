
// 수정, 확인 버튼
	function btn(test){
		var check = $("[name='update']").val();
		var update = document.getElementById(test.getAttribute('id')).getAttribute('id') ;
		var updateok = Number(update)+10;
	
		if(check=="수정"){
			document.getElementById(update+"").style.display = "none";
			document.getElementById(updateok+"").style.display = "block";
			var inputName = "#name"+update;
			var inputPhone = "#phoneNumber"+update;
			var inputGarde = "#grade"+update;
			$(inputName).attr('readonly', false);
			$(inputPhone).attr('readonly', false);
			$(inputGarde).attr('readonly', false);
		}
	}
	
	// 이름, 전화번호, 등급 수정
	function btn2(test){
		var check = $("[name='updateok']").val();
		var updateok = document.getElementById(test.getAttribute('id')).getAttribute('id') ;
		var update = Number(updateok)-10;
	
		if(check=="확인"){
			var inputName = "#name"+update;
			var inputPhone = "#phoneNumber"+update;
			var inputGarde = "#grade"+update;
			$(inputName).attr('readonly', true);
			$(inputPhone).attr('readonly', true);
			$(inputGarde).attr('readonly', true);
			
			var checkBtn = $("input[id="+updateok+"]");
				
			var tr = checkBtn.parent().parent();
			var td = tr.children();
			
			var id = td.eq(0).find('input').val();
			var userid = td.eq(1).text();
			var userpw = td.eq(2).text();
			var name = td.eq(3).find('input').val();
			var phone = td.eq(4).find('input').val();
			var grade = td.eq(5).find('input').val();
							
			$('input[id=id]').val(id);
			$('input[id=userId]').val(userid);
			$('input[id=userPw]').val(userpw);
			$('input[id=userName]').val(name);
			$('input[id=phoneNumber]').val(phone);
			$('input[id=grade]').val(grade);
			$("#updateMemberList").attr("action","updateMemberList");
			$("#updateMemberList").submit();
			
			document.getElementById(updateok+"").style.display = "none";
			document.getElementById(update+"").style.display = "block";
		}
	}


	// 체크박스
	$(document).ready(function() {
		$("#submitForm").on("click", function() {
			var param = new Array;
			$(".chkclass:checked").each(function() {
				param.push($("#id").val())
			});
			$("#form").attr("action", "deletecheck");
			$("#form").submit();
		});
	});

	$(function() {
		var chkObj = document.getElementsByName("id");
		var rawCnt = chkObj.length;

		$("input[name='allCheck']").click(function() {
			var chk_listArr = $("input[name='id']");
			for (var i = 0; i < chk_listArr.length; i++) {
				chk_listArr[i].checked = this.checked;
			}
		});
		$("input[name='id']").click(function() {
			if ($("input[name='id']:checked").length == rowCnt) {
				$("input[name='allCheck']")[0].checked = true;
			} else {
				$("input[name='allCheck']")[0].checked = false;
			}
		});
	});

	var checkRows = $("[name='allCheck']:checked");
	for (var i = checkRows.length - 1; i > -1; i--) {
		checkRows.eq(i).closest('tr').remove();
	}
