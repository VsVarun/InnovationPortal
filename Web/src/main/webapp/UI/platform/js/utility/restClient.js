/**
* restClient.js
* Author 	: Varun
* Date		: 21/2/2013
* This is an rest client api for making get and post calls.
* [GET] 	- {getJSon,get}
* [POST]	- {postJSon,post}
*/

/**
* Global Initialization
*/
var headerIdentifier = { key: "", value: "" };

function postJSon(relativeURL, jsonData, callback, headers) {
    var xdr = new XMLHttpRequest();
    xdr.open("POST", relativeURL);
    xdr.setRequestHeader("Content-Type", "application/json");
    xdr.setRequestHeader("Content-Encoding", "UTF-8");
    if (headers != null && headers.length != 0) setHeaders(xdr, headers);
    xdr.send(jsonData);
    
    xdr.onreadystatechange = function () {
    	if(xdr.readyState == 4){
    		var response = buildResponse(xdr);
    		if(response != null){
    			callback(response);
    		}
    	}	
    };
}

function buildResponse(xdr){
	var respStatus = "";
	if (xdr.status == 200) {
		respStatus = "OK";
    }
	else if (xdr.status == 400) {
		respStatus = "Bad Request";
    }
	else if (xdr.status == 401) {
		respStatus = "UnAuthorized";
    }
	else if (xdr.status == 403) {
		respStatus = "Forbidden";
    }
    else if (xdr.status == 404) {
    	respStatus = "Service Not Found";
    }
    else if (xdr.status == 500) {
    	respStatus = "Internal Error";
    }
    else if (xdr.status == 501) {
    	respStatus = "Service Implemented";
    }
    else if (xdr.status == 502) {
    	respStatus = "Service temporarily Overloaded";
    }
    else if (xdr.status == 503) {
    	respStatus = "Gateway Timeout";
    }
    else if (xdr.status == 0) {
    	respStatus = "No Transport";
    }
	var response = null;
	if(respStatus != ""){
		response = {
			statusCode : xdr.status,
			statusDesc : respStatus,
			data :  xdr.responseText
		};
	}
	return response; 
}

function post(relativeURL, data, callback, headers) {
    if (data != null) data = JSON.stringify(data);
    postJSon(relativeURL, data, function (retJSon,StartTime, EndTime, ElapsedTime) {
        if (retJSon.indexOf("Exception") >= 0)
            callback(retJSon);
        else
            callback(JSON.parse(retJSon),StartTime, EndTime, ElapsedTime);
    }, headers);
}

function postRequest(relativeURL, data, callback, headers) {
    if (data != null) data = JSON.stringify(data);
    postJSon(relativeURL, data, function (retJSon, StartTime, EndTime, ElapsedTime) {
        if (retJSon.indexOf("Exception") >= 0)
            callback(retJSon);
        else
            callback(retJSon, StartTime, EndTime, ElapsedTime);
    }, headers);
}

function getJSon(relativeURL, callback, headers) {
    var xdr = new XMLHttpRequest();
    xdr.open("GET", sessionStorage.SVC_BASE_URL + relativeURL);
    //    xdr.setRequestHeader("Content-Type", "application/json");
    //    xdr.setRequestHeader("Content-Encoding", "UTF-8");
    setDefaultHeaders(xdr);
    if (headers != null && headers.length != 0) setHeaders(xdr, headers);
    xdr.onreadystatechange = function () {
        if (xdr.readyState == 4 && xdr.status == 200) {
            callback(xdr.responseText);
        }
    };
    xdr.send();
}

function getHMTL(url, callback, headers) {
    var xdr = new XMLHttpRequest();
    xdr.open("GET", url);
    setHTMLHeaders(xdr);
    if (headers != null && headers.length != 0) setHTMLHeaders(xdr, headers);
    xdr.onreadystatechange = function () {
        if (xdr.readyState == 4 && xdr.status == 200) {
            callback(xdr.responseText);
        }
    };
    xdr.send();
}

function get(relativeURL, callback, headers) {
    getJSon(relativeURL, function (retJSon) {
        if (typeof REST_CONSTANTS !== "undefined") {
            if (retJSon.indexOf(REST_CONSTANTS.UN_AUTHORIZED_TICKET) >= 0) {
                sessionStorage.clear();
                var CloseClass = "no-close";
                createAlert("OK", sessionExpireTitle, sessionExpireMsg, okCallback, CloseClass);
                $("#dialogAlert").dialog("open");
            }
            else {
                callback(JSON.parse(retJSon));
            }
        }
        else {
            callback(JSON.parse(retJSon));
        }
    }, headers);
}

/**
 * This method sets the default custom headers to the request.
* @param request
*/
function setDefaultHeaders(xdr) {
    xdr.setRequestHeader("Pragma", "no-cache");
    xdr.setRequestHeader("Cache-Control", "no-cache");
    xdr.setRequestHeader("Content-Type", "application/json");
    xdr.setRequestHeader("Accept", "application/json");
    xdr.setRequestHeader("Content-Encoding", "UTF-8");
}

/**This method sets the default custom headers to the request.
* @param request
*/
function setHTMLHeaders(xdr) {
    xdr.setRequestHeader("Pragma", "no-cache");
    xdr.setRequestHeader("Cache-Control", "no-cache");
    xdr.setRequestHeader("Accept", "text/html");
    xdr.setRequestHeader("Content-Encoding", "UTF-8");
}

/**This Method sets the custom Headers
* @param request
* @param headers
*/
function setHeaders(request, headers) {
    if (headers != undefined) {
        $(headers).each(function () {
            request.setRequestHeader(this.key, this.value);
        });
    }
}
function okCallback() {
    if (sessionStorage.loginPage != undefined)
        window.parent.location.href = sessionStorage.loginPage;
    else
        window.parent.location.href = $.cookie("loginPage");
}