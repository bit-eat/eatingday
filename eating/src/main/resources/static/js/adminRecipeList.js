	$(document).ready(function() {
		$("#submitfrm").on("click", function() {
			var param = new Array;
			$(".chkclass:checked").each(function() {
				param.push($("#id").val())
			});
			$("#form").attr("action", "adminRecipedelete");
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