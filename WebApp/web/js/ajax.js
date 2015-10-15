$(document).ready(function () {
	$('#nickname').blur(function (event) {
		var name = $('#nickname').val();
		$.get('JqueryServlet', {
			nickname: name
		}, function (responseText) {
			var div = $('#ajaxResponse');
			if (responseText === 'OK') {
                            div.text('').html('<div><h4><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Nickname disponible</h4></div>');
                            				
			} else if (responseText === 'EN_USO') {
				div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> El nickname ingresado no esta disponible</h4></div>');
			}else if (responseText === 'SIN_ESPACIOS') {
				div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> No debe contener espacios</h4></div>');
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
                                div.text('').html('<div><h4><i class="glyphicon glyphicon-ok"></i> <a style="color:##00FF00"> Email disponible</h4></div>');
			} else if (responseText === 'EN_USO') {
				div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> El email no esta disponible</h4></div>');
			}else if (responseText === 'SIN_ESPACIOS') {
                                div.text('').html('<div><h4><i class="glyphicon glyphicon-warning-sign"></i> <a style="color:#FF0000"> No debe contener espacios</h4></div>');
				
			};
		});
	});
});
