/**
 * 
 */
var fruits = ('Costco IndianStore PriceChopper Walmart Burlington 888 Cerner HomeDepot Target HenHouse TacoBell CernerClinic Macys Amazon DestinationMaternity BuyBuyBaby Sams WaterOne KCPL CarInstallment HomeInstallment Garbage PhoneBill WasteWater').split(' ');

var autocompleteDropdownSimple = myApp.autocomplete({
	input : '#store-description-autocomplete',
	openIn : 'dropdown',
	source : function(autocomplete, query, render) {
		var results = [];
		if (query.length === 0) {
			render(results);
			return;
		}

		// Find matched items
		for (var i = 0; i < fruits.length; i++) {
			if (fruits[i].toLowerCase().indexOf(query.toLowerCase()) >= 0) {
				results.push(fruits[i]);
			}
		}

		// Render items by passing array with result items
		render(results);
	}
});