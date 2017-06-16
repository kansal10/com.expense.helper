function getCategoryTypeResultsHTMLString(result) {

	result.forEach(function(item) {

		var uniqueNumber = getRandomInt();
		var categoryItemsTableIdParentDivId = "category-type-content-items-table-parent-div-" + uniqueNumber;

		$$("#category-result-accordian-view ul").append(createListItem(item, categoryItemsTableIdParentDivId));

		var categoryItemsTableId = "category-type-items-table-" + uniqueNumber;
		var categoryItemsTableBodyId = "category-type-items-table-body-" + uniqueNumber;
		var table = "<div id='"
				+ categoryItemsTableId
				+ "' class='data-table'><table class='category-expenses-table'><thead><tr><th class='label-cell'>Store</th><th class='label-cell'>Spend By</th><th class='numeric-cell'>Amount</th></tr></thead><tbody id='"
				+ categoryItemsTableBodyId + "'></tbody></table></div>";

		$$("#" + categoryItemsTableIdParentDivId).append(table);

		createCategoryItemsTable(item.categoryExpenseDisplays, categoryItemsTableBodyId);
	});
}

function createListItem(categoryItem, categoryItemsTableIdParentDivId) {

	var startListItem = '<li class="accordion-item"><a href="#" class="item-content item-link">';

	var startItemInnerDiv = '<div class="item-inner">';

	var itemTitle = '<div class="item-title color-blue">' + categoryItem.categoryType
			+ '</div><div class="item-after"><span class="badge">' + categoryItem.categoryAmount + '</span></div>';

	var endItemInnerDiv = '</div></a>';

	var accordianItemContentDivStart = '<div class="accordion-item-content"><div class="content-block">';

	var accordianItemContent = "<div id='" + categoryItemsTableIdParentDivId + "'></div>";

	var accordianItemContentDivEnd = '</div></div>';

	var endListItem = '</li>';

	return startListItem + startItemInnerDiv + itemTitle + endItemInnerDiv + accordianItemContentDivStart
			+ accordianItemContent + accordianItemContentDivEnd + endListItem;
}

function createCategoryItemsTable(categoryExpenseDisplays, categoryItemsTableBodyId) {

	var tbody = '';

	categoryExpenseDisplays.forEach(function(item) {

		tbody += "<tr><td class='label-cell'>" + item.storeDescription
				+ "</td><td class='label-cell'>" + item.expenseBy + "</td><td class='numeric-cell'>" + item.amount
				+ "</td></tr>";

	});

	$$("#" + categoryItemsTableBodyId).html(tbody);
}

function getRandomInt() {
	min = Math.ceil(100);
	max = Math.floor(500);
	return Math.floor(Math.random() * (max - min)) + min;
}