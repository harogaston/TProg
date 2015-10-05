$(document).ready(function() {
	$('#userName').blur(function(event) {
		var name = $('#userName').val();
		$.get('JqueryServlet', {
			userName : name
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
