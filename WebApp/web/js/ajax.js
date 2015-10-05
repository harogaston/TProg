$(document).ready(function () {
	$('#nickname').blur(function (event) {
		var name = $('#nickname').val();
		$.get('JqueryServlet', {
			nickname: name
		}, function (responseText) {
			var div = $('#ajaxResponse');
			if (responseText === 'OK') {
				div.text("Nickname disponible.");
			} else if (responseText === 'EN_USO') {
				div.text("El nickname ingresado no esta disponible.");
			}else if (responseText === 'SIN_ESPACIOS') {
				div.text("No debe contener espacios.");
			};
		});
	});
});

$(document).ready(function () {
	$('#mail').blur(function (event) {
		var name = $('#mail').val();
		$.get('AjaxMail', {
			mail: name
		}, function (responseText) {
			var div = $('#ajaxResponse2');
			if (responseText === 'OK') {
				div.text("Email disponible.");
			} else if (responseText === 'EN_USO') {
				div.text("El email ingresado no esta disponible.");
			}else if (responseText === 'SIN_ESPACIOS') {
				div.text("No debe contener espacios.");
			};
		});
	});
});
