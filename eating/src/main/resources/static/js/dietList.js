	$(document).ready(function() {
		document.getElementById("insertDietOpen").onclick = function() {
			document.getElementById("modalInsert").style.display = "block";
		}
		document.getElementById("insertModalClose").onclick = function() {
			document.getElementById("modalInsert").style.display = "none";
		}
		
		document.getElementById("updateDietOpen").onclick = function() {
			document.getElementById("modalUpdate").style.display = "block";
		}
		document.getElementById("updateModalClose").onclick = function() {
			document.getElementById("modalUpdate").style.display = "none";
		}
		
		document.getElementById("deleteDietOpen").onclick = function() {
			document.getElementById("modalDelete").style.display = "block";
		}
		document.getElementById("deleteModalClose").onclick = function() {
			document.getElementById("modalDelete").style.display = "none";
		}
		
		
		
	});
	