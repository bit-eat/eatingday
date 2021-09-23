$(document).ready(function() {
	$("td[name='name']").on("click", function() {
		var name = $(this).closest('td').attr('value') + "";
		$('input[id=name]').val(name);
		$("#detail").attr("action", "detail");
		$("#detail").submit();
	});
});