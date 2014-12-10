jQuery(document).ready(function($){
	
	loadCategoryList();
	loadTeamList();
	
	$("#IdeaSubmission").submit(function(event){
		postJSon("../../../Services/Idea/Submit", buildPostData(), function (response) {
			if(response.statusCode == 200){
				swal("Idea Submitted!!!", "Thanks for your Valuable Submission...", "success");	
			}else{
				swal("Idea Submission Failed!!!", response.statusDesc, "error");
			}
	    }, null);
		
		// Cancel the actual Submission
		event.preventDefault();
	});
	
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

function buildPostData(){
	var idea = {
		categoryName : $( "#CategoryList" ).val(),
		teamName : $( "#TeamList" ).val(),
		summary : $( "#ideaSummary" ).val(),
		description : $( "#ideaDescription" ).val(),
		benefits : $( "#ideaBenefits" ).val(),
		challenges : $( "#ideaChallenges" ).val(),
		status : "Submitted",
		userID : "prsch",
		createdDate : $.now(),
		lastModifiedDate : $.now()
	};
	return JSON.stringify(idea);
}