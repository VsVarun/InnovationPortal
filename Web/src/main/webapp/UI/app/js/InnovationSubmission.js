jQuery(document).ready(function($){
	
	loadCategoryList();
	loadTeamList();
		    
});	

function loadCategoryList(){
	getHMTL("../../../Services/Category/getAllAsDropDown", function (innerHTML) {
		document.getElementById("CategoryDropDown").innerHTML = innerHTML;
    }, null);
}

function loadTeamList(){
	getHMTL("../../../Services/Team/getAllAsDropDown", function (innerHTML) {
		document.getElementById("TeamDropDown").innerHTML = innerHTML;
    }, null);
}