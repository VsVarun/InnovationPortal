jQuery(document).ready(function($){
	
	loadCategoryList();
	loadTeamList();
	
    $("#IdeaSubmission").submit(function (event) {
      
        var validationstatus = innovationsubValidation();
      // alert(innovationsubValidation());

        if (validationstatus == true) {
          // alert('posted');
           postJSon("../../../Services/Idea/Submit", buildPostData(), function (response) {
               if (response.statusCode == 200) {
                   swal("Idea Submitted!!!", "Thanks for your Valuable Submission...", "success");
               } else {
                   swal("Idea Submission Failed!!!", response.statusDesc, "error");
               }
           }, null);
       }

       else {

           // Cancel the actual Submission
           event.preventDefault();
       }

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


function innovationsubValidation() {
    var validationstatus = true;
    var missingfields = '';
    var missingfieldcount = 0;
   

    if($("#ideaSummary").val()=='') {
        validationstatus = false;
        missingfields = 'Summary' + ', ';
        missingfieldcount = 1;
    }
    if ($("#ideaDescription").val() == '') {
        validationstatus = false;
        missingfields = missingfields + 'Description' + ', ';
        missingfieldcount = missingfieldcount + 1;
    }
    if ($("#ideaBenefits").val() == '') {
        validationstatus = false;
        missingfields = missingfields  + 'Benefits' + ', ';
        missingfieldcount = missingfieldcount + 1;
    }
    if ($("#ideaChallenges").val() == '') {
        validationstatus = false;
        missingfields = missingfields + 'Challenges' + ', ';
        missingfieldcount = missingfieldcount + 1;
    }
   
    //alert(Boolean(validationstatus));
    //alert(parseInt(missingfieldcount));

    if (Boolean(validationstatus) == false) {
        if (parseInt(missingfieldcount) == 1) {
            swal(missingfields.replace(',','') + " field is missing!!!", "Please enter missing fields...", "warning");
        }
        else {
            swal(missingfields + " field's are missing!!!", "Please enter missing fields...", "warning");
        }
    }
   
     return Boolean(validationstatus);
}