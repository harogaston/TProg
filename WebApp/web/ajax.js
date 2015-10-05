$(document).ready(function() {
	$('#nickname').blur(function(event) {
		var name = $('#nickname').val();
		$.get('JqueryServlet', {
			nickname : name
		}, function(responseText) {
			$('#ajaxResponse').text(responseText);
		});
	});
});

$(document).ready(function() {
	$('#mail').blur(function(event) {
		var name = $('#mail').val();
		$.get('AjaxMail', {
			mail : name
		}, function(responseText) {
			$('#ajaxResponse2').text(responseText);
		});
	});
});
