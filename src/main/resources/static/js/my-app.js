// Initialize your app
var myApp = new Framework7();

// Export selectors engine
var $$ = Dom7;

// Add view
var mainView = myApp.addView('.view-main', {
	// Because we use fixed-through navbar we can enable dynamic navbar
	dynamicNavbar : true
});

var host = window.location.hostname;

$$("#expenseDateTime").val(getCurrentDateString());

retrieveResultsByCategory();

$$('.submit-button').on('click', function(e) {

	let details = getFormDetails();

	// console.log(JSON.stringify(details));

	var jsonData = JSON.stringify(details);
//	var requestURLAddExpense = "http://" + host + ":8080/api/addExpense";
	var requestURLAddExpense = "http://" + host + ":8080/expensehelper/api/addExpense";

//	 myApp.alert(jsonData);

	$$.ajax({
		url : requestURLAddExpense,
		type : "POST",
		data : jsonData,
		dataType : "json",
		contentType : "application/json",
		cache : false,
		complete : function(xhr, textStatusxhr, status) {
			if (xhr.status.toString() == "201") {
				myApp.alert("Success!!!");
				// mainView.router.refreshPage();
				setFormFieldsToDefaultState();
			} else {
				myApp.alert("Error" + xhr.responseText);
			}
		}
	});
})

// To refresh the expense retrieval
$$('#expense-refresh-button').on('click', function(e) {
	retrieveResultsByCategory();
});

function retrieveResultsByCategory() {
//	var apiPath = "http://" + host + ":8080/api/getExpensesByCategory";
	var apiPath = "http://" + host + ":8080/expensehelper/api/getExpensesByCategory";

	$$.ajax({
		url : apiPath,// "http://localhost:8080/api/getExpensesByCategory",
		type : "POST",
		// data : jsonData,
		dataType : "json",
		contentType : "application/json",
		cache : false,
		complete : function(data) {
//			 console.log(data.responseText);
			$$("#category-result-accordian-view ul").empty();
			getCategoryTypeResultsHTMLString(JSON.parse(data.responseText));
		}
	});
}