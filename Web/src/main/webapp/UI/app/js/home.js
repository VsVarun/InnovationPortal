jQuery(document).ready(function($){
	$('#iFrame').prop('src', 'IconMenus.html');
	
	$('#navigation a').click(function() {
	    $('#navigation a').removeClass('highlight');
	    $(this).addClass('highlight');
	});
});

function loadFrame(liID, url){
	$('#iFrame').prop('src', url);
	//$('#iFrame').prop('height', '91%');
}
