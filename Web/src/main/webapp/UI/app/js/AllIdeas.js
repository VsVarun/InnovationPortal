jQuery(document).ready(function($){
	
	loadIdeaTable();
	
});

function loadIdeaTable(){
	getHMTL("../../../Services/Idea/getAllAsTable", function (innerHTML) {
		$("#IdeaTableBody").html(innerHTML);
		$("#IdeaTable").bootstrapTable();
    }, null);
}
