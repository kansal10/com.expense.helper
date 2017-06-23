/**
 * 
 */
function getFormDetails() {
	
    return {
        "expenseAmount": parseFloat($$("#expense-amount").val(), 10),
        "comments": $$("#comments").val(),
        "expenseDateTime": new Date($$("#expenseDateTime").val()),
        "categoryType": $$("#category").val(),
        "storeDescription": $$("#store-description-autocomplete").val(),
        "spendBy": $$("#spendBy").val(),
        "spendOn": $$("#spendOn").val()
    }
}

function setFormFieldsToDefaultState() {
        $$("#expense-amount").val('');
         $$("#comments").val('');
        $$("#expenseDateTime").val(getCurrentDateString());
        $$("#store-description-autocomplete").val('');
        
        var category = $$("#category");
        category.val(category.find('option[selected]').val());
        
        var spendOn = $$("#spendOn");
        spendOn.val(spendOn.find('option[selected]').val());
        
        var spendBy = $$("#spendBy");
        spendBy.val(spendBy.find('option[selected]').val());
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


