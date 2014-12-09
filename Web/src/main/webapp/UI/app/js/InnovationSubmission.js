jQuery(document).ready(function($){
	
	loadCategoryList();
	
	$( function() {
		$( '#CategoryList' ).dropdown();
	});
		    
});	

function loadCategoryList(){
	getHMTL("../../../Services/Category/getAllAsDropDown", function (innerHTML) {
		document.getElementById("CategoryDropDown").innerHTML = innerHTML;
    }, null);
}