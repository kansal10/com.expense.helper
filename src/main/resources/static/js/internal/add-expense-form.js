/**
 * 
 */
function getFormDetails() {
	
    return {
        "expenseAmount": parseFloat($$("#expense-amount").val(), 10),
        "comments": $$("#comments").val(),
        "expensedOn": new Date($$("#expensedOn").val()),
        "categoryType": $$("#category").val(),
        "storeDescription": $$("#store-description-autocomplete").val(),
        "expensedBy": $$("#spendBy").val()
    }
}

/**
 * Gets the current date formatted in the format "YYYY-MM-DD".
 */
function zerofill(i) {
    return (i < 10 ? '0' : '') + i;
}

function getCurrentDateString() {
    const date = new Date();
    const year = date.getFullYear();
    const month = zerofill(date.getMonth()+1);
    const day = zerofill(date.getDate());
    return year + '-' + month + '-' + day;
}

//set date field with current date
//var currentDate = ;


