jQuery(document).ready(function($){
	
	sessionStorage.setItem('userName','prsch');
	
	loadIdeaTable(sessionStorage.getItem('userName'));
	
});

function loadIdeaTable(userName){
	var myIdeasURL = "../../../Services/Idea/getUserIdeasAsTable/".concat(userName);
	getHMTL(myIdeasURL, function (innerHTML) {
		$("#IdeaTableBody").html(innerHTML);
		$("#IdeaTable").bootstrapTable();
    }, null);
}
